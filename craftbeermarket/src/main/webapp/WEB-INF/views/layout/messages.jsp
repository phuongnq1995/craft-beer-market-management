<c:if test="${not empty messages}">
	<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
		<div class="alert alert-${messages.type.value}">
			<spring:message code="${messages.code}" arguments="${messages.args}" />
		</div>
	</div>
</c:if>
