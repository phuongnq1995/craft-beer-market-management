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
						<th><spring:message code="labels.beer.manufacturer" /></th>
						<th><spring:message code="labels.beer.category" /></th>
						<th><spring:message code="labels.beer.country" /></th>
						<th><spring:message code="labels.beer.price" /></th>
						<th><spring:message code="labels.beer.description" /></th>
						<th><spring:message code="labels.beer.status" /></th>
						<th><spring:message code="labels.button.delete" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${beers}" var="beer">
						<tr>
							<td><a href="${pageContext.request.contextPath}/beer/update/${beer.getBeerId()}">
									${beer.getName()}
								</a>
							</td>
							<td>${beer.getManufacturer()}</td>
							<td>${beer.getCategoryName()}</td>
							<td>${beer.getCountry()}</td>
							<td>${beer.getPrice()}</td>
							<td>${beer.getDescription()}</td>
							<td>
								<c:choose>
									<c:when test="${beer.getIsArchived()}">
										<i class="glyphicon glyphicon-remove" style="color:red"></i>
									</c:when>
									<c:otherwise>
										<i class="fa fa-check" style="color:green"></i>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/beer/delete/${beer.getBeerId()}" 
									class="delete">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
