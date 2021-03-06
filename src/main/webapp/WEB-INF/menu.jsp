<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link href="css/commons.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
  <div id="app">

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
	
    <div class="btn"><a class="basic_btn regist" href="insertMenu">新規登録</a></div>
      
      <c:if test = "${not empty menuMsg }">
    	<p>${menuMsg}</p>
    </c:if>
    
    <form:form action="search" modelAttribute ="searchForm" id ="send" method ="get">
      <form:input path = "searchKey" size="25" placeholder="キーワード検索"/>
      <form:button>検索</form:button>
    </form:form>

    <table>
    	
        <div class="caption"><p>検索結果：${count}件</p></div>
        <div class="order">
		<form:form action="sort" modelAttribute="searchForm" method= "get">
          <form:select class="base-text" path = "sortCase">
            <form:option value ="0">並び替え</form:option>
            <form:option value = "1">商品ID</form:option>
            <form:option value = "2">カテゴリ</form:option>
            <form:option value ="3"> 単価：安い順</form:option>
            <form:option value="4">単価：高い順</form:option>
            <form:option value ="5">登録日：古い順</form:option>
            <form:option value ="6">登録日：新しい順</form:option>
          </form:select>
          <form:button>並び替え</form:button>
        </form:form>
        </div>
        
      <thead>
        <tr>
          <th>商品ID</th>
          <th>商品名</th>
          <th>単価</th>
          <th>カテゴリ</th>
          <th>詳細</th>
        </tr>
      </thead>
      <tbody>
      
		<c:forEach var="p" items ="${productList}" varStatus ="status">
          <tr>
            <td>${fn:escapeXml(p.getProductId())}</td>
            <td>${fn:escapeXml(p.getProductName())}</td>
            <td>${fn:escapeXml(p.getPrice())}</td>
            <td>${fn:escapeXml(p.getCategoryName())}</td>
            <td><a class="detail_btn" href="detail?productId=${p.getProductId()}">
            詳細</a></td>
          </tr>
		</c:forEach>
		
      </tbody>
    </table>
  </div>
  <footer></footer>
</body>
</html>