<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Regions</title>
</head>
<body>
<c:forEach var="region" items="${regions}">

    <c:out value="${region.code}"/>
    <c:out value="${region.id}"/>
    <c:out value="${region.shortName}"/>



    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

</c:forEach>
</body>
</html>
