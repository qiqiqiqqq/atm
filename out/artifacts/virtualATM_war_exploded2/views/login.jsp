<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="../../favicon.ico">

	<title>Signin Template for Bootstrap</title>

	<!-- Bootstrap core CSS -->
	<link href="/css/bootstrap.min.css" rel="stylesheet">

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="/css/signin.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="/js/ie-emulation-modes-warning.js"></script>
	<script src="/js/jquery-3.3.1.min.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body>

<div class="container">

	<form class="form-signin" action="<c:url value='/loginServlet' />" method="post" class="form-horizontal" role="form">
		<img class="mb-4" src="/images/t_07.jpg" alt="" width="300" height="90">
		<h2 class="form-signin-heading">Please sign in</h2>
		<div class="from-group">
			<p style="color: red; font-weight: 900">${msg }</p>
			<label for="cardId" class="sr-only">Email address</label>
			<input type="cardId" id="cardId" name="cardId" class="form-control" placeholder="Email address" required autofocus>
			<span style="color: red; font-weight: 900">${errors.bankCardId }</span>
		</div>
		<div class="">
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
			<span style="color: red; font-weight: 900">${errors.password}</span>
		</div>
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="Cli()">Sign in</button>

		<script >


			function Cli(){
				var dd = "${errors.errors}";
				if (dd!=""){
					alert(dd);
				}

			}
		</script >

	</form>


</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>