<%--
  Created by IntelliJ IDEA.
  User: YOUChanWill
  Date: 2022-11-28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User</title>
    <script>
        function note(){
            const note1 = document.getElementById("note1");
            const note2 = document.getElementById("note2");
            if ((note1.value == null || note1.value === '') || (note2.value == null || note2.value === '')){
                alert("标题和内容不能为空");
                event.preventDefault();
            }
        }

        function title(){
            const title1 = document.getElementById("title");
            if (title1.value == null && title1.value === ''){
                alert("内容不能为空");
                event.preventDefault();
            }
        }
    </script>

    <style>
        .searchtable{
            overflow: auto;
            position: relative;
            height: 350px;
            width: 1500px;
            padding-top:2px;
            padding-left: 60px;
        }

        .searchtable::-webkit-scrollbar {
            border-width:1px;
        }

        .table01 *{
            text-align: center;
        }

        strong {
            font-weight: bold;
        }

        em {
            font-style: italic;
        }

        table {
            background: #f5f5f5;
            border-collapse: separate;
            box-shadow: inset 0 1px 0 #fff;
            font-size: 12px;
            line-height: 24px;
            margin: 30px auto;
            text-align: left;
            width: 800px;
        }

        th {
            background: url(https://jackrugile.com/images/misc/noise-diagonal.png), linear-gradient(#777, #444);
            border-left: 1px solid #555;
            border-right: 1px solid #777;
            border-top: 1px solid #555;
            border-bottom: 1px solid #333;
            box-shadow: inset 0 1px 0 #999;
            color: #fff;
            font-weight: bold;
            padding: 10px 15px;
            position: relative;
            text-shadow: 0 1px 0 #000;
        }

        th:after {
            background: linear-gradient(rgba(255,255,255,0), rgba(255,255,255,.08));
            content: '';
            display: block;
            height: 25%;
            left: 0;
            margin: 1px 0 0 0;
            position: absolute;
            top: 25%;
            width: 100%;
        }

        th:first-child {
            border-left: 1px solid #777;
            box-shadow: inset 1px 1px 0 #999;
        }

        th:last-child {
            box-shadow: inset -1px 1px 0 #999;
        }

        td {
            border-right: 1px solid #fff;
            border-left: 1px solid #e8e8e8;
            border-top: 1px solid #fff;
            border-bottom: 1px solid #e8e8e8;
            padding: 10px 15px;
            position: relative;
            transition: all 300ms;
        }

        td:first-child {
            box-shadow: inset 1px 0 0 #fff;
        }

        td:last-child {
            border-right: 1px solid #e8e8e8;
            box-shadow: inset -1px 0 0 #fff;
        }

        tr {
            background: url(https://jackrugile.com/images/misc/noise-diagonal.png);
        }

        tr:nth-child(odd) td {
            background: #f1f1f1 url(https://jackrugile.com/images/misc/noise-diagonal.png);
        }

        tr:last-of-type td {
            box-shadow: inset 0 -1px 0 #fff;
        }

        tr:last-of-type td:first-child {
            box-shadow: inset 1px -1px 0 #fff;
        }

        tr:last-of-type td:last-child {
            box-shadow: inset -1px -1px 0 #fff;
        }

        tbody:hover td {
            color: transparent;
            text-shadow: 0 0 3px #aaa;
        }

        tbody:hover tr:hover td {
            color: #444;
            text-shadow: 0 1px 0 #fff;
        }


    </style>

</head>
<body>





<form action="AddNote" method="post">
    标题:<input id="note1" type="text" name="title"><br>
    <textarea id="note2" rows="10" cols="30" name="content"></textarea><br>
    <input type="radio" name="root" value="0" checked>不共享
    <input type="radio" name="root" value="1">共享<br>
    <input onclick="note()" type="submit" value="发布笔记"><br>
</form>


<form action="DeleteNote" method="post">
    标题:<input id="title" type="text" name="title"><br>
    <input onclick="title()" type="submit" value="删除笔记"><br>
</form>

<form action="UpdateRoot" method="post">
    笔记标题:<input type="text" name="title"><br>
    <input type="radio" name="root" value="0" checked>不共享
    <input type="radio" name="root" value="1">共享<br>
    <input type="submit" value="更新权限"><br>
</form>


<form action="Exit" method="post">
    <input type="submit" value="退出">
</form>

<div>
    <div class="searchtable">
        <table style="width:1100px;" class="table01">
            <tbody>
            <tr>
                <td>笔记作者</td>
                <td>题目</td>
                <td>内容</td>
            </tr>
            <c:forEach items="${UserNoteList}" var="UserNoteList">
                <tr>
                    <td>${UserNoteList.getUsername()}</td>
                    <td>${UserNoteList.getTitle()}</td>
                    <td>${UserNoteList.getContent()}</td>
                </tr>
            </c:forEach>
            </tbody>
            <colgroup>
                <col style="width: 20%;">
                <col style="width: 20%;">
                <col style="width: 20%;">
            </colgroup>

        </table>
    </div>
</div>

</body>
</html>
