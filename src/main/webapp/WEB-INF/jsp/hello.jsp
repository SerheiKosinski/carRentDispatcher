<%--
  Created by IntelliJ IDEA.
  User: Sun
  Date: 010 10.05.23
  Time: 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
${userName}

<div>
    <h1>System Users</h1>
</div>
<div>
    <table>
        <tr>
            <td>User Id</td>
            <td>User Name</td>
            <td>User Surname</td>
            <td>Passport Number</td>
            <td>Passport Serial</td>
            <td>Driving License</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.passportNumber}</td>
                <td>${user.passportSerial}</td>
                <td>${user.drivingLicense}</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
