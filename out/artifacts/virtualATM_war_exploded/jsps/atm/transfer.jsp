<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9 column">
	<h2 class="active">--转账业务--</h2>
	<p class="text-danger">异地转账收取0.5%手续费</p>
	<form action="<c:url value='/Atm' />" method="post" role="form">
		<p style="color: red; font-weight: 900">${msg }</p>
 		<input type="hidden" name="method" value="transfer" />
		<div class="form-group" id="parent">
			<label for="bankCard"><h3>请输入转账银行卡号</h3></label>
			<input type="text" class="form-control" id="bankCard" name="cardId" value="${cardId }" style="width:400px" />
			<span style="color: red; font-weight: 900" id="msgSpan" ></span>
			<span style="color: red; font-weight: 900" id="span">${errors.bankCardId }</span>
		</div>
 		<div class="form-group">
			<label for="money"><h3>请输入转账的金额</h3></label> 
			<input type="text" class="form-control" id="money" name="money" value="${money }" style="width:400px" />
			<span style="color: red; font-weight: 900">${errors.Money }</span>
		</div>
		<button type="submit" class="btn btn-default">确认转账</button>
	</form>
</div>

<script type="text/javascript">
	//创建异步对象
	function createXMLHttpRequest() {
		try{
			return new XMLHttpRequest();//大多数浏览器
		}catch(e){
			try{
				return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
			}catch(e){
				try{
					return ActvieXObject("Microsoft.XMLHTTP");//IE5.5
				}catch(e){
					alert("未知浏览器");
					throw e;
				}
			}
		}
	}

	window.onload = function(){
		//获取文本框，给它的失去焦点事件注册监听
		var cardEle = document.getElementById("bankCard");
		cardEle.onblur = function(){
			//1.得到异步对象
			var xmlHttp = createXMLHttpRequest();
			//2.打开连接
			xmlHttp.open("POST", "<c:url value='/BankCard'/>", true);
			//3.设置请求头
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//4.发送请求，给出请求体
			xmlHttp.send("method=transferPre&cardId=" + cardEle.value.trim());
			
			//5.给xmlHttp的onreadystatechange事件注册监听
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var text = xmlHttp.responseText;
					var span = document.getElementById("msgSpan");
					var parent = document.getElementById("parent");
					var span2 = document.getElementById("span");
					if(span2 != null){
						parent.removeChild(span2);						
					}
					
					if(text == "null"){
						span.innerHTML = "该用户不存在或输入账号有误";
					}else{
						span.innerHTML = "转账TO：" + text + " 用户";
					}
				}
			};
		};
	};
</script>
