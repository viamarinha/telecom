<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Show All buildings</title>
</head>
<body>
<c:forEach items="${buildings}" var="building">

    <c:out value="${building.id}"/>
    <c:out value="${building.shortName}"/>
    <c:out value="${building.adressId}"/>

    <c:forEach var="onu" items="${building.onuList}">
        <c:out value="${onu}"/>
        <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
        ${lineBreaks}
    </c:forEach>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

</c:forEach>
</body>
</html>
