<#assign contextroot>${rc.contextPath}</#assign>
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
