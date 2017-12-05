<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2017/12/4
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="./Css/bootstrap.css">
    <link rel="stylesheet" href="./Css/bootstrap-theme.css">
    <style>
        #logindev{
            position: absolute;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -moz-transform:  translateY(-50%);
            -ms-transform:  translateY(-50%);
            -o-transform:  translateY(-50%);
            transform:  translateY(-50%);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="col-xs-10 col-xs-offset-1 col-sm-10 col-md-10 col-lg-10 col-md-offset-1" id="logindev">
            <form class="form-horizontal" role="form" action="dologin" >
                <div class="form-group">
                    <h3>登陆</h3>
                </div>
                <div class="form-group">
                    <lable for="firstname" class="control-label col-md-3">用户名：</lable>
                    <div class="col-md-4">
                        <input name="id" type="text" id="firstname"class="form-control" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <lable for="secondname" class="control-label col-md-3">密码：</lable>
                    <div class="col-md-4">
                        <input name="psd" type="password" id="secondname" class="form-control" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <input type="submit" class="btn btn-default">
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
