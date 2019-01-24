<tiles:insertDefinition name="layouts">
	<tiles:putAttribute name="header-link">
		<input type="hidden" id="confirmMessage" value='<spring:message code="confirm.delete"/>' />
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> <spring:message
						code="labels.home" /></a></li>
			<li><a href="${pageContext.request.contextPath}/category"><i class="fa fa-list"></i> <spring:message
						code="labels.category.list" /></a></li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="cbm-page-header col-md-10 col-md-offset-1">
			<h3>
				<spring:message code="labels.category.list" />
			</h3>
			<a href="${pageContext.request.contextPath}/category/register" class="pull-right"> <i class="fa fa-plus"></i>
				<spring:message code="labels.category.new" />
			</a>
		</div>
		<div class="col-md-6 col-md-offset-3 cbm-top-buffer">
			<table class="table">
				<thead>
					<tr>
						<th><spring:message code="labels.category.name" /></th>
						<th><spring:message code="labels.category.description" /></th>
						<th><spring:message code="labels.button.delete" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categories}" var="category">
						<tr>
							<td><a href="${pageContext.request.contextPath}/category/update/${category.getCategoryId()}">
									${category.getName()}
								</a>
							</td>
							<td>${category.getDescription()}</td>
							<td>
								<a href="${pageContext.request.contextPath}/category/delete/${category.getCategoryId()}" 
									class="delete">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script src="${pageContext.request.contextPath}/resources/app/js/category/index.js"></script>
	</tiles:putAttribute>
</tiles:insertDefinition>
