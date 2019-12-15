<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询余额</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/jsps/top.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/jsps/left.jsp"></jsp:include>
		<div class="col-md-9 column">
			<h2 class="active">--友情提醒--</h2>
			<form role="form">
				<div class="form-group">
					<label for="Money"><h2>${msg }</h2></label> 
				</div>
				<p>
					<a class="btn btn-primary btn-large" href="<c:url value='/jsps/atmIndex.jsp' />" >确认并返回业务主页</a>
				</p>
			</form>
		</div>
	</div>
	<jsp:include page="/jsps/footer.jsp"></jsp:include>
</body>
</html>