<tiles:insertDefinition name="layouts">

	<tiles:putAttribute name="header-link">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i>
				<spring:message code="labels.home" /></a>
			</li>
			<li><a href="${pageContext.request.contextPath}/auth/register"><i class="fa fa-plus"></i>
				<spring:message code="labels.auth.register" /></a>
			</li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<form:form method="post" modelAttribute="authForm" action="${pageContext.request.contextPath}/auth/register">
			<div class="row">
				<div class="cbm-page-header col-md-10 col-md-offset-1">
					<h3>
						<spring:message code="labels.auth.register" />
					</h3>
				</div>

				<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
					<form:errors path="*" cssClass="alert cbm-error" delimiter="<br/>" element="div" cssStyle="" />
					<table class="table table-bordered">
						<colgroup>
							<col width="20%" />
							<col width="30%" />
							<col width="20%" />
							<col width="30%" />
						</colgroup>
						<tr>
							<th><form:label path="fullname">
									<spring:message code="labels.user.fullname" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="fullname" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="username">
									<spring:message code="labels.user.username" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="username" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="password">
									<spring:message code="labels.user.password" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:password cssClass="form-control" path="password" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="passwordConfirm">
									<spring:message code="labels.user.passwordConfirm" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td><form:password cssClass="form-control" path="passwordConfirm" autofocus="true" maxlength="200" />
							</td>
						</tr>
					</table>
					<button type="submit" class="btn btn-success pull-right">
						<spring:message code="labels.button.create" />
					</button>
				</div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
