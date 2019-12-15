<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>ATM虚拟程序-主页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<jsp:include page="/jsps/top.jsp"></jsp:include>
<%-- 	<jsp:include page="/WEB-INF/jsps/user/login.jsp"></jsp:include> --%>
		<div class="row clearfix">
		<div class="col-md-4 column"></div>
		<div class="col-md-4 column">
			<form action="<c:url value='/BankCard' />"  method="post" class="form-horizontal" role="form">
				<input type="hidden" name="method" value="login"/>
				<div class="form-group">
					<p style="color: red; font-weight: 900">${msg }</p>
					<label for="bankCard" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="bankCard" name="cardId" value="${form.cardId }"/>
						<span style="color: red; font-weight: 900">${errors.bankCardId }</span>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" name="password" value="${form.password }"/>
						<span style="color: red; font-weight: 900">${errors.password }</span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success btn-block">登录</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4 column"></div>
	</div>
	<jsp:include page="/jsps/footer.jsp"></jsp:include>
</body>
</html>
