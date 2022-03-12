<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>가입자 등록 완료 확인</title>
</head>
<body>
<div align="center">
<h2>가입자 등록 완료 확인</h2>
<b><font color="red">가입이 완료되었습니다.</font></b>
<table>
	<tr height="40px"><td>가입자ID</td><td>${user.id }</td></tr>
	<tr height="40px"><td>암호</td><td>${user.pwd }</td></tr>
	<tr height="40px"><td>이름</td><td>${user.name }</td></tr>
	<tr height="40px"><td>주소</td><td>${user.addr }</td></tr>
	<tr height="40px"><td>성별</td><td>${user.gender }</td></tr>
	<tr height="40px"><td>연락처</td><td>${user.phone }</td></tr>
	<tr height="40px"><td>이메일</td><td>${user.email }</td></tr>
	<tr height="40px"><td>직업</td><td>${user.job }</td></tr>
</table>
</div>
</body>
</html>