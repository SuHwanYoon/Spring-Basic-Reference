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
	<tr height="40px"><th>��ǰ��</th><td><form:input path="item_name"
		cssClass="itemName" maxLength="20"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:input path="price"
		cssClass="price" maxLength="10">��</form:input></td></tr>
	<tr height="40px"><th>�� ��</th><td><input type="file"
		name="picture_url"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:textarea 
		path="description" cssClass="description"/></td></tr>
</table><br/>
<input type="submit" value="�� ��"/><input type="reset" value="�� ��"/>
</div>
</form:form><br/><a href="index.html">���ư���</a>
</body>
</html>








