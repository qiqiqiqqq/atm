<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/atm/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/atm/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/atm/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/atm/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/atm/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li><a href="<c:url value="/jsps/atmIndex2.jsp"/> ">业务首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="<c:url value='/checkBalance' />">余额查询</a></li>
        <li><a href="<c:url value='/jsps/atm/withdrawIndex.jsp' />">取款业务</a></li>
        <li><a href="<c:url value='/jsps/atm/depositIndex.jsp' />">存款业务</a></li>
        <li><a href="<c:url value='/jsps/atm/transferIndex.jsp' />">转账业务</a></li>
        <li><a href="<c:url value='/showRecords' />">交易明细</a></li>
        <li><a href="<c:url value='/jsps/user/changePasswdIndex.jsp' />">修改密码</a></li>
        <li><a href="<c:url value='/logout' />">退卡</a></li>
    </ul>
</div>


<script>window.jQuery || document.write('<script src="/atm/js/jquery.min.js"><\/script>')</script>
<script src="/atm/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="/atm/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/atm/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
