<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">取款业务</h1>

	<div class="jumbotron">

	<p class="text-danger">该ATM取款机仅支持100到5000元整百取款！</p>
	<p class="text-danger">请在ATM取款业务执行完成30秒内把人民币取走</p>
	<form action="<c:url value='/weithdraw' />" method="post" role="form">

 		<p style="color: red; font-weight: 900">${money_msg }</p>
		<div class="form-group">
			<label for="money"><h3>请输入要取款的金额(整百)</h3></label>
			<input type="text" class="form-control" id="Money" name="money" value="${Money }" style="width:400px" />
			<span style="color: red; font-weight: 900">${errors_Money }</span>
		</div>
		<button type="submit" class="btn btn-primary btn-large">确认取款</button>
	</form>
</div>
</div>
