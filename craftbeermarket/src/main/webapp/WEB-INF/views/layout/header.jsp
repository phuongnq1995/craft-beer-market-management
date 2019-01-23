<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<!-- insert logo -->
			<a class="navbar-brand-cbm" href="${pageContext.request.contextPath}">
				<img src="${pageContext.request.contextPath}/resources/app/images/logo.png" width="32" height="32" alt="logo">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href="${pageContext.request.contextPath}">
						<spring:message code="labels.home" />
					</a>
				</li>
				<li><a href="#">About</a></li>
				<li><a href="#">Projects</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- insert login/logout buttons -->
			</ul>
		</div>
	</div>
</nav>
