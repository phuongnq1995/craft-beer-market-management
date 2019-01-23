<tiles:insertDefinition name="layouts">
	<tiles:putAttribute name="header-link">
		<div class="breadcrumb">
			<ul class="breadcrumb">
				<li>
					<a href="${pageContext.request.contextPath}/">
						<spring:message code="labels.home" />
					</a>
				</li>
				<tiles:insertAttribute name="breadcrumb" ignore="true" />
			</ul>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		Hello world
	</tiles:putAttribute>
</tiles:insertDefinition>
