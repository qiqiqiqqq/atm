<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3 column">
	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="<c:url value='/jsps/atmIndex.jsp' />">业务首页</a></li>
		<li><a href="<c:url value='/Atm?method=checkBalance' />">查询余额</a></li>
		<li><a href="<c:url value='/jsps/atm/withdrawIndex.jsp' />">取款业务</a></li>
		<li><a href="<c:url value='/jsps/atm/depositIndex.jsp' />">存款业务</a></li>
		<li><a href="<c:url value='/jsps/atm/transferIndex.jsp' />">转账业务</a></li>
		<li><a href="<c:url value='/BankCard?method=showRecords' />">交易明细</a></li>
		<li><a href="<c:url value='/jsps/user/changePasswdIndex.jsp' />">修改密码</a></li>
		<li><a href="<c:url value='/BankCard?method=logout' />">注销并退卡</a></li>
	</ul>
</div>