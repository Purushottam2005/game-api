<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Game Repository</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/ob.png" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.1/css/font-awesome.css" rel="stylesheet">
	</head>
	<body>
		<div id="content" class="col-lg-4 col-lg-offset-4">
			<jsp:include page="/WEB-INF/pages/${viewName}.jsp"/>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/addGame.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tableRowSelectPlugin.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tableSelect.js"></script>
	</body>
</html>