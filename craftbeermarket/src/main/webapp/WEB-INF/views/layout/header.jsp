<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<!-- insert logo -->
			<a class="cbm-navbar-brand" href="${pageContext.request.contextPath}"> <img
				src="${pageContext.request.contextPath}/resources/app/images/logo.png" width="32" height="32" alt="logo">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}"> <spring:message
							code="labels.home" /></a></li>
				<sec:authorize access="isAuthenticated()">
					<li><a href="#">About</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">Contact</a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAuthenticated()">
					<li>
						<a href="#">
							<span class="fa fa-user"></span>
							<sec:authentication property="principal.user.fullname" />
						</a>
					</li>
					<li><a onclick="document.forms['logoutForm'].submit()" class="small-dialog popup-with-zoom-anim"
						href="javascript:void()"> <i class="fa fa-sign-out"></i>
						<spring:message code="labels.auth.logout" /></a>
						<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/auth/logout">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>
