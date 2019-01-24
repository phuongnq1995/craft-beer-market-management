<tiles:insertDefinition name="layouts">
	<tiles:putAttribute name="header-link">
		<input type="hidden" id="confirmMessage" value='<spring:message code="confirm.delete"/>' />
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> <spring:message
						code="labels.home" /></a></li>
			<li><a href="${pageContext.request.contextPath}/beer"><i class="fa fa-list"></i> <spring:message
						code="labels.beer.list" /></a></li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="cbm-page-header col-md-10 col-md-offset-1">
			<h3>
				<spring:message code="labels.beer.list" />
			</h3>
			<a href="${pageContext.request.contextPath}/beer/register" class="pull-right"> <i class="fa fa-plus"></i>
				<spring:message code="labels.beer.new" />
			</a>
		</div>
		<div class="col-md-6 col-md-offset-3 cbm-top-buffer">
			<table class="table">
				<thead>
					<tr>
						<th><spring:message code="labels.beer.name" /></th>
						<th><spring:message code="labels.beer.description" /></th>
						<th><spring:message code="labels.button.delete" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${beers}" var="beer">
						<tr>
							<td><a href="${pageContext.request.contextPath}/beer/update/${beer.getbeerId()}">
									${beer.getName()}
								</a>
							</td>
							<td>${beer.getDescription()}</td>
							<td>
								<a href="${pageContext.request.contextPath}/beer/delete/${beer.getbeerId()}" 
									class="delete">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
