<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
</head>
<body>
<h1>Homepage</h1>
<ul>
    <c:forEach items="${last5article}" var="article">
        <li>Article Id: ${article.id} Title: ${article.title} Author: ${article.author.firstName} ${article.author.lastName}</li>
    </c:forEach>
</ul>
</body>
</html>
