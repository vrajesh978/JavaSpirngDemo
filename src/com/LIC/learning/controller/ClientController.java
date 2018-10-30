package com.LIC.learning.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.LIC.learning.form.ClientForm;
import com.LIC.learning.model.Client;
import com.LIC.learning.service.ClientService;

@Controller
@SessionAttributes({ ClientForm.FORM_NAME })
public class ClientController {

	@Resource(name = "ClientService")

	@Autowired
	private ClientService clientServiceImpl;

	private static final Logger logger = Logger.getLogger(ClientController.class);
	private static final String VIEW_CLIENTS = "getAllClients";
	private static final String ADD_CLIENT = "registration";
	// private static final String AUTHORIZE = "login";

	@RequestMapping(value = "/viewRegisteredClients", method = RequestMethod.GET)
	public ModelAndView getAllClients() throws SQLException {
		List<Client> clList = clientServiceImpl.getAllRecords();
		logger.debug("viewAllRegisteredClients called ");
		ModelAndView andView = new ModelAndView(VIEW_CLIENTS, "clList", clList);
		return andView;
	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public ModelAndView addIndividual() throws SQLException {
		ModelAndView modelAndView = new ModelAndView(ADD_CLIENT, ClientForm.getFormName(), new ClientForm());
		logger.debug("SignUp called ");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("clientForm") ClientForm clientForm, BindingResult result)
			throws Exception {
		System.out.println("ID(Client) : " + clientForm.getId());
		Client client = clientForm.toModel(Client.class);
		System.out.println(client.toString());
		clientServiceImpl.save(client);
		return "redirect:/viewRegisteredClients.html";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editIndividual(@RequestParam("id") Long id) throws Exception {
		Client client = clientServiceImpl.getClientById(id);
		return new ModelAndView(ADD_CLIENT, ClientForm.getFormName(), client.toForm(ClientForm.class));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteIndividual(@RequestParam("id") Long id) throws Exception {
		System.out.println("Delete called .. Thanks a lot.");
		clientServiceImpl.delete(id);
		return "redirect:/viewRegisteredClients.html";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchIndividual(@RequestParam("searchQuery") String searchQuery) throws Exception {
		List<Client> clList;
		// if search is empty string we display all the users
		System.out.println("SEARCH: " + searchQuery);
		if (searchQuery != "")
			clList = clientServiceImpl.search(searchQuery);
		else
			clList = clientServiceImpl.getAllRecords();
		return new ModelAndView(VIEW_CLIENTS, "clList", clList);
	}

}
