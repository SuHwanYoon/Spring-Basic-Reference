<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ��� �Ϸ� Ȯ��</title>
</head>
<body>
<div align="center">
<h2>������ ��� �Ϸ� Ȯ��</h2>
<b><font color="red">������ �Ϸ�Ǿ����ϴ�.</font></b>
<table>
	<tr height="40px"><td>������ID</td><td>${user.id }</td></tr>
	<tr height="40px"><td>��ȣ</td><td>${user.pwd }</td></tr>
	<tr height="40px"><td>�̸�</td><td>${user.name }</td></tr>
	<tr height="40px"><td>�ּ�</td><td>${user.addr }</td></tr>
	<tr height="40px"><td>����</td><td>${user.gender }</td></tr>
	<tr height="40px"><td>����ó</td><td>${user.phone }</td></tr>
	<tr height="40px"><td>�̸���</td><td>${user.email }</td></tr>
	<tr height="40px"><td>����</td><td>${user.job }</td></tr>
</table>
</div>
</body>
</html>