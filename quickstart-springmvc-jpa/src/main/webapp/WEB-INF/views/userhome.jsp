<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	<link type="text/css" href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	<script>
	$(function() {
		//alert('jQuery Initialized successfully');
	});
	</script>
</head>

<body>
	Welcome to User Home Page!!
	<p><a href="welcome.htm">Home</a> </p>
	<p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
	<h2>List of Users:</h2>
	<div>
		<c:if test="${USERS != null }">
			<c:forEach items="${USERS}" var="user">
				<p>${user.userId} - ${user.userName}</p>
			</c:forEach>
		</c:if>
	</div>
</body>

</html>