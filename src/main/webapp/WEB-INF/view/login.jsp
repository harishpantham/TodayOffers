<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
 
<body>
<form:form method="post" action="/login">
<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center" cellspacing="2">

<tr>
<td colspan=2>
<center><font size=4><b> Login Form</b></font></center>
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
<input type="submit" value="Register Here">
</td>
</tr>


</table>
 </form:form>    
</body>
</html>