<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="RegisterServlet" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Phone: <input type="text" name="phone"><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>