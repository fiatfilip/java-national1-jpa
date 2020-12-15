<%--
  Created by IntelliJ IDEA.
  User: fiatf
  Date: 15.12.20
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <table>
        <c:forEach var="make" items="${requestScope.makes}">
            <tr>
                <td>
                    <c:out value="${make.id}"/>
                </td>
                <td>
                    <c:out value="${make.name}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
