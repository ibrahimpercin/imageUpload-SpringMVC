<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

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

	<div class="album text-muted">
		<div class="container">
			<div class="row">
				<c:forEach items="${images}" var="image" varStatus="loop">
					<div data-list-index="${loop.index}"
						class="card col-12 col-sm-12 col-md-6 col-lg-4"
						onclick="showOverlay(this)">
						<img src="data:image/jpeg;base64,${image.base64image}"
							alt="${image.description}">
						<p class="card-text">${image.description}</p>
						<div class="card-info">
							<fmt:formatDate pattern="dd.MM.yyyy - HH:mm"
								value="${image.uploadDate}" />
							<span class="views float-right">${image.views} views</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div id="overlay">
		<div id="overlay-header">
			<button type="button" class="close" onclick="hideOverlay()"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div id="overlay-image">
			<img id="overlay-image" src="">
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
</body>
</html>
