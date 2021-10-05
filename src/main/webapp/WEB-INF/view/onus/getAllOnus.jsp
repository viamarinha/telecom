<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Onus representations</title>
</head>
<body>
<c:forEach var="onu" items="${onus}">

    <c:out value="${onu.id}"/>
    <c:out value="${onu.shortName}"/>
    <c:out value="${onu.serialNumber}"/>
    <c:out value="${onu.buildingId}"/>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

</c:forEach>
</body>
</html>
