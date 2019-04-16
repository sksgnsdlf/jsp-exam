<%@page import="DBPKG.Memdao"%>
<%@page import="DBPKG.bean"%>
<%@page import="java.beans.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../main/header.jsp" %>
<%@ include file="../main/nav.jsp" %> <br><br>
<TABLE border="1" style="margin-left: auto; margin-right: auto; text-align:center">
	<tr><td>userid</td><td>custname</td><td>phone</td><td>address</td><td>joindate</td><td>grade</td><td>city</td></tr>
		<c:forEach items="${list}" var="beans">	
		<tr><td><a href="update?custno=${beans.getCustno()}">${beans.getCustno()}</a></td><td>${beans.getCustname()}</td><td>${beans.getPhone()}</td>
		<td>${beans.getAddress()}</td><td>${beans.getJoindate()}</td><td>${beans.getGrade()}</td><td>${beans.getCity()}</td>
		</tr>
		</c:forEach>
</TABLE>
<%@ include file="../main/footer.jsp" %>
</body>
</html>