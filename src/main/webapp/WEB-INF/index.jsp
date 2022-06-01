<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="./css/commons.css" rel="stylesheet">
</head>
<body class="login_body">
	<div class="header">
		<h1 class="site_logo">商品管理システム</h1>
	</div>

	<div class="login_form">
		<img src="./images/logo.png" class="login_logo">
		<c:if test="${not empty msg }">
			<p class="error">${Loginmsg}</p>
		</c:if>

		<form:form action="excute" modelAttribute="users" method="post">
			<fieldset>
				<div class="cp_iptxt">
					<ftmt: message key="lbl.login.id" />
					<form:input class="base_input" name="loginId" placeholder="ID" />
					<i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
					<c:if test="${empty msg}">
						<form:errors path="loginId" cssStyle="color: red" />
					</c:if>
				</div>

				<div>
					<ftmt:message key="lbl.login.pass"/>
					<form:input class="base_input" type="password" name="pass"
						placeholder="PASS" />
					<c:if test="${empty msg}">
						<form:errors path="pass" cssStyle="color: red" />
					</c:if>
				</div>
			</fieldset>
			<form:button class="logout_btn">ログイン</form:button>
		</form:form>
	</div>
</body>
</html>
