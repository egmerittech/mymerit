<nav class="navbar navbar-default navbar-fixed-top" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<i class="fa fa-bars"></i> Menu
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="${contextroot}"><i class="fa fa-trophy"></i> myMerit</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<#if principal??>
				<ul class="nav navbar-nav navbar-right">
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<i class="fa fa-user"></i> ${principal.firstname} ${principal.lastname} <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a>Logged in as <strong>${principal.username}</strong></a></li>
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
					<#if showsignup><li class="active"><a href="${contextroot}/sign-up"><i class="fa fa-user-plus"></i> Create account</a></li></#if>
					<#if showsignin><li><a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i> Sign in</a></li></#if>
				</ul>
			</#if>
		</div>
	</div>
</nav>

<#if showsignin && principal?? == false>
	<div class="modal fade" id="login-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="signin-form" action="${contextroot}/sign-in" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Sign in to myMerit</h4>
					</div>
					<div class="modal-body">
						<div class="well mrgn-bttm-0">
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
						<button id="signin-button" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</#if>