<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${session_bankCard.user.name}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/jsps/atmIndex2.jsp"/> ">业务首页 </a></li>
                <li><a href="<c:url value='/checkBalance' />">余额查询</a></li>
                <li><a href="<c:url value='/jsps/atm/withdrawIndex.jsp' />">取款业务</a></li>
                <li><a href="<c:url value='/jsps/atm/depositIndex.jsp' />">存款业务</a></li>
                <li><a href="<c:url value='/jsps/atm/transferIndex.jsp' />">转账业务</a></li>
                <li><a href="<c:url value='/showRecords' />">交易明细</a></li>
                <li><a href="<c:url value='/jsps/user/changePasswdIndex.jsp' />">修改密码</a></li>

                <li><a href="<c:url value='/logout' />">注销</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>