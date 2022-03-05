<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>
<%@page import= "java.sql.*" %>
<%@page import= "javax.sql.*" %>
<%
String userid = request.getParameter("username");
//session. putValue("userid",userid);
String pwd = request.getParameter("password");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from Signup where USERNAME='"+userid+"' ");
if(rs.next()){
	if(rs.getString(7).equals(pwd)){
		// 7 column pass
		out.println("Welcome " + userid);
	}
	else{
		out.println("Invalid username or password try again");
	}
	
	
}

else
%>
<a href = "Signin.html">Home</a>

</body>
</html>