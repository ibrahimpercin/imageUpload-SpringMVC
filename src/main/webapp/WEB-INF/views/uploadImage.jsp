<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Upload Image</title>

<!-- Bootsrap CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/custom.css" rel="stylesheet">


</head>
<body>

	<header>
		<div class="navbar navbar-white bg-white border">
			<div class="container d-flex justify-content-between">
				<a href="<c:url value="/" />" class="navbar-brand">Image Upload</a>
				<a href="<c:url value="/" />upload-image" class="btn btn-primary">Upload</a>
			</div>
		</div>
	</header>

	<main role="main"> 
		<div class="container">
			<div class="row justify-content-md-center">
				<form:form id="upload-form" class="col-12 col-sm-12 col-md-9 col-lg-7" commandName="image" action="save-image" method="post" enctype="multipart/form-data">
					<div class="form-group text-center">
						<div class="file-upload btn btn-secondary">
						    <span id="select-button">Select Image File</span>
						    <input type="file" class="form-control-file" name="file" id="file">
						</div>
						<img id="preview" >
				  	</div>
				  	<div class="form-group">
					    <form:input type="text" class="form-control form-control-lg" name="description" id="description" path="description" placeholder="Type description here"></form:input>
				  	</div>
				  	<div class="form-group text-center">
						<button type="submit" class="btn btn-primary">
							Upload Photo
						</button>
					</div>
				</form:form> 
			</div>
		</div>
	</main>
	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Başa dön</a>
			</p>
			<p>&copy; Copyright buraya</p>
		</div>
	</footer>

	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/custom.js"></script>
	
	<script type="text/javascript">
		document.getElementById("file").onchange = function () {
		    var reader = new FileReader();
	
		    reader.onload = function (e) {
		        document.getElementById("preview").src = e.target.result;
		        document.getElementById("select-button").innerHTML = "Change Selected Photo";
		        document.getElementById("select-button").parentNode.classList.remove("btn-secondary");
		        document.getElementById("select-button").parentNode.classList.add("btn-success");
		    };
	
		    reader.readAsDataURL(this.files[0]);
		};
		
	</script>


</body>
</html>