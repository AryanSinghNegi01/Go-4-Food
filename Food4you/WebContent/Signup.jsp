<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import= "java.sql.*" %>

<%
try{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	 Statement st=c.createStatement();
	 
	 String fname = request.getParameter("fname");
	 String lname = request.getParameter("lname");
	 String username = request.getParameter("username");
	 String email = request.getParameter("email");
	 long mobile = Long.parseLong(request.getParameter("mobile"));
	 String address = request.getParameter("address");
	 String password = request.getParameter("password");
	 //String cpass= request.getParameter("cpass");
	 String gender = request.getParameter("Gender");
	 
     String s="insert into Signup values('"+fname+"','"+lname+"','"+username+"','"+email+"','"+mobile+"','"+address+"','"+password+"','"+gender+"')";
     st.executeUpdate(s);
     out.println("Data Inserted Successfully");
     
     
 
	
}
catch(Exception e){
	out.println("Error: "+ e);
}
%>
Please Login Here <a href='Signin.html'>Go to Login</a>


</body>
</html>