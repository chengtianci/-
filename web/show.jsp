<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2017/11/20
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>something</title>
    <link rel="stylesheet" href="./Css/bootstrap-theme.css">
    <link rel="stylesheet" href="./Css/bootstrap.css">
</head>
<body>
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
            <h2><%= request.getAttribute("title") %></h2>
            <div class="panel-group">
                <%= request.getAttribute("obj").toString() %>
            </div>
        </div>
    </div>
</body>
</html>
