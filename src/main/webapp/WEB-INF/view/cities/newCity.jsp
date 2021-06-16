<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New City</title>
</head>
<body>
<form:form method="POST" action="/cities/new" modelAttribute="city">

    <form:input path="code"/>
    <br><br>
    <input type="submit" value="Create new City">

</form:form>
</body>
</html>
