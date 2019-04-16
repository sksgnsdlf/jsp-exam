<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DBPKG.Memdao"%>
<%@page import="DBPKG.db"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	alert("회원등록이 완료되었습니다.");
}
</script>
</head>
<body>
<%@ include file="../main/header.jsp" %>
<%@ include file="../main/nav.jsp" %><br><br><br><br><br>
<h3> 홈쇼핑 회원등록 </h3>
<%
	bean member = null;
	List<bean> dto = Memdao.getInstance().selectAll();
	for(int i=0;i<dto.size();i++){
	member=dto.get(i);						
	}
	int num=Integer.parseInt(member.getCustno())+1;
	
	SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyyMMdd");
	Date date = new Date ();
	String mTime = mSimpleDateFormat.format (date);
%>
<form action="/hrd_01/registration" method="post">
<table border="1" style="margin-left: auto; margin-right: auto; text-align:center ">
	<tr>
		<td> 회원번호(자동발생) </td> <td><input name="custno" value="<%=num%>"> </td>
	</tr>
	<tr>
		<td> 회원성명 </td> <td><input name="custname"> </td>
	</tr>
	<tr>
		<td> 회원전화 </td> <td><input name="phone"> </td>
	</tr>
	<tr>
		<td> 회원주소 </td> <td><input name="address"> </td>
	</tr>
	<tr>
		<td> 가입일자 </td> <td><input name="joindate" value="<%=mTime%>"> </td>
	</tr>
	<tr>
		<td> 고객등급[A:VIP,B:일반,C:직원] </td> <td><input name="grade"> </td>
	</tr>
	<tr>
		<td> 도서코드 </td> <td><input name="city"> </td>
	</tr>
	<tr>
		<td colspan="2"><button id="button1" onclick="button1_click()">등록</button> &nbsp;&nbsp;
		<button id="select"><a href="./view_Edit">조회</a></button></td>	
	</tr>
</table>
<%@ include file="../main/footer.jsp" %>
</form>
</body>
</html>