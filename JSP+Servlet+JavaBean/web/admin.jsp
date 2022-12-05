<%@ page import="java.util.List" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: YOUChanWill
  Date: 2022-11-28
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>admin</title>
    <script>
        function xss(){
            const psw1 = document.getElementById("psw1");
            const psw2 = document.getElementById("psw2");
            if (psw1.value !==  psw2.value){
                alert("两次密码输入不正确");
                event.preventDefault();
            }
        }
    </script>

</head>
<body>

<table>
    <tr>
        <td>Username</td>
    </tr>

    <c:forEach items="${userList}" var="username">
    <tr>
        <td>${username.getUsername()}</td>
    </tr>
    </c:forEach>

</table>

<table>
    <tr>
        <td>Username</td>
        <td>Title</td>
        <td>Content</td>
    </tr>

    <c:forEach items="${AllNoteList}" var="AllNoteList">
        <tr>
            <td>${AllNoteList.getUsername()}</td>
            <td>${AllNoteList.getTitle()}</td>
            <td>${AllNoteList.getContent()}</td>
            <td>${AllNoteList.getPurview()}</td>
        </tr>
    </c:forEach>

</table>





<form action="AddUser" method="post" >
    设定用户名:<input type="text" name="username" ><br>
    设定密码: <input id="psw1" type="password" name="password" ><br>
    确认密码: <input id="psw2" type="password" name="password" ><br>
    <input onclick="xss()" type="submit" value="创建用户">

</form>


<form action="DeleteUser" method="post" >
    设定用户名:<input type="text" name="username" ><br>
    <input onclick="xss()" type="submit" value="删除用户">
</form>

<form action="AdminDeleteNote" method="post" >
    用户名:<input type="text" name="username" ><br>
    笔记标题: <input type="text" name="title" ><br>
    <input onclick="xss()" type="submit" value="删除笔记">
</form>

<form action="Exit" method="post">
    <input type="submit" value="退出">
</form>






</body>
</html>
