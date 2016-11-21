<#if (pageTitle)?has_content>
	<div class="container">
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-12">
					<h1>${pageTitle}</h1>
					<#if (pageSubtitle)?has_content><p class="lead"><em>${pageSubtitle}</em></p></#if>
				</div>
			</div>
		</div>
	</div>
</#if>