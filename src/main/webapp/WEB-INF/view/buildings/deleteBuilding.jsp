<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Building</title>
</head>
<body>
<form:form method="DELETE" action="/building/deleteBuilding/${building.id}" modelAttribute="building">

   Building Id <c:out value="${building.id}"/><br><br>
   Building ShortName  <c:out value="${building.shortName}"/><br><br>
   Building AddressId <c:out value="${building.adressId}"/><br><br>

    <input type="submit" value="Delete building">


</form:form>
</body>
</html>
