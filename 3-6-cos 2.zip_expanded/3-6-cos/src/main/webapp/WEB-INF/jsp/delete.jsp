<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title"/></title>
</head>
<body>
<form:form modelAttribute="fruit" action="delete.html"
	onSubmit="return check()">
<form:hidden path="item_id"/>
<div align="center" class="body">
<h2><font color="green"><spring:message 
				code="itemDelete.title"/></font></h2>
<table>
	<tr height="40px"><th>상품명</th><td><form:input path="item_name"
		cssClass="item_name" disabled="true"/></td></tr>
	<tr height="40px"><th>상품가격</th><td><form:input path="price"
		cssClass="price" disabled="true"/>원</td></tr>
	<tr height="40px"><th>파일</th><td><img alt="" 
		src="${pageContext.request.contextPath }/upload/${imageName}"
		width="240" height="210"></td></tr>
	<tr height="40px"><th>상품설명</th><td><form:textarea 
		path="description" cssClass="description" disabled="true"/>
		</td></tr>
</table><br/><input type="submit" value="삭 제"/><br/>
</div>
</form:form><a href="index.html">돌아가기</a>
</body>
</html>






