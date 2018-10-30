<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="search.html" var="searchUrl" />
<c:url value="edit.html" var="editUrl" />
<c:url value="delete.html" var="deleteUrl" />
<c:url value="SignUp.html" var="addclientUrl" />
<c:set var="baseUrl" value="static"></c:set>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div>
		<div align="right" style="margin-top: 20px; margin-right: 10px;">
			<a href="${addclientUrl}"> <img class="filter"
				style="width: 40px; height: 50px;"
				src="${baseUrl}/image/addmore.png" alt="Add More User" /></a> <br>
			<h5>Add More User</h5>
		</div>
	</div>
	<h2 align="left">
		<img class="filter" style="width: 25px; height: 30px;"
			src="${baseUrl}/image/users.png" /> All Registered Users
	</h2>
	<div align="right"
		style="position: relative; margin: 10px; margin-right: 1px;">
		<form action="${searchUrl}" method="GET">
			<input type="text" name="searchQuery" placeholder="Search"> <input
				type="submit" value="Search">
		</form>
	</div>
	<table class="rules">
		<thead>
			<tr>
				<th>Sr No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact No</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clList}" var="client" varStatus="row">
				<tr class="record">
					<td>${row.count}</td>
					<td>${client.firstName}&nbsp;${client.lastName}</td>
					<td>${client.email}</td>
					<td>${client.mobileNo}</td>
					<td>${client.dob}</td>
					<td>${client.gender}</td>
					<td>${client.address.add1},${client.address.add2},${client.address.zipCode}</td>

					<td><a href="${editUrl}?id=${client.id}"><img
							class="filter" style="width: 20px; height: 25px;"
							src="static/image/edit.png" alt="edit"></a></td>
					<td><a href="${deleteUrl}?id=${client.id}"
						onclick="return confirm('Are you sure you want to delete this record.?')"><img
							class="filter" style="width: 20px; height: 25px;"
							src="${baseUrl}/image/delete.png" alt="delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>