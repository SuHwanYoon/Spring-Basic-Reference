<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>카트 확인하기</h2>
<div class="cart">
<table style="font-size:10px;">
	<tr><td colspan="2"><font color="green">
	카트에 다음 상품이 들어있습니다.</font></td></tr>
	<c:forEach items="${cart.itemList }" var="itemSet"><!-- cart 는 cartController에서 itemList Cart에서 가져옴 -->
	<tr><td>${itemSet.item.item_name }</td>
		<td>${itemSet.quantity }</td>
	</tr>	
	</c:forEach>
</table>
</div><br/>${message }<br/><br/><!-- cartController에서가져옴 -->
</div>
</body>
</html>