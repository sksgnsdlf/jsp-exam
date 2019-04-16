<%@page import="DBPKG.Memdao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="DBPKG.bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3{ text-align: center;}
</style>
<script>
function button1_click() {
	alert("수정이 완료되었습니다.");
}
</script>
</head>
<body>
<%@ include file="../main/header.jsp" %>
<%@ include file="../main/nav.jsp" %><br><br><br><br><br>
<h3> 홈쇼핑 회원등록 </h3>
<form action="update" method="post">
<table border="1" style="margin-left: auto; margin-right: auto; text-align:center ">
	<tr>
		<td> 회원번호(자동발생) </td> <td><input name="custno" value="${bean.custno}"> </td>
	</tr>
	<tr>
		<td> 회원성명 </td> <td><input name="custname" value="${bean.custname}"> </td>
	</tr>
	<tr>
		<td> 회원전화 </td> <td><input name="phone"value="${bean.phone}"> </td>
	</tr>
	<tr>
		<td> 회원주소 </td> <td><input name="address"value="${bean.address}"> </td>
	</tr>
	<tr>
		<td> 가입일자 </td> <td><input name="joindate"value="${bean.joindate}"> </td>
	</tr>
	<tr>
		<td> 고객등급[A:VIP,B:일반,C:직원] </td> <td><input name="grade" value="${bean.grade}"> </td>
	</tr>
	<tr>
		<td> 도서코드 </td> <td><input name="city" value="${ bean.city}"> </td>
	</tr>
	<tr>
		<td colspan="2"><button id="button1" onclick="button1_click()">수정</button> &nbsp;&nbsp;
		<button id="select"><a href="./view_Edit"">조회</button></td>	
	</tr>
</table>
</form>
</body>
</html>