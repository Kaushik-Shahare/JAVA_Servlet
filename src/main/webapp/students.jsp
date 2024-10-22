<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.models.Student" %>

<html>
<head>
    <title>Student List</title>
</head>
<body style="text-align: center;">
<h2>Student List</h2>

<form method="post" action="students">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name" required>
    Email: <input type="email" name="email" required>
    <input type="submit" value="Add Student">
</form>

<table border="1" style="text-align: center;">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getEmail() %></td>
        <td>
            <form method="post" action="students" style="display:inline;">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= student.getId() %>">
                <input type="text" name="name" value="<%= student.getName() %>" required>
                <input type="email" name="email" value="<%= student.getEmail() %>" required>
                <input type="submit" value="Update">
            </form>
            <form method="get" action="students" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= student.getId() %>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>