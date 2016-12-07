<%--
  Created by IntelliJ IDEA.
  User: Cro
  Date: 2016-12-06
  Time: 오전 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>트위터 검색 결과: 검색어 - ${keyword}</h2>

<c:forEach var="item" items="${tweets}">
    ${item.getTitle()}, ${item.getImage()} <br/><br/>
</c:forEach>
</body>
</html>
