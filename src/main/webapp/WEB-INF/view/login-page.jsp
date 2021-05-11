<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login</title>
</head>
<body>

	<h3>Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<p>
			<c:if test="${param.error}!= null">
				<i> Invalid username/password</i>
			</c:if>
		</p>
		<p>
			<c:if test="${param.logout}!= null">
				<i> You have been logged out!</i>
			</c:if>
		</p>
		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>

</body>
</html>