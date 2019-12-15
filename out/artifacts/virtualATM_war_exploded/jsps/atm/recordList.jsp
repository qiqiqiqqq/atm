<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录</title>
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
	<jsp:include page="/WEB-INF/jsps/top.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/WEB-INF/jsps/left.jsp"></jsp:include>
		<div class="col-md-9 column">
			<h2>--交易记录--</h2>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>交易时间</th>
						<th>交易类型</th>
						<th>交易金额</th>
						<th>ATM编号</th>
						<th>备注（手续费、转账用户等）</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pb.beanList}" var="record">
						<tr>
							<td>${record.transDate }</td>
							<td>${record.type }</td>
							<td>${record.transBalance }</td>
							<td>${record.atm.atmId }</td>
							<td>${record.remark }</td>
							<td><a class="btn btn-success btn-xs" 
								href="<c:url value='/BankCard?method=printRecord&transId=${record.transId }' />">打印</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">

				<li><a href="${pb.url }&pc=1">首页</a></li>
				<c:if test="${pb.pc > 1}">
					<li><a href="${pb.url }&pc=${pb.pc-1 }">上一页</a></li>
				</c:if>

				<c:choose>
					<%--如果总页数不足10页，显示所有页面 --%>
					<%--没有给域，默认是page域，整个页面可见 --%>
					<c:when test="${pb.tp <= 10 }">
						<c:set var="begin" value="1" />
						<c:set var="end" value="${pb.tp }" />
					</c:when>
					<%--当总页数>10时，计算begin和end --%>
					<c:otherwise>
						<c:set var="begin" value="${pb.pc-5 }" />
						<c:set var="end" value="${pb.pc+4 }" />
						<%--头溢出 --%>
						<c:if test="${begin < 1 }">
							<c:set var="begin" value="1" />
							<c:set var="end" value="10" />
						</c:if>
						<%--尾溢出 --%>
						<c:if test="${end > pb.tp }">
							<c:set var="begin" value="${pb.tp - 9 }" />
							<c:set var="end" value="${pb.tp }" />
						</c:if>
					</c:otherwise>
				</c:choose>

				<%--循环显示页码列表 --%>
				<c:forEach var="i" begin="${begin }" end="${end }">
					<c:choose>
						<c:when test="${i eq pb.pc }">
							<li><a class="text-warning">[${i }]</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pb.url }&pc=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${pb.pc < pb.tp }">
					<li><a href="${pb.url }&pc=${pb.pc+1 }">下一页</a></li>
				</c:if>
				<li><a href="${pb.url }&pc=${pb.tp }">尾页</a></li>
			</ul>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsps/footer.jsp"></jsp:include>
</body>
</html>