<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>과일 목록</title>
<link rel="stylesheet" type="text/css" href="../css/3-5.css"><!-- ..는 한단계위 폴더를 뜻함 -->
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>과일 목록 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품번호</th>
			<th align="center" width="320">상품이름</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach var="item" items="${itemList }"><!-- itemList맵에서가져옴 -->
			<tr class="record">
				<td align="center">${item.item_id }</td>
				<td align="center"><a href="../detail/detail.html?itemId=${item.item_id }">${item.item_name }</a></td>
				<td align="center">${item.price }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>