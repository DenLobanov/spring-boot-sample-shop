<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 isELIgnored="false"
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Shop</title>
	<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="/static/css/bootstrap-theme.css"/>
	<link rel="stylesheet" type="text/css" href="/static/css/font-awesome.css"/>
	<link rel="stylesheet" type="text/css" href="/static/css/app.css"/>
</head>
<body>
<header>
	<jsp:include page="fragment/header.jsp" />
</header>
<div class="container-fluid">
	<div class="row">
		<aside class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="fragment/aside.jsp" />
		</aside>
		<main class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
			<jsp:include page="${currentPage }" />
		</main>
	</div>
</div>
<footer class="footer">
	<jsp:include page="fragment/footer.jsp" />
</footer>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>