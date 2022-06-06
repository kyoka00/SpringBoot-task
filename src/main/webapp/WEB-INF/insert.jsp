<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <div class="header">
    <h1 class="site_logo"><a href="menu">商品管理システム</a></h1>
    <div class="user">
      <p class="user_name">${fn:escapeXml(userName)}さん、こんにちは</p>
       <a class="logout_form" href="logout">
          <button class="logout_btn">
            <img src="images/ドアアイコン.png">ログアウト</button>
        </a>
    </div>
  </div>

  <hr>
  
  <div class="insert">
    <div class="discription">
      <p>
        登録情報を入力してください（<span class="required"></span>は必須です）
      </p>
    </div>
  
    <div class="form_body">
    <c:if test= "${not empty insertMsg}">
      <p class="error">${insertMsg}</p>
 	 </c:if>
      <form:form action="insertSubmit" modelAttribute="product" acceptCharset="UTF-8">
        <fieldset class="label-130">
          <div>
            <label class="required">商品ID</label>
            <form:input path="productId" class="base-text"/>
            <c:if test= "${empty insertMsg}">
     		 	<form:errors path="productId" cssStyle="color: red"/>
 			 </c:if>
            
            
          </div>
          <div>
            <label class="required">商品名</label>
            <form:input path="productName" class="base-text"/>
            <c:if test= "${empty insertMsg}">
     		 <form:errors path="productName" cssStyle="color: red"/>
 			 </c:if>
            
          </div>
          <div>
            <label class="required">単価</label>
            <form:input path="price" class="base-text"/>
            <c:if test= "${empty insertMsg}">
      			<form:errors path="price" cssStyle="color: red"/>
 	 		</c:if>
            
          </div>
          <div class="select_block">
            <label class="required">カテゴリ</label>
            <form:select path="categoryId" class="base-text">
              <c:forEach var= "c" items="${categoryList}" varStatus = "status">
             	<option value="${c.getId()}">${fn:escapeXml(c.getName())}</option>
             </c:forEach>
            </form:select>
          </div>
          <div>
            <label>商品説明</label>
            <form:textarea path="description" class="base-text"/>
          </div>
        </fieldset>
        <div class="btns">
          <button type="button" onclick="openModal()" class="basic_btn">登録</button>
          <input type="button" onclick="location.href='menu'" value="戻る" class="cancel_btn">
        </div>
        <div id="modal">
          <p class="modal_message">登録しますか？</p>
          <div class="btns">
            <form:button class="basic_btn" name ="insetSubmit">登録</form:button>
            <form:button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</form:button>
          </div>
        </div>
      </form:form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
<script src="./js/commons.js"></script>
</html>
<