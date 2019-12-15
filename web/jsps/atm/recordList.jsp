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
	<jsp:include page="/jsps/top2.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="/jsps/left2.jsp"></jsp:include>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">交易明细</h1>

				<div class="jumbotron">
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
					<c:forEach items="${pb.list}" var="record">
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
			<nav aria-label="Page navigation">
			<ul class="pagination">

				<c:if test="${pb.currenPage==1}">
					<li class="disabled">
				</c:if>
				<c:if test="${pb.currenPage!=1}">
					<li class="disabled">
				</c:if>

					<a href="${pageContext.request.contextPath}/showRecords?currentPage=${pb.currenPage - 1}&rows=5" aria-label="Previous">
					     <span aria-hidden="true">&laquo;</span>
					</a>
				    </li>


				<%--循环显示页码列表 --%>
				<c:forEach var="i" begin="1" end="${pb.totalPage}">
					<c:if test="${pb.currenPage == i}">
						<li class="active"><a href="${pageContext.request.contextPath}/showRecords?currentPage=${i}&rows=5">${i}></a></li>
					</c:if>
					<c:if test="${pb.currenPage != i}">
						<li> <a href="${pageContext.request.contextPath}/showRecords?currentPage=${i}&rows=5">${i}></a></li>
					</c:if>

				</c:forEach>
				<li>
					<a href="${pageContext.request.contextPath}/showRecords?currentPage=${pb.currenPage + 1}&rows=5"  aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>


				<span style="font-size: 25px;margin-left: 5px;">
					共${pb.totalCount}条记录，共${pb.totalPage}页
				</span>
			</ul>
			</nav>
		</div>
			</div>
	</div>
	<jsp:include page="/jsps/footer.jsp"></jsp:include>
</body>
</html>