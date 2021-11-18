<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16-11-2021
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="Registration" method="get" align="center">
		<pre>
		Enter First Name : <input type="text" name="firstName" required/>

		Enter Last Name  : <input type="text" name="lastName" required/>

		Enter User Name  : <input type="text" name="userName" required/>

		Enter Email      : <input type="text" name="email" required/>

		Enter Mobile     : <input type="text" name="phone"
                                  pattern="[7-9][0-9]{9}"
                                  title="mobile number must be 10 digit it's should start with 7,8 or 9"
                                  required/>

		Enter Password   : <input type="password" name="password"
                                  pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
                                  title="must be 8 alphabet with special symbol" required/>

		<input type="submit"
               style="border-radius: 5px; outline: none; background-color: lightblue;"/>
        <a href="Login.jsp" >Already have an Account?</a>
		</pre>
</form>
</body>
</html>
