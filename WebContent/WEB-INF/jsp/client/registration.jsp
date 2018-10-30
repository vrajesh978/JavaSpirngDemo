<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="save.html" var="saveUrl" />
<c:set var="baseUrl" value="static"></c:set>


<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
	<div class="wrapper wrapper--w680">
		<div class="card card-4">
			<div class="card-body">
				<h2 class="title">Registration Form</h2>
				<form:form action="${saveUrl}" method="POST"
					modelAttribute="clientForm">
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label class="label">first name</label>
								<form:input class="input--style-4" type="text" path="firstName"
									name="first_name" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<label class="label">last name</label>
								<form:input class="input--style-4" type="text" path="lastName"
									name="last_name" />
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label class="label">Birthday</label>
								<div class="input-group-icon">
									<form:input class="input--style-4 js-datepicker" type="text"
										name="birthday" path="dob" />
									<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
								</div>
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<label class="label">Gender</label>
								<div class="p-t-10">
									<label class="radio-container m-r-45">Male <form:radiobutton
											path="gender" value="Male" checked="true" /> <span
										class="checkmark"></span>
									</label> <label class="radio-container">Female <form:radiobutton
											path="gender" value="Female" /> <span class="checkmark"></span>
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label for="AddressLine1" class="label">Address Line1</label>
								<form:input class="input--style-4" name="addressLine1"
									type="text" path="address.add1" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<label for="AddressLine2" class="label">Address Line2</label>
								<form:input class="input--style-4" name="addressLine2"
									type="text" path="address.add2" />
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label for="ZipCode" class="label">Postal Code</label>
								<form:input class="input--style-4" name="zipcode" type="text"
									path="address.zipCode" />
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label class="label">Username</label>
								<form:input class="input--style-4" type="text" name="username"
									path="userName" />
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label class="label">Email</label>
								<form:input class="input--style-4" type="email" name="email"
									path="email" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<label class="label">Phone Number</label>
								<form:input class="input--style-4" type="text" name="phone"
									path="mobileNo" />
							</div>
						</div>
					</div>

					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<label class="label">Password</label>
								<form:input class="input--style-4" type="password"
									name="password" path="pwd" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<label class="label">Confirm Password</label>
								<form:input class="input--style-4" type="password"
									name="cpassword" path="" />
							</div>
						</div>
					</div>

					<div class="row row-space">
						<div class="col-2">
							<div class="p-t-15">
								<button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
							</div>
						</div>
						<div class="col-2">
							<div class="p-t-15">
								<button class="btn btn--radius-2 btn--blue" type="reset">
									Reset</button>
							</div>
						</div>
						<div class="col-1">
							<div class="p-t-15">
								<button class="btn btn--radius-2 btn--blue" type="button"
									onclick="goBack()">Back</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

<!-- Jquery JS-->
<script src="${baseUrl}/vendor/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="${baseUrl}/vendor/select2/select2.min.js"></script>
<script src="${baseUrl}/vendor/datepicker/moment.min.js"></script>
<script src="${baseUrl}/vendor/datepicker/daterangepicker.js"></script>

<!-- Main JS-->
<script src="${baseUrl}/js/global.js"></script>
<!-- For go back script -->
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>