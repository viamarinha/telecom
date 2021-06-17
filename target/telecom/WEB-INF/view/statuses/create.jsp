<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/status/create" modelAttribute="status">

    Active <form:input path="active"/>
    <br><br>
    In service <form:input path="inService"/>
    <br><br>
    Functional <form:input path="functional"/>
    <br><br>
    <input type="submit" value="Add new Status">

</form:form>

</body>
</html>
