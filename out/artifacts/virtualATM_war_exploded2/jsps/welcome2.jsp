<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">业务首页</h1>

    <div class="jumbotron">
        <h2>尊敬的${session_bankCard.bank.bankName }用户，${session_bankCard.user.name }</h2>
        <h2>欢迎使用${session_atm.bank.bankName }ATM存取一体机</h2>
        <c:if test="${session_bankCard.bank.bankName != session_atm.bank.bankName}">
            <p class="text-danger">友情提示：系统监测到您在跨行登录ATM,${session_atm.bank.bankName }ATM将对您的转账和取款业务收费0.5%(最高50元),同时跨行不能进行银行卡密码修改和存款业务</p>
        </c:if>
        <p>自动取款机(ATM Automatic Teller Machine)，利用磁性代码卡或智能卡实现金融交易自助服务。
            可提取现金、查询存款余额、进行账户之间资金划拨、余额查询等工作。
            持卡人使用信用卡或储蓄卡，根据密码办理自动取款、查询余额、转账、现金存款，更改密码等业务。
        </p>
        <p>
            <a class="btn btn-primary btn-large"
               href="<c:url value='/logout' />">--退卡--</a>
        </p>
    </div>
</div>
</body>
</html>
