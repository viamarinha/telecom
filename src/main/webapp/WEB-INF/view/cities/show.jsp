<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
</head>
<body>
<c:out value="${city.id}"/>
<c:out value="${city.code}"/>
<br><br>
<c:forEach var="region" items="${city.regions}">

    <c:out value="${region}"/>
<%--    <c:out value="${region.id}"/>--%>
<%--    <c:out value="${region.shortName}"/>--%>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

</c:forEach>

<a href="/cities/edit/${city.id}">Update City</a>
<br><br>
<a href="/cities/delete/${city.id}">Delete City</a>
</body>
</html>
