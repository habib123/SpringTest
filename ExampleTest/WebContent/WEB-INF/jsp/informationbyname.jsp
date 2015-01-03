<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<i>${message}</i><br/>
okkkkkkkkkkkkk<br/>

<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="25px">id</th><th width="150px">Name</th><th width="25px">password</th><th width="50px">actions</th>
</tr>
</thead>
<tbody>

<c:forEach var="student" items="${studentList}">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.password}</td>
<td>
<a href="${pageContext.request.contextPath}/edit/${student.id}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/delete/${student.id}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>