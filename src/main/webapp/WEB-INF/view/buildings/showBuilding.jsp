<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Building</title>
</head>
<body>
<c:out value="${building.id}"/>
<c:out value="${building.shortName}"/>
<c:out value="${building.adressId}"/>
<c:forEach items="${building.onuList}" var="onu">
    <c:out value="${onu}"/>
    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}
</c:forEach>
</body>
</html>
