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
		alert("상품번호를 입력하세요."); return false;}
	if(frm.item_name.value == ''){
		alert('상품이름을 입력하세요.'); return false;}
	if(frm.price.value == ''){
		alert('가격을 입력하세요.'); return false;}
	if(frm.description.value == ''){
		alert("상품설명을 입력하세요."); return false;}
	var v = confirm("입력한 내용이 맞습니까?");
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
	<tr height="40px"><th>상품ID</th><td><form:input path="item_id"
		cssClass="itemId" maxLength="20"/></td></tr>
	<tr height="40px"><th>상품이름</th><td><form:input path="item_name"
		cssClass="itemName" maxLength="30"/></td></tr>
	<tr height="40px"><th>상품가격</th><td><form:input path="price"
		cssClass="price" maxLength="8"/>원</td></tr>
	<tr height="40px"><th>이미지 파일</th><td><input type="file"
		name="pictureUrl"/></td></tr>
	<tr height="40px"><th>상품설명</th><td><form:textarea 
		path="description" cssClass="description"/></td></tr>
</table><br/>
<input type="submit" value="등 록"/><input type="reset" value="취 소"/>
</div>
</form:form><br/><br/><a href="index.html">돌아가기</a>
</body>
</html>




