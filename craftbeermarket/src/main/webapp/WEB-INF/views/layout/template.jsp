<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />
<c:set var="titleKey">
	<tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="Craft beer market" /></title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/app/images/logo.png">
<link href="${pageContext.request.contextPath}/resources/common/css/theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/app/css/styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/webjars/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/webjars/jquery/3.1.1/jquery.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>
<body>

	<tiles:insertAttribute name="header" />

	<div class="link-header">
		<tiles:insertAttribute name="header-link" ignore="true" />
	</div>

	<!-- Message to user -->
	<div class="container-fluid body">
		<c:if test="${not empty message}">
			<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
				<div class="alert alert-info">
					${message}
				</div>
			</div>
		</c:if>
		<tiles:insertAttribute name="body" />
	</div>

	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>

	<!-- Delete confirm -->
	<input type="hidden" id="confirmMessage" value='<spring:message code="confirm.delete"/>' />
	<script src="${pageContext.request.contextPath}/resources/app/js/common.js"></script>
</body>
</html>
