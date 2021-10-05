<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Building</title>
</head>
<body>
<form:form method="PATCH"  action="/building/update/${building.id}" modelAttribute="building">

    New shortName <form:input path="shortName"/><br><br>

    <input type="submit" value="Edit building">
</form:form>
</body>
</html>
