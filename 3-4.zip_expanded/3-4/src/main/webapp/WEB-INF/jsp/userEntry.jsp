<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ��� ȭ��</title>
</head>
<body>
<div align="center">
<h2>������ ��� ���� �Է�</h2>
<form:form modelAttribute="user" method="post" action="userEntry.html">
<spring:hasBindErrors name="user">
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="e">
			<spring:message code="${e.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><th>������ID</th>
		<td><form:input path="id" maxlength="20" cssClass="userId"/>
		<font color="red"><form:errors path="id"/></font></td></tr>
	<tr height="40px"><th>��ȣ</th>
		<td><form:password path="pwd" maxlength="20" cssClass="password"/>
		<font color="red"><form:errors path="pwd"/></font></td></tr>
	<tr height="40px"><th>�̸�</th>
		<td><form:input path="name" maxlength="20" cssClass="userName"/>
		<font color="red"><form:errors path="name"/></font></td></tr>
	<tr height="40px"><th>�ּ�</th>
		<td><form:input path="addr" maxlength="20" cssClass="address"/>
		<font color="red"><form:errors path="addr"/></font></td></tr>
	<tr height="40px"><th>����ó</th>
		<td><form:input path="phone" maxlength="20" cssClass="tel"/>
		<font color="red"><form:errors path="phone"/></font></td></tr>
	<tr height="40px"><th>����</th>
		<td>��:<form:radiobutton path="gender" value="M"/>
		,��:<form:radiobutton path="gender" value="F"/>
		<font color="red"><form:errors path="gender"></form:errors></font>
		</td></tr>
	<tr height="40px"><th>�̸���</th>
		<td><form:input path="email" maxlength="20" cssClass="email"/>
		<font color="red"><form:errors path="email"/></font></td></tr>
	<tr height="40px"><th>����</th>
		<td><form:select path="job">
			<form:option value="ȸ���" label="ȸ���"></form:option>
			<form:option value="�л�" label="�л�"></form:option><!-- label�� �������� ��� -->
			<form:option value="����" label="����"></form:option>
			<form:option value="��Ÿ" label="��Ÿ"></form:option>
		</form:select>
		<font color="red"><form:errors path="job"/></font></td></tr>			
</table>
<table>
	<tr><td height="40px" align="center">
		<input type="submit" value="���" name="btnSubmit"></td>
		<td height="40px" align="center">
		<input type="reset" value="���" name="btnCancel"></td>
		
	</tr>
</table>
</form:form>
</div>
</body>
</html>