<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginSuccess</title>
</head>
<body>
<%
if((session.getAttribute("Userid") == null) ||(session.getAttribute("pass") == null))
{
	response.sendRedirect("Login.html");
}

if(request.getSession(false)!=null)
{
	out.println("Login Successfully"+session.getAttribute("Userid"));
 
}
%>

<a href="LogoutServlet">Logout</a>
</body>
</html>