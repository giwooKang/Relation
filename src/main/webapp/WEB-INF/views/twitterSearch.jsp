<%--
  Created by IntelliJ IDEA.
  User: Cro
  Date: 2016-12-05
  Time: 오후 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
트위터 검색
<form action="/twitter/result" method="GET">
    <!--<input type="hidden" name="userId" value="${userId}"/>-->
    <input type="text" name="keyword" placeholder="검색어"/>
    <input type="submit" value="검색">
</form>
</body>
</html>
