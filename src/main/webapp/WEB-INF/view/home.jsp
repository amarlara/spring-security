<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	Welcome!
	<br> User:
	<security:authentication property="principal.username" />
	Role(s) :
	<security:authentication property="principal.authorities" />

	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for Managers)
		</p>
		<hr>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin</a>
		</p>
		<hr>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>