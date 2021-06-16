<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
</head>
<body>
<c:out value="${city.id}"/>
<c:out value="${city.code}"/>

<a href="/cities/edit/${city.id}">Update City</a>
<br><br>
<a href="/cities/delete/${city.id}">Delete City</a>
</body>
</html>
