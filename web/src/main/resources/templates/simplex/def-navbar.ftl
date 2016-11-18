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
			<#if user??>
				<ul class="nav navbar-nav navbar-right">
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> <span class="caret"/></a>
						<ul class="dropdown-menu" role="menu">
							<li><a>Signed in as <strong>${user.firstname} ${user.lastname}</strong></a></li>
							<li class="divider"/>
							<li><a href="#">Your profile</a></li>
							<li><a href="#">Help</a></li>
							<li class="divider"/>
							<li><a href="${contextroot}/auth/sign-out">Sign out</a></li>
						</ul>
					</li>
				</ul>
			<#else/>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${contextroot}/auth/sign-in">Sign in</a></li>
				</ul>
			</#if>
		</div>
	</div>
</nav>