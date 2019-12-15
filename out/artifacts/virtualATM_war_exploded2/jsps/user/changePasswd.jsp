<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">存款业务</h1>

	<div class="jumbotron">
	<p class="text-danger">修改密码成功后，自动跳转到登录页面，请重新登录</p>
	<form action="<c:url value='/changePasswd' />" method="post" role="form">
		<p style="color: red; font-weight: 900">${passwd_msg }</p>
		<div class="form-group">
			<label for="Password"><h3>请输入修改的密码</h3></label>
			<input type="password" class="form-control" id="Password" name="password" value="${Password }" style="width:400px" />
			<span style="color: red; font-weight: 900">${errors.password }</span>
		</div>
 		<div class="form-group">
			<label for="RePassword"><h3>请重新输入修改的密码</h3></label> 
			<input type="password" class="form-control" id="RePassword" name="rePassword" value="${RePassword }" style="width:400px" />
			<span style="color: red; font-weight: 900">${errors.rePassword }</span>
		</div>
		<button type="submit" class="btn btn-primary btn-large">确认修改</button>
	</form>
</div>
</div>
