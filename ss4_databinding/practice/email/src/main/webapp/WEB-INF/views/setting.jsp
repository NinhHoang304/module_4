<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/2/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/update" method="post" modelAttribute="setting">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages">
                    <form:option value="1">English</form:option>
                    <form:option value="2">Vietnamese</form:option>
                    <form:option value="3">Japanese</form:option>
                    <form:option value="4">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${size}"></form:options>
                </form:select>
                 emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:radiobutton path="spamsFilter" value="true"></form:radiobutton> Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"></form:textarea><br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
                <input type="reset" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
