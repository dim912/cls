<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Being Java Guys | Registration Form</title>  
</head>  
<body>  
<center>  
  
<div style="color: teal;font-size: 30px">Being Java Guys | Registration Form</div>  
  
  
<c:url var="userRegistration" value="/user/submitStaffMemberRegister.html"/>  
<%--  <form:form id="registerForm" modelAttribute="user" method="post" action="${userRegistration}">   --%>
<form:form id="registerForm" method="post" action="${userRegistration}">  <%--  default is  modelAttribute="command" method="post" action="${userRegistration}">   --%> 
<!-- modelAttribute="user" is the default value -->
<table width="400px" height="150px">  
<tr>  
<td><form:label path="firstName">First Name</form:label></td>  
<td><form:input  path="firstName"/></td>  

<td><form:label path="firstName">First Name</form:label></td>  
<td><form:input  path="dob"/></td>  


</tr>  

<input type="submit" value="Register" />  
</td></tr>  
</table>  
</form:form>  
  
  
<a href="userList.html" >Click Here to see User List</a>  
</center>  
</body>  
</html>  