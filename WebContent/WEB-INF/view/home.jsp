<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Sign Up</title>
<head>
<%-- <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/style.css">
 --%>
<!-- bootstrapcdn link for css  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<!-- bootstrap link   -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">



<script src="https://kit.fontawesome.com/2f587ffd5a.js"
	crossorigin="anonymous"></script>


<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<style>
@import url('https://fonts.googleapis.com/css?family=Numans');

html, body {
	background-image:
		url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
}

.container {
	height: 100%;
	align-content: center;
}

.card {
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
}
</style>


</head>
<body>


	<div class="container">
		<div class="d-flex justify-content-center
		
		
		 h-100">
			<div class="card">
				<div class="card bg-light">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title mt-3 text-center text-white">Create
							Account</h4>
						<p class="text-center text-white">Get started with your free
							account</p>

						<form:form action="processForm" method="post"
							enctype="multipart/form-data" modelAttribute="user">

							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<form:input path="fullName" class="form-control"
									placeholder="Full name" type="text" required="required" />
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>
								<form:input path="email" class="form-control"
									placeholder="Email address" type="email" required="required" />
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-phone"></i>
									</span>
								</div>
								<select class="custom-select" style="max-width: 120px">
									<!-- <option selected disabled>Select</option> -->
									<option selected>+91</option>
									<option value="1">+0</option>
									<option value="2">+98</option>
								</select>
								<%-- <form:input path="phone" class="form-control"
									placeholder="Phone number" type="number" required="required"
									value=" " /> --%>



								<form:input path="phone" class="form-control"
									placeholder="Phone Number " required="required" value="none"
									type="number" />

							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-building"></i>
									</span>
								</div>
								<form:select path="designation" class="form-control"
									required="required">
									<form:option value="" label="Select Designation type" />
									<form:option value="Admin" label="Admin" />
									<form:option value="User" label="User" />

								</form:select>
							</div>
							<!-- form-group end.// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<form:input path="password" class="form-control"
									placeholder="Create password" type="password"
									required="required" />
							</div>

							<!-- Image upload  -->

							<div class="form-group input-group">

								<div class="input-group-prepend">

									<span class="input-group-text"><i
										class="fa-solid fa-cloud-arrow-up"></i></span>

								</div>
								<input name="image" class="form-control"
									placeholder="Upload Image" type="file" required="required" />
							</div>


							<!-- Image upload part end  -->



							<!-- form-group// -->
							<div class="form-group">
								<button type="submit"
									class="btn btn-primary btn-block text-white">Create
									Account</button>
							</div>
							<!-- form-group// -->
							<p class="text-center text-white">
								Have an account? <a href="login">Log In</a>
							</p>
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
