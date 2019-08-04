<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid</title>
</head>
<body>
<%
String flag = (String) request.getAttribute("flag");
if(flag.equals("Active"))
{
	out.println("Only One User can Login with Same Id and Password");
	
}
%>
<form action ="Login.html">
<input type="submit" value="Back To Home">
</form>
</body>
</html>