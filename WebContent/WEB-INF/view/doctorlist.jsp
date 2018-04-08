<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<input type="button" value="Add Doctor"
	onclick="window.location.href='adddoctor'; return false;" />
<br />
<body>
	<hr />
	<table>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<br />
		<c:forEach var="tempdoctor" items="${DOCTOR}">
			<c:url var="updatelink" value="/doctorupdate">
				<c:param name="doctorid" value="${tempdoctor.id}" />
			</c:url>
			<c:url	 var="deletelink" value="/doctordelete">
				<c:param name="doctorid" value="${tempdoctor.id}" />
			</c:url>
			<tr>
				<td>${tempdoctor.doctorname}</td>
				<td>${tempdoctor.address}</td>
				<td>${tempdoctor.email}</td>
				<td><a href="${updatelink}">update</a></td>
				<td><a href="${deletelink}">delete</a></td>
			</tr>
			<br />
		</c:forEach>
</body>
</html>