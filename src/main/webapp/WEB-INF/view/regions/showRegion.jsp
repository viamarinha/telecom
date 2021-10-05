<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Region</title>
</head>
<body>
Id <c:out value="${region.id}"/>
<br><br>
Code <c:out value="${region.code}"/>
<br><br>
ShortName <c:out value="${region.shortName}"/>
<br><br>
<c:forEach var="address" items="${region.addressees}">
    <c:out value="${address}"/>
</c:forEach>

</body>
</html>
