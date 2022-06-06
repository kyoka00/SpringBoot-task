<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<link href="css/commons.css" rel="stylesheet">
<style type= "text/ javascript">
          	window.sessionStorage.getItem(['']);
</style>
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
    <div class="form_body">
     <c:if test = "${not empty updateMsg }">
    	<p class="error">${updateMsg}</p>
    </c:if>
      
	
      <form:form action="update" method="post" modelAttribute="product">
        <fieldset class="label-130">
          <div>
            <label>商品ID</label>
            <form:input type="text" path="productId" value="${chosenProduct.getProductId()}" class="base-text"/>
            
            <c:if test = "${empty updateMsg }">
    			<form:errors path="productId" cssStyle="color: red" />
   			 </c:if>
          </div>
          <div>
            <label>商品名</label>
            <form:input type="text" path="productName" value="${chosenProduct.getProductName()}" class="base-text"/>
            
            <c:if test = "${empty updateMsg }">
    			<form:errors path="productName" cssStyle="color: red" />
    		</c:if>
          </div>
          <div>
            <label>単価</label>
            <form:input type="text" path="price" value="${chosenProduct.getPrice()}" class="base-text"/>
            <c:if test = "${empty updateMsg }">
    			<form:errors path="price" cssStyle="color: red" />
    		</c:if>
          </div>
          <div>
            <label>カテゴリ</label> 
            <form:select path="categoryId" class="base-text" >
            
             <c:forEach var= "c" items="${categoryList}" varStatus = "status">
             	<option value="${c.getId()}" <c:if test="${c.getId() == chosenProduct.getCategoryId()}">selected</c:if>>${fn:escapeXml(c.getName())}</option>
             </c:forEach>
             
            </form:select>
          </div>
          
          <div>
            <label>商品説明</label>
            <form:input path="description" class="base-text" value="${chosenProduct.getDescription()}" style="height: 100px;"/>
          </div>
        </fieldset>
          <div class="btns">
            <button type="button" onclick="openModal()" class="basic_btn">更新</button>
            <input type="button" onclick="location.href='menu'" value="メニューに戻る" class="cancel_btn">
          </div>
          <div id="modal">
            <p class="modal_message">更新しますか？</p>
            <div class="btns">
              <form:button type="submit" class="basic_btn">更新</form:button>
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