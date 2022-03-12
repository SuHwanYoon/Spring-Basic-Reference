<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 화면</title>
<link rel="stylesheet" type="text/css" href="../css/3-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<form:form action="login.html" method="post" modelAttribute="loginuser"><!--modelAttributer에 User클래스가 날아감  -->
<spring:hasBindErrors name="loginuser"><!-- modelAttribute에 들어가있는거 넣음 -->
	<font color="red">
		<c:forEach items="${errors.globalErrors }" var="error"><!-- errors는 BindingResult이다 globalErrors는 에러가 담긴 변수-->
			<spring:message code="${error.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px"><th>사용자ID</th>
		<td>
		<form:input path="id" cssClass="userId"/>
		<font color="red"><form:errors path="id"/></font>
		</td></tr>
	<tr height="40px"><th>암호</th>
		<td><form:password path="pwd" cssClass="password"/>
		<font color="red"><form:errors path="pwd"/></font></td>
	</tr>
</table>
<table>
	<tr>
	<td align="center"><input type="submit" value="로그인"></td>
	<td align="center"><input type="reset" value="취소"></td>
	</tr>
</table>
</form:form>
<a href="../userentryform/userEntry.html">★신규 가입자 등록</a>
</div>
</body>
</html>