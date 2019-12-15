<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9 column">
	<h2 class="active">--取款业务--</h2>
	<p class="text-danger">该ATM取款机仅支持100到10,000元整百取款！</p>
	<p class="text-danger">请在ATM取款业务执行完成30秒内把人民币取走</p>
	<form action="<c:url value='/Atm' />" method="post" role="form">
 		<input type="hidden" name="method" value="withdraw" />
 		<p style="color: red; font-weight: 900">${money_msg }</p>
		<div class="form-group">
			<label for="money"><h3>请输入要取款的金额(整百)</h3></label>
			<input type="text" class="form-control" id="Money" name="money" value="${Money }" style="width:400px" />
			<span style="color: red; font-weight: 900">${errors_Money }</span>
		</div>
		<button type="submit" class="btn btn-default">确认取款</button>
	</form>
</div>
