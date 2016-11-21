<div class="container" id="alerts">
	<#if (alertMsg)?has_content>
		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-dismissible ${alertType}">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<@spring.message alertMsg/>
				</div>
			</div>
		</div>
	</#if>
</div>