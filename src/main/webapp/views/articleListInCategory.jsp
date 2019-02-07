<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Article List In Category</title>
</head>
<body>
<h1>Article List In Category ${categoryName}</h1>
<ul>
    <c:forEach items="${articleListInCategory}" var="article">
        <li>Article Id: ${article.id} Title: ${article.title} Author: ${article.author.firstName} ${article.author.lastName}
        Date created: ${article.created}<br/>
            Content: <br/>${article.content}
        </li>
    </c:forEach>
</ul>

</body>
</html>
