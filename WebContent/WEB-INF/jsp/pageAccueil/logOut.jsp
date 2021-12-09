<!-- @author: Maxence */ --> 



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>déconnexion</title>
</head>
<body>
<%@ include file="header.html" %>
<%
session.invalidate();
%>
<jsp:forward page="pageAccueil.jsp">
<jsp:param name="msg" value="msg" />
</jsp:forward>

<%@ include file="footer.html" %>
</body>
</html>