<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<form:form method="post" action="/login">
<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center" cellspacing="2">

<tr>
<td colspan=2>
<p style="text-align: center"><font size=4><b> Login Form</b></font></p>
</td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="userName"  size="30"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"  size="30"></td>
</tr>                
<tr>
<td>
<input type="submit" value="Login">
</td>
</tr>
</table>
</form:form>
<p style="font-size: 30">New User?<a href="/register">Register Here</a><p>    
</body>
</html>