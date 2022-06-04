<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
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

  <div class="update">
    <div class="form_body">
      <div class="img_block">
        <img src="" class="product_img"><br>
      </div>
      <form:form action="delete" modelAttribute="product" method="get">
        <fieldset class="label-130 product_block">
          <c:if test = "${not empty msgId}">
   	 			<p class="error">${deleteMsg}</p>
    		</c:if>
          <div>
            <label>商品ID</label>
            <form:input type="text" path="productId" value="${chosenProduct.getProductId()}" readonly="true" class="base-text"/>
          </div>
          <div>
            <label>商品名</label>
            <form:input type="text" path="productName" value="${chosenProduct.getProductName()}" readonly="true" class="base-text"/>
          </div>
          <div>
            <label>単価</label>
            <form:input type="text" path="price" value="${chosenProduct.getPrice()}" readonly="true" class="base-text"/>
          </div>
          <div>
            <label>カテゴリ</label>
            <form:input type="text" path="categoryName" value="${chosenProduct.getCategoryName()}" readonly="true" class="base-text"/>
          </div>
          <div>
            <label>商品説明</label>
            <form:input path="description" readonly="true"  class="base-text" value="${chosenProduct.getDescription()}" />
          </div>
        </fieldset>
            <input type="button" onclick="openModal()" value="削除" class="basic_btn">
            <input type="button" onclick="location.href='updateMenu'" value="編集" class="basic_btn">
            <input type="button" onclick="location.href='menu'" value="戻る" class="cancel_btn">
          <div id="modal">
            <p class="modal_message">削除しますか？</p>
            <div class="btns">
              <form:button type="delete" class="basic_btn">削除</form:button>
              <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
            </div>
          </div>
      </form:form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
<script src="./js/commons.js"></script>
</html>