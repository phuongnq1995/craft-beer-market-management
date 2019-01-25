<c:if test="${not empty messages}">
	<div class="col-md-8 col-md-offset-2 cbm-top-buffer">
		<div class="alert alert-${messages.type.value}">${messages.message}</div>
	</div>
</c:if>