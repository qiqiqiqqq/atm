<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
	<div class="row clearfix">
		<c:forEach var="atm" items="${atms }">
		<div class="col-md-4 column">
			<h2>${atm.bank.bankName }</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
				magna mollis euismod. Donec sed odio dui.</p>
			<p>
				<a class="btn btn-success" href="<c:url value='/Atm?method=chooseAtm&atmId=${atm.atmId }'/>">点击进入ATM</a>
			</p>
		</div>
		</c:forEach>	
	</div>
</div>