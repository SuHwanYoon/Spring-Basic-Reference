<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function check(){
	
	if( ! confirm("������ �ۼ��Ͻðڽ��ϱ�?")){ return false;}
}
</script>
<div align="center">
	<h2>�Խ��� �۾���</h2>
	<form:form action="../write/write.html" method="post" onSubmit="return check()"
	modelAttribute="bbs"><!-- ��ü�̸� �Ǿձ��ڸ� �ҹ��ڷ� -->
	<table>
		<tr><th>�� ��</th><td><form:input path="title" 
		placeHolder="������ �Է��ϼ���" size="20"/><br/>
		<font color="red"><form:errors path="title"/></font></td></tr>
		<tr><th>�� ��</th><td><form:textarea rows="6" cols="40"
			path="content" placeHolder="������ �Է��ϼ���"></form:textarea>
			<br/><font color="red"><form:errors path="content"/></font></td></tr>
		<tr><td colspan="2" align="center"><input type="submit"
			value="�� �ø���"/> <input type="reset" value="�� ��"/></td></tr>
	</table>
	</form:form>
</div>

</body>
</html>