<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
<link rel="stylesheet" type="text/css" href="../css/3-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<form:form action="login.html" method="post" modelAttribute="loginuser"><!--modelAttributer�� UserŬ������ ���ư�  -->
<spring:hasBindErrors name="loginuser"><!-- modelAttribute�� ���ִ°� ���� -->
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="error"><!-- errors�� BindingResult�̴� globalErrors�� ������ ��� ����-->
			<spring:message code="${error.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><th>�����ID</th>
		<td>
		<form:input path="id" cssClass="userId"/>
		<font color="red"><form:errors path="id"/></font>
		</td></tr>
	<tr height="40px"><th>��ȣ</th>
		<td><form:password path="pwd" cssClass="password"/>
		<font color="red"><form:errors path="pwd"/></font></td>
	</tr>
</table>
<table>
	<tr>
	<td align="center"><input type="submit" value="�α���"></td>
	<td align="center"><input type="reset" value="���"></td>
	</tr>
</table>
</form:form>
<a href="../userentryform/userEntry.html">�ڽű� ������ ���</a>
</div>
</body>
</html>