<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Onu Details</title>
</head>
<body>

Onu Id <c:out value="${onu.id}"/>
<br><br>
Onu ShortName <c:out value="${onu.shortName}"/>
<br><br>
Onu Serial Number <c:out value="${onu.serialNumber}"/>
<br><br>
Onu Building Id <c:out value="${onu.buildingId}"/>

</body>
</html>