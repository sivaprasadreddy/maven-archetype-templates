<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	Welcome!!
	<h2>List of Blogs:</h2>
	<div>
		<c:if test="${BLOGS != null }">
			<c:forEach items="${BLOGS }" var="blog">
				<p>${blog.blogName }</p>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>