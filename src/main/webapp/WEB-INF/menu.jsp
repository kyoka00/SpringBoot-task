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
      <h1 class="site_logo"><a href="AllShowServlet">商品管理システム</a></h1>
      <div class="user">
        <p class="user_name">${fn:escapeXml(userName)}さん、こんにちは</p>
        <form class="logout_form" action="logout.jsp" method="get">
          <button class="logout_btn" type="submit">
            <img src="images/ドアアイコン.png">ログアウト</button>
        </form>
      </div>
    </div>

    <hr>
	<form:form action ="category" modelAttribute ="users">
    <div class="btn"><form:button class="basic_btn regist" name="categoryBtn">新規登録</form:button></div>
     </form:form>
      
      <c:if test = "${not empty menuMsg }">
    	<p>${menuMsg}</p>
    </c:if>
    
    <form:form action="search" modelAttribute = "users" acceptCharset="UTF-8" id ="send">
      <form:input  path = "searchKey" size="25" placeholder="キーワード検索"/>
      <form:button name ="search">検索</form:button>
    </form:form>

    <table>
    
        <div class="caption"><p>検索結果：${count}件</p></div>
        <div class="order">

          <select class="base-text" name = "order"  form ="send">
            <option value ="1">並び替え</option>
            <option value = "2">商品ID</option>
            <option value = "3">カテゴリ</option>
            <option value ="4"> 単価：安い順</option>
            <option value="5">単価：高い順</option>
            <option value ="6">登録日：古い順</option>
            <option value ="7">登録日：新しい順</option>
          </select>
        
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
            <td><a class="detail_btn" href="./GetDetail?productNo=${status.count}">
            詳細</a></td>
          </tr>
		</c:forEach>
		
      </tbody>
    </table>
  </div>
  <footer></footer>
</body>
</html>