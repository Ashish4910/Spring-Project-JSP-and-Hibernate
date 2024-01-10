<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>

<html>
<head>
<title>User Edit</title>

<!-- 

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous">
	
</script>
 -->
<!--  Some time using older version of bootstrap properties is good -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<style>
<!--
<
link rel ="stylesheet " href ="https: //use.fontawesome.com /releases /v5.0.8
	/css /all.css ">--><!-- <style>body {
	background: background: url('https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.shopify.com%2Fstock-photos%2Fmountain&psig=AOvVaw184PLq5-vqNll-6LPoDni8&ust=1697632159664000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNiVyeCK_YEDFQAAAAAdAAAAABAE')
		no-repeat center center fixed;
	background-size: cover;
}
</style>

</head>

<body>





	<div class="container p-5">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card bg-primary">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title mt-3 text-center text-white">Edit
							Account</h4>
						<p class="text-center text-white">Give re-view with your free
							account</p>

						<form:form action="UpdateUser2" method="POST">

							<form:hidden path="id" />
							<input type="hidden" name="fullName" value="${fullName}">
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<form:input path="fullName" class="form-control"
									placeholder="Full name" type="text" required="required"
									value="${fullName}" />
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>
								<form:input path="email" class="form-control"
									placeholder="Email address" type="email" required="required"
									value="${email}" />
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-phone"></i>
									</span>
								</div>
								<select class="custom-select" style="max-width: 120px">
									<option selected>+91</option>
									<option value="1">+0</option>
									<option value="2">+98</option>
								</select>
								<%-- <form:input path="phone" class="form-control"
									placeholder="Phone number" type="number" required="required"
									value="${phone}" /> --%>


								<input name="phone" class="form-control"
									placeholder="Phone number" type="text" required="required"
									value="${phone}" pattern="\d{10}"
									title="Please enter a 10-digit phone number" />



							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-building"></i>
									</span>
								</div>
								<form:select path="designation" class="form-control"
									required="required" value="${designation}">
									<form:option value="" label="Select Designation type" />
									<form:option value="Admin" label="Admin" />
									<form:option value="User" label="User" />

								</form:select>
							</div>
							<%-- <!-- form-group end.// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<form:input path="password" class="form-control"
									placeholder="Create password" type="password"
									required="required" />
							</div>
							 --%>


							<!-- Inside the form group for the password field -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-eye"
										id="togglePassword"></i>
									</span>
								</div>
								<form:input path="password" class="form-control"
									placeholder="Create password" type="password"
									required="required" value="${password}" />
							</div>


							<%-- <div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-eye"
										id="togglePassword"></i>
									</span>
								</div>
								<c:forEach var="image" items="${imageBase64}">
									<img src="data:image/jpeg;base64,${image.imageBase64}"
										style="width: 70px; margin-top: 15px;">
								</c:forEach>

							</div> --%>
							<div class="form-group input-group">
								<div class="input-group-prepend text-center">

									<img src="data:image/jpeg;base64,${imageBase64}"
										style="width: 70px; margin-top: 15px;">
								</div>
							</div>

							<form:hidden path="imageBase64" value="${imageBase64}" />
							<div class="form-group input-group">
								<div class="input-group-prepend text-center">

									<input type="file" class="form-control" name="image" />
								</div>
							</div>

							<!-- JavaScript to toggle password visibility -->
							<script>
								document
										.addEventListener(
												"DOMContentLoaded",
												function() {
													const togglePassword = document
															.getElementById("togglePassword");
													const passwordInput = document
															.querySelector('input[type="password"]');

													togglePassword
															.addEventListener(
																	"click",
																	function() {
																		if (passwordInput.type === "password") {
																			passwordInput.type = "text";
																		} else {
																			passwordInput.type = "password";
																		}
																	});
												});
							</script>


							<!-- form-group// -->
							<div class="form-group">
								<button type="submit"
									class="btn btn-success btn-block text-white">Update
									Account</button>
							</div>
							<!-- form-group// -->
							<!-- <p class="text-center text-white">
								Have an account? <a href="login">Log In</a>
							</p> -->
						</form:form>
					</article>
				</div>
				<!-- card.// -->
			</div>
		</div>
	</div>
	<!--container end.//-->

</body>
</html>
