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
<h2>īƮ Ȯ���ϱ�</h2>
<div class="cart">
<table style="font-size:10px;">
	<tr><td colspan="2"><font color="green">
	īƮ�� ���� ��ǰ�� ����ֽ��ϴ�.</font></td></tr>
	<c:forEach items="${cart.itemList }" var="itemSet"><!-- cart �� cartController���� itemList Cart���� ������ -->
	<tr><td>${itemSet.item.item_name }</td>
		<td>${itemSet.quantity }</td>
	</tr>	
	</c:forEach>
</table>
</div><br/>${message }<br/><br/><!-- cartController���������� -->
</div>
</body>
</html>