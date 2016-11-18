<nav class="navbar navbar-default navbar-fixed-top" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"/>
				<span class="icon-bar"/>
				<span class="icon-bar"/>
			</button>
			<a class="navbar-brand" href="${contextroot}">myMerit</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<#if principal??>
				<#assign name><#if principal.firstname?? && principal.lastname??>${principal.firstname} ${principal.lastname}<#else/>${principal.username}</#if></#assign>
				<ul class="nav navbar-nav navbar-right">
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> <span class="caret"/></a>
						<ul class="dropdown-menu" role="menu">
							<li><a>Signed in as <strong>${name}</strong></a></li>
							<li class="divider"/>
							<li><a href="${contextroot}/auth/profile">Your profile</a></li>
							<li><a href="${contextroot}/help">Help</a></li>
							<li class="divider"/>
							<li><a href="${contextroot}/sign-out">Sign out</a></li>
						</ul>
					</li>
				</ul>
			<#else/>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${contextroot}/sign-in">Sign in</a></li>
					<li class="active"><a href="${contextroot}/sign-up">Sign up</a></li>
				</ul>
			</#if>
		</div>
	</div>
</nav>