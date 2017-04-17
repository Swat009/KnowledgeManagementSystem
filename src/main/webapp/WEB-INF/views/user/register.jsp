<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>

<c:url var="action" value="/create" ></c:url>
<form:form action="${action}" method="post"  modelAttribute="user">

<table>

<tr>
<td><form:label path="name" >Name:</form:label></td>
<td><form:input path="name" /></td>

</tr>


<tr>
<td><form:label path="rollno" >Roll no:</form:label></td>
<td><form:input path="rollno" /></td>
</tr>

<tr>
<td><form:label path="password" >Password:</form:label></td>
<td><form:input path="password" /></td>

</tr>

<tr>
<td colspan="2"><input type="submit" value="Add user"/></td>
</tr>


</table>


</form:form>
</body>
</html>