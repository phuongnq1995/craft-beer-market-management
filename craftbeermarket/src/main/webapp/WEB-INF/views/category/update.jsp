<tiles:insertDefinition name="layouts">

	<tiles:putAttribute name="header-link">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> <spring:message
						code="labels.home" /></a></li>
			<li><a href="${pageContext.request.contextPath}/category"><i class="fa fa-list"></i> <spring:message
						code="labels.category.list" /></a></li>
			<li><a href="#"><i class="fa fa-cloud-upload"></i><spring:message
						code="labels.category.update" /></a></li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<form:form method="post" modelAttribute="categoryForm" action="${pageContext.request.contextPath}/category/update">
			<div class="row">
				<div class="cbm-page-header col-md-10 col-md-offset-1">
					<h3>
						<spring:message code="labels.category.update" />
					</h3>
				</div>

				<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
					<form:errors path="*" cssClass="alert cbm-error" delimiter="<br/>" element="div" cssStyle="" />
					<form:hidden path="categoryId"/>
					<table class="table table-bordered">
						<colgroup>
							<col width="40%" />
							<col width="60%" />
						</colgroup>
						<tr>
							<th><form:label path="name">
									<spring:message code="labels.category.name" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="name" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="description">
									<spring:message code="labels.category.description" />
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="description" autofocus="true"
									maxlength="200" /></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-success pull-right">
						<spring:message code="labels.button.update" />
					</button>
				</div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
