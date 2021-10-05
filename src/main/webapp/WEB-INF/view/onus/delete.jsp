<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Onu</title>
</head>
<body>
<form:form method="DELETE" action="/onus/deleteOnu/${onu.id}" modelAttribute="onu">
    Id <c:out value="${onu.id}"/>
    <br>
    serialNumber <c:out value="${onu.serialNumber}"/>
    <br>
    ShortName <c:out value="${onu.shortName}"/>
    <br>
    BuildingId<c:out value="${onu.buildingId}"/>
    <br>
    <input type="submit" value="Delete Onu">

</form:form>
</body>
</html>
