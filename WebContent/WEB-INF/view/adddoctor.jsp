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
<body>

<form:form action="save" modelAttribute="doctor" method="post">
<form:hidden path="id"/>
DoctorName :<form:input path="doctorname"/><br/>
<form:errors path="doctorname"/>
Address :<form:input path="address"/><br/>
<form:errors path="address"/>
Email :<form:input path="email"/><br/>

<hr/>
<input type="submit" value="Save">

<a href="/FirstSpringMVCProject/doctorlist">Go Back</a>
</form:form>
</body>
</html>