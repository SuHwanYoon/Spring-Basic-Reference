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
<script type="text/javascript">
function check(frm){
	if(frm.item_id.value == ''){
		alert("��ǰ��ȣ�� �Է��ϼ���."); return false;}
	if(frm.item_name.value == ''){
		alert('��ǰ�̸��� �Է��ϼ���.'); return false;}
	if(frm.price.value == ''){
		alert('������ �Է��ϼ���.'); return false;}
	if(frm.description.value == ''){
		alert("��ǰ������ �Է��ϼ���."); return false;}
	var v = confirm("�Է��� ������ �½��ϱ�?");
	if(v == false) return false;
}
</script>
<form:form method="post" action="register.html" modelAttribute="fruit"
	enctype="multipart/form-data" name="form" 
	onSubmit="return check(this)">
<div align="center" class="body">
<h2><font color="green">
	<spring:message code="itemAdd.title"/></font></h2>
<table>
	<tr height="40px"><th>��ǰID</th><td><form:input path="item_id"
		cssClass="itemId" maxLength="20"/></td></tr>
	<tr height="40px"><th>��ǰ�̸�</th><td><form:input path="item_name"
		cssClass="itemName" maxLength="30"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:input path="price"
		cssClass="price" maxLength="8"/>��</td></tr>
	<tr height="40px"><th>�̹��� ����</th><td><input type="file"
		name="pictureUrl"/></td></tr>
	<tr height="40px"><th>��ǰ����</th><td><form:textarea 
		path="description" cssClass="description"/></td></tr>
</table><br/>
<input type="submit" value="�� ��"/><input type="reset" value="�� ��"/>
</div>
</form:form><br/><br/><a href="index.html">���ư���</a>
</body>
</html>




