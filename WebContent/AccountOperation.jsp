<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AcctOperations">

<%String name=request.getParameter("user");%>
<h1>Welcome!!!!<%=name %></h1>
<%if(name.equals("manager")){%>
Enter the operation:<input type="text" name="op">

<%} else if(name.equals("staff")){ %>
AccNo:<input type="text" name="accno">
Amount:<input type="text" name="amt" value="amt">
Type:<input type="text" name="type">

<%}else { %>
<h2>Invalid details!!!</h2>
<%} %>
<input type="submit" value="Submit">
</form>

</body>
</html>