<tiles:insertDefinition name="layouts">
	<tiles:putAttribute name="body">
		<div class="cbm-page-header col-md-10 col-md-offset-1">
			<h3>
				<spring:message code="labels.auth.login" />
			</h3>
		</div>
		<div class="col-md-6 col-md-offset-3 cbm-top-buffer">
			<form:form action="${pageContext.request.contextPath}/auth/login" method="post" modelAttribute="authForm">
				<div class="card card-signin my-5 small shadow">

					<c:if test="${param.containsKey('error')}">
						<div class="alert alert-danger">
							<strong> <spring:message code="message.loginError" /></strong>
						</div>
					</c:if>

					<div class="form-group">
						<label for="username"><spring:message code="labels.user.username" /></label> <input type="text"
							id="username" name="username" class="form-control" placeholder="Username" required autofocus />
					</div>

					<div class="form-group">
						<label for="password"><spring:message code="labels.user.password" /></label> <input type="password"
							id="password" name="password" class="form-control" placeholder="Password" required />
					</div>

					<button class="btn btn-lg btn-light btn-block text-uppercase" type="submit">
						<spring:message code="labels.auth.login" />
					</button>
				</div>
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
