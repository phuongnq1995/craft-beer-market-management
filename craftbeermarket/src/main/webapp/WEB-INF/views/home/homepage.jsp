<tiles:insertDefinition name="layouts">
	<tiles:putAttribute name="header-link">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> 
				<spring:message code="labels.home" /></a>
			</li>
		</ol>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<a href="${pageContext.request.contextPath}/auth/register">
			<i class="fa fa-plus"></i><spring:message code="labels.auth.register" />
		</a><br/>
		<a href="${pageContext.request.contextPath}/category">
			<i class="fa fa-plus"></i><spring:message code="labels.category.list" />
		</a><br/>
		<a href="${pageContext.request.contextPath}/beer">
			<i class="fa fa-plus"></i><spring:message code="labels.beer.list" />
		</a><br/>
	</tiles:putAttribute>
</tiles:insertDefinition>
