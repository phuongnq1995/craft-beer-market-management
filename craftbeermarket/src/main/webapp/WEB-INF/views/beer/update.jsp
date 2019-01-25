<tiles:insertDefinition name="layouts">

	<tiles:putAttribute name="header-link">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> <spring:message
						code="labels.home" /></a></li>
			<li><a href="${pageContext.request.contextPath}/beer"><i class="fa fa-list"></i> <spring:message
						code="labels.beer.list" /></a></li>
			<li><a href="${pageContext.request.contextPath}/beer/update"><i class="fa fa-cloud-upload"></i> <spring:message
						code="labels.beer.update" /></a></li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<form:form method="post" modelAttribute="beerForm" action="${pageContext.request.contextPath}/beer/update">
			<div class="row">
				<div class="cbm-page-header col-md-10 col-md-offset-1">
					<h3>
						<spring:message code="labels.beer.update" />
					</h3>
				</div>
				<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
					<form:errors path="*" cssClass="alert cbm-error" delimiter="<br/>" element="div" cssStyle="" />
					<form:hidden path="beerId"/>
					<table class="table table-bordered">
						<colgroup>
							<col width="15%" />
							<col width="20%" />
							<col width="15%" />
							<col width="15%" />
							<col width="15%" />
							<col width="20%" />
						</colgroup>
						<tr>
							<th><form:label path="name">
									<spring:message code="labels.beer.name" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="name" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="manufacturer">
									<spring:message code="labels.beer.manufacturer" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="manufacturer" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="categoryId">
									<spring:message code="labels.beer.category" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3">
								<form:select path="categoryId" items="${categories}" itemValue="categoryId" itemLabel="name" cssClass="form-control" autofocus="true" maxlength="200"></form:select>
							</td>
						</tr>
						<tr>
							<th><form:label path="country">
									<spring:message code="labels.beer.country" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="country" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="price">
									<spring:message code="labels.beer.price" />
									<label class="cbm-required-field">*</label>
								</form:label></th>
							<td colspan="3"><form:input type="number" cssClass="form-control" path="price" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="description">
									<spring:message code="labels.beer.description" />
								</form:label></th>
							<td colspan="3"><form:input type="text" cssClass="form-control" path="description" autofocus="true"
									maxlength="200" /></td>
						</tr>
						<tr>
							<th><form:label path="isArchived">
									<spring:message code="labels.beer.isArchived" />
								</form:label></th>
							<td colspan="3">
							<form:radiobuttons path="isArchived" items="${beerStatus}" itemLabel="name" itemValue="value" 
								autofocus="true" maxlength="200" />
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
