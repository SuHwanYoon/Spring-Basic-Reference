<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>과일 상세 화면</title>
<link rel="stylesheet" type="text/css" href="css/3-2.css">
</head>
<body>
<div align="center" class="body">
<h2>과일 상세 화면</h2><!-- 상세화면이라 포이치 안씀 -->
	<table>
		<tr><td><img alt="" src="img/${item.picture_url }"></td>
		<td align="center">
			<table>
				<tr height="50">
					<td width="80">상품명</td>
					<td width="160">${item.item_name }</td>
				</tr>
				<tr height="50">
					<td width="80">가격</td>
					<td width="160">${item.price}원</td>
				</tr>
				<tr height="50">
					<td width="80">설명</td>
					<td width="160">${item.description}</td>
				</tr>
				<tr><td colspan="2" align="center" width="240">
				<a href="index.html">★목록으로 돌아가기</a>
				</td></tr>
			</table>
			</td>
		</tr>
	</table>
</div>
</body>
</html>