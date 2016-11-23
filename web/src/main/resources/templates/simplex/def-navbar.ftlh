<nav class="navbar navbar-default navbar-fixed-top" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<i class="fa fa-bars fa-fw" aria-hidden="true"></i> Menu
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="${contextRoot}"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<#if principal??>
					<li title="No notifications" data-toggle="tooltip" data-placement="bottom">
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-bell-slash fa-fw" aria-hidden="true"></i> Notifications <i class="fa fa-caret-down fa-fw"></i>
						</a>
					</li>
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<i class="fa fa-user fa-fw" aria-hidden="true"></i> ${principal.user.firstname!} ${principal.user.lastname!} <i class="fa fa-caret-down fa-fw"></i>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-header">Signed in as <strong>${principal.username}</strong></li>
							<li class="divider"/>
							<li><a href="${contextRoot}/auth/profile"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i> Edit your profile</a></li>
							<li><a href="${contextRoot}/help"><i class="fa fa-question fa-fw" aria-hidden="true"></i> Help</a></li>
							<li class="divider" aria-hidden="true"/>
							<li><a href="${contextRoot}/help"><i class="fa fa-cog fa-fw" aria-hidden="true"></i> Settings</a></li>
							<li><a href="${contextRoot}/sign-out"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Sign out</a></li>
						</ul>
					</li>
				</#if>
				<#if showSignup && (principal?? == false)><li><a href="${contextRoot}/sign-up"><i class="fa fa-user-plus fa-fw" aria-hidden="true"></i> Create account</a></li></#if>
				<#if showSignin && (principal?? == false)>
					<li>
						<a id="signin-link" href="${contextRoot}/sign-in?ajax" data-toggle="modal" data-target="#signin-modal" data-remote="false"><i class="fa fa-sign-in fa-fw" aria-hidden="true"></i> Sign in</a>
					</li>
				</#if>
			</ul>
		</div>
	</div>
</nav>

<div class="modal fade" id="signin-modal"></div>

<#if showSignin && (principal?? == false)>
	<#assign templateScripts>
		${templateScripts}
		<script>
			$("#signin-modal").on("show.bs.modal", function() {
				$("#signin-modal").load($("#signin-link").attr("href"));
			});
		</script>
	</#assign>
</#if>