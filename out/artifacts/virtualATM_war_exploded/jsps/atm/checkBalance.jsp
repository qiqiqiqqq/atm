<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9 column">
	<h2 class="active">--查询余额--</h2>
	<h3 class="text-success">尊敬的${session_bankCard.bank.bankName }用户，${session_bankCard.user.name }：</h3>
	<h3 class="text-success">截止到 ${now_date }，您的账户余额为：${session_bankCard.cardBalance }元</h3>
	<h4 class="text-info">如进行相关业务，请选择左面业务栏选择操作。</h4>
</div>
