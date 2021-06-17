<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="PATCH" action="/status/update/${status.id}" modelAttribute="status">

    Active <form:input path="active"/><br><br>
    In service <form:input path="inService"/><br><br>
    Functional <form:input path="functional"/><br>

    <input type="submit" value="Update">

</form:form>
</body>
</html>
