<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link
            href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
            rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script
            src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>ATM网上服务系统</title>
    <style type="text/css">
        <!--
        body,td,th {
            color: #666666;
        }
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-color: #EAEFF5;
        }
        .style14 {font-size: 14px;
            color: #666666;line-height:24px;
        }
        .style15 {font-size: 14px;
            color: #FF0000;line-height:24px;}
        -->
    </style></head>

<body>
<table width="856" border="0" align="center" cellspacing="0">
    <tr>
        <td height="60" valign="bottom">
            <div align="left"><img src="images/t_03.jpg" width="188" height="40" alt=""></div>
        </td>
    </tr>

    <tr>
        <td height="75">
            <div align="center"><img src="images/t_07.jpg" width="300" height="63" alt=""></div>
        </td>
    </tr>

    <tr>
        <td height="50">
            <div class="col-md-12 column">
                <div class="jumbotron">
                    <h1> 欢迎使用ATM网上服务系统！</h1>
                    <h2>登录ATM网上服务操作步骤</h2>
                    <a href="http://www.chinaums.com/static/download/atmtools/StarSec.YLSW.user.exe">1.下载</a>捷德U-key管理工具。2.U-key管理工具安装成功后点确认并输入U-key密码方可进入ATM网上服务系统登录界面


                    <p>
                        <a class="btn btn-primary btn-large" href="<c:url value='/views/login2.jsp' />" >点击登录</a>
                    </p>

                </div>
            </div>

        </td>

    </tr>


</table>

    <jsp:include page="/jsps/footer.jsp"></jsp:include>
</body>
</html>

