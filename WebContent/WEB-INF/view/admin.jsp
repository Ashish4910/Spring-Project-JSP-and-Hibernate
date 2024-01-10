
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>

<html>
<title>Admin page</title>
<head>


<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->



<style>
/* Add custom CSS styles here */
table.table {
	font-size: 25px; /* Adjust the font size as needed */
	margin-top: 20px;
}

.ashish {
	margin-top: 30px;
}

table.table td {
	font-size: 18px; /* Adjust the font size for the table cells (td) */
}
</style>
</head>

<body>



	<div class="container">
		<div class="row ">


			<table class="table table-striped ">
				<thead>
					<a href="registration"
						class="btn btn-primary btn-xs pull-right   ashish"><b>+</b>
						Add new categories</a>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Email ID</th>
						<th>Phone</th>
						<th>Designation</th>
						<th>Password</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<c:forEach var="tempCustomer" items="${customer}">
					<c:url var="deleteLink" value="/DeleteUser">
						<c:param name="id" value="${tempCustomer.id}"></c:param>


						<c:url var="editUser" value="/userEdit">

							<c:param name="id" value="${tempCustomer.id}"></c:param>
						</c:url>
					</c:url>

					<tr>
						<td>${tempCustomer.id}</td>
						<td>${tempCustomer.fullName}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.phone}</td>
						<td>${tempCustomer.designation}</td>
						<td>${tempCustomer.password}</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							href="${editUser}"> <span class="glyphicon glyphicon-edit"></span>
								Edit
						</a> <%-- <form action="${deleteLink}" method="POST">
								<input type="submit" value="Delete">
							</form> --%> <a href="${deleteLink}"
							class="btn btn-danger btn-xs"><span
								class="glyphicon glyphicon-remove"></span> Del</a></td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>





