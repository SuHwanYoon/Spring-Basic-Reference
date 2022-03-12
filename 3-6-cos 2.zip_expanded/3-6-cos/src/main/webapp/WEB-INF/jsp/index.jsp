<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemMenu.title"/></title>
</head>
<body>
<form:form method="post" action="search.html">
<div align="center" class="body">
<h2><spring:message code="itemMenu.title"/></h2>
상품명 검색<input type="text" name="itemName"/>
<input type="submit" value="검색"/><a href="create.html">상품 등록</a>
<table border="1">
	<tr class="header"><th align="center" width="80">상품ID</th>
		<th align="center" width="320">상품명</th>
		<th align="center" width="100">상품가격</th>
		<th align="center" width="80">편 집</th>
		<th align="center" width="80">삭 제</th></tr>
	<c:forEach items="${itemList }" var="item">
	<tr class="record"><td align="center">${item.item_id }</td>
		<td align="left">${item.item_name }</td>
		<td align="right"><f:formatNumber type="currency"
			currencySymbol="￦" value="${item.price }"/>원</td>
		<td align="center">
			<a href="edit.html?itemId=${item.item_id}">상품편집</a></td>
		<td align="center">
			<a href="confirm.html?itemId=${item.item_id}">상품삭제</a>
		</td></tr>
	</c:forEach>
</table>
</div>
</form:form>
</body>
</html>









