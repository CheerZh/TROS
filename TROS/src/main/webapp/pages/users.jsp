<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>用户列表</title>
<style type="text/css">
    td{
        text-align: center;
        color: red;
    }
</style>
</head>
<body>
    <h1 align="center" style="color: black">用户列表</h1>
    <table align="center" border="1px" width="60%">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PASSWD</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userPass}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>