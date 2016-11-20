<div class="container" id="alerts">
	<#if dangerAlert??>
		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-dismissible alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<@spring.message dangerAlert/>
				</div>
			</div>
		</div>
	</#if>
	
	<#if successAlert??>
		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-dismissible alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<@spring.message successAlert/>
				</div>
			</div>
		</div>
	</#if>
</div>