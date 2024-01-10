
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>

<html>

<head>

<title></title>


</head>
<body>

	<form:form action="imageUploadtoDb" method="post"
		enctype="multipart/form-data"> 

		<input name="image" type="file" />
		<button type="submit">Submit</button>

	</form:form>

</body>
</html>