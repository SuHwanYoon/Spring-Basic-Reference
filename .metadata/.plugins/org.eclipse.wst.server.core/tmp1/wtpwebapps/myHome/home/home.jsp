<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table{
	width:90%; height:80%; border:1px solid blue;
	border-collapse:collapse; margin-left:20px; margin-right:20px;
	background-color:skyblue;
}
td.main {width:30%; border:1px solid blue;}
#menu {margin-left:10px; margin-top:10px; width:90%;
		border:1px dashed red; background-color:orange;}
#content {background-color:wheat;}
#login {margin-left:10px; margin-top:10px; width:90%;
		border:1px dashed green; background-color:orange;}		
</style>
</head>
<body onload="startClock()">
<script type="text/javascript">
function workingClock(){
	var days=["일","월","화","수","목","금","토"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() +1;
	if(month < 10) month = "0"+month;
	var date = today.getDate();
	if(date < 10) date = "0"+date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10)min = "0"+min;
	var sec = today.getSeconds();
	if(sec < 10 ) sec = "0"+sec;
	var str = year+"-"+month+"-"+date+" "+day+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML = str;
}
function startClock(){
	setInterval(workingClock, 1000);//1초마다 함수 호출
}

</script>
<header>
	<div align="center">
		<img alt="" src="../imgs/logo.gif">
	</div>
</header>
<section>
	<table id="body">
		<tr>
			<td width="40%" height="300px" class="main">
			<div id="login">
				<c:choose>
					<c:when test="${sessionScope.LOGINUSER != null }">
						<jsp:include page="logout.jsp"/>
					</c:when>
					<c:when test="${RELOGIN != null }">
						<jsp:include page="${RELOGIN }"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="../login/login.html"/>	
					</c:otherwise>
				</c:choose>
				
			</div>
				<div id="menu">
					<a href="../home/intro.html?BODY=intro.jsp">소개</a><br/>
					<c:choose>
						<c:when test="${sessionScope.MAN != null }">
							<a href="home.jsp?BODY=noticeInput.jsp">공지사항 쓰기</a><br/>
							<a href="checkAdmin.do">공지사항 쓰기2</a><br/>
						</c:when>
					</c:choose>
					<a href="">공지사항목록</a><br/>
					<a href="../write/writeForm.html">게시글 쓰기</a><br/>
					<a href="../write/read.html">게시글 목록</a><br/>
						<c:choose>
						<c:when test="${sessionScope.MAN != null }">
							<a href="home.jsp?BODY=inputItem.jsp">상품 등록</a><br/>
						</c:when>
					</c:choose>
					<a href="getAllItems.do">상품 목록</a><br/>
					<a href="cartList.do">장바구니 보기</a><br/>
					<a href="../write/imageForm.html">이미지 및 답글 게시글 쓰기</a><br/>
					<a href="../write/imageList.html">이미지 및 답글 목록</a>
				</div>
			</td>
			<td id="content">
				<c:if test="${BODY != null }"><!-- 공백있으면 안된다 -->
					<jsp:include page="${BODY }"/>				
				</c:if>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">CopyLeft 2021. FromAtoZucchini.
	<font color="red"><span id="clock"></span></font></h3>
</footer>
</body>
</html>