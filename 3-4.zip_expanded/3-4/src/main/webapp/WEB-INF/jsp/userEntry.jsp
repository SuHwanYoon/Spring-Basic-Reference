<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>가입자 등록 화면</title>
</head>
<body>
<div align="center">
<h2>가입자 등록 정보 입력</h2>
<form:form modelAttribute="user" method="post" action="userEntry.html">
<spring:hasBindErrors name="user">
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="e">
			<spring:message code="${e.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><th>가입자ID</th>
		<td><form:input path="id" maxlength="20" cssClass="userId"/>
		<font color="red"><form:errors path="id"/></font></td></tr>
	<tr height="40px"><th>암호</th>
		<td><form:password path="pwd" maxlength="20" cssClass="password"/>
		<font color="red"><form:errors path="pwd"/></font></td></tr>
	<tr height="40px"><th>이름</th>
		<td><form:input path="name" maxlength="20" cssClass="userName"/>
		<font color="red"><form:errors path="name"/></font></td></tr>
	<tr height="40px"><th>주소</th>
		<td><form:input path="addr" maxlength="20" cssClass="address"/>
		<font color="red"><form:errors path="addr"/></font></td></tr>
	<tr height="40px"><th>연락처</th>
		<td><form:input path="phone" maxlength="20" cssClass="tel"/>
		<font color="red"><form:errors path="phone"/></font></td></tr>
	<tr height="40px"><th>성별</th>
		<td>남:<form:radiobutton path="gender" value="M"/>
		,여:<form:radiobutton path="gender" value="F"/>
		<font color="red"><form:errors path="gender"></form:errors></font>
		</td></tr>
	<tr height="40px"><th>이메일</th>
		<td><form:input path="email" maxlength="20" cssClass="email"/>
		<font color="red"><form:errors path="email"/></font></td></tr>
	<tr height="40px"><th>직업</th>
		<td><form:select path="job">
			<form:option value="회사원" label="회사원"></form:option>
			<form:option value="학생" label="학생"></form:option><!-- label이 브라우저에 출력 -->
			<form:option value="가사" label="가사"></form:option>
			<form:option value="기타" label="기타"></form:option>
		</form:select>
		<font color="red"><form:errors path="job"/></font></td></tr>			
</table>
<table>
	<tr><td height="40px" align="center">
		<input type="submit" value="등록" name="btnSubmit"></td>
		<td height="40px" align="center">
		<input type="reset" value="취소" name="btnCancel"></td>
		
	</tr>
</table>
</form:form>
</div>
</body>
</html>