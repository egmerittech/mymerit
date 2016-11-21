<nav class="navbar navbar-default navbar-fixed-top" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<i class="fa fa-bars fa-fw" aria-hidden="true"></i> Menu
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="${contextroot}"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<#if principal??>
				<ul class="nav navbar-nav navbar-right">
					<li title="No notifications" data-toggle="tooltip" data-placement="bottom">
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-bell-slash fa-fw" aria-hidden="true"></i> Notifications <i class="fa fa-caret-down fa-fw"></i>
						</a>
					</li>
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<i class="fa fa-user fa-fw" aria-hidden="true"></i> ${principal.firstname} ${principal.lastname} <i class="fa fa-caret-down fa-fw"></i>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-header">Signed in as <strong>${principal.username}</strong></li>
							<li class="divider"/>
							<li><a href="${contextroot}/auth/profile"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i> Edit your profile</a></li>
							<li><a href="${contextroot}/help"><i class="fa fa-question fa-fw" aria-hidden="true"></i> Help</a></li>
							<li class="divider" aria-hidden="true"/>
							<li><a href="${contextroot}/help"><i class="fa fa-cog fa-fw" aria-hidden="true"></i> Settings</a></li>
							<li><a href="${contextroot}/sign-out"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Sign out</a></li>
						</ul>
					</li>
				</ul>
			<#else/>
				<ul class="nav navbar-nav navbar-right">
					<#if showsignup><li class="active"><a href="${contextroot}/sign-up"><i class="fa fa-user-plus fa-fw" aria-hidden="true"></i> Create account</a></li></#if>
					<#if showsignin><li><a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in fa-fw" aria-hidden="true"></i> Sign in</a></li></#if>
				</ul>
			</#if>
		</div>
	</div>
</nav>

<#if showsignin && principal?? == false>
	<div class="modal fade" id="login-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="signin-form-ajax" action="${contextroot}/sign-in" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Sign in to myMerit</h4>
					</div>
					<div class="modal-body">
						<div id="signin-form-error-alert"></div>
						<div class="well">
							<div class="form-group ">
								<label for="username" class="control-label">Email Address</label>
								<input type="email" id="username" name="username" class="form-control" placeholder="Email Address" required>
							</div>
		
							<div class="form-group ">
								<label for="password" class="control-label">Password</label>
								<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
							</div>
		
							<div class="checkbox">
								<label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="signin-button" class="btn btn-lg btn-primary btn-block" type="submit">Sign in to <i class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</#if>