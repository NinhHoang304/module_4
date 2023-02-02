<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/2/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Create new employee</h2>
<form:form method="post" action="addEmployee" modelAttribute="employee">
<table>
    <tr>
        <td><form:label path="id">Employee ID: </form:label></td>
        <td><form:input path="id"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="name">Employee Name: </form:label></td>
        <td><form:input path="name"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="contactNumber">Contact Number: </form:label></td>
        <td><form:input path="contactNumber"></form:input></td>
    </tr>
    <tr>
        <td><input type="submit" value="submit"></td>
    </tr>
</table>
</form:form>
</body>
</html>
