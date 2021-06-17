<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteCity</title>
</head>
<body>
<form:form method="DELETE" action="/cities/delete/${city.id}" modelAttribute="city">
    City id <c:out value="${city.id}"/>
    <br><br>
    City Code <c:out value="${city.code}"/>
    <br><br>
    <input type="submit" value="Delete City"/>
</form:form>
</body>
</html>
