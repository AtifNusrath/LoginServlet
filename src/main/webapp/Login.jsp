<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16-11-2021
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="Login" method="get">
		<pre>
		Enter email    : <input type="text" name="email" required/><br>
		Enter password : <input type="password" name="password" required/><br>
	       <input type="submit" value="login"
                  style="border-radius: 8px; outline: none; background-color: lightblue;"> </input>
                <a href="ForgotPassword.jsp">Forgot Password</a> <a href="Registration.jsp">Register Here</a>
		</pre>
</form>
</body>
</html>
