<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>

<form:form method="post" action="register.html" modelAttribute="fruit"
	enctype="multipart/form-data">
<div align="center" class="body">
<h2><font color="green">
	<spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><th>��ǰID</th><td><form:input path="item_id"
		cssClass="itemId" maxLength="20"/></td>
		<td><font color="red"><form:errors path="item_id"/></font></td>
		</tr>
	<tr height="40px"><th>��ǰ�̸�</th><td><form:input path="item_name"
		cssClass="itemName" maxLength="30"/></td>
		<td><font color="red"><form:errors path="item_name"/></font></td>
		</tr>
	<tr height="40px"><th>��ǰ����</th><td><form:input path="price"
		cssClass="price" maxLength="8"/>��</td>
		<td><font color="red"><form:errors path="price"/></font></td>
		</tr>
	<tr height="40px"><th>�̹��� ����</th><td><input type="file"
		name="picture"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:textarea 
		path="description" cssClass="description"/></td>
		<td><font color="red"><form:errors path="description"/></font></td>
		</tr>
</table><br/>
<input type="submit" value="�� ��"/><input type="reset" value="�� ��"/>
</div>
</form:form><br/><br/><a href="index.html">���ư���</a>
</body>
</html>




