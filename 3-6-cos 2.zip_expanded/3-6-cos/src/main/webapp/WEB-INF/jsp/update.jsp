<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemEdit.title"/></title>
</head>
<body>
<form:form modelAttribute="fruit" action="update.html"
	method="post" enctype="multipart/form-data">
<form:hidden path="item_id"/>
<form:hidden path="picture_url"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemEdit.title"/>
</font></h2>
<table>
	<tr height="40px"><th>상품명</th><td><form:input path="item_name"
		cssClass="itemName" maxLength="20"/></td></tr>
	<tr height="40px"><th>상품가격</th><td><form:input path="price"
		cssClass="price" maxLength="10">원</form:input></td></tr>
	<tr height="40px"><th>파 일</th><td><input type="file"
		name="picture_url"/></td></tr>
	<tr height="40px"><th>상품설명</th><td><form:textarea 
		path="description" cssClass="description"/></td></tr>
</table><br/>
<input type="submit" value="변 경"/><input type="reset" value="취 소"/>
</div>
</form:form><br/><a href="index.html">돌아가기</a>
</body>
</html>








