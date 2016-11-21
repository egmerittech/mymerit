<div class="modal fade" id="signup-modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<form name="user" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Sign up to myMerit</h4>
				</div>
				
				<div class="modal-body">
					<div id="signin-form-error-alert"></div>
						<div class="well">
							<@bootstrap.formInput path="user.username"
									label="${rc.getMessage('signup.username.label')}"
									placeholder="${rc.getMessage('signup.username.placeholder')}"
									attributes="required"/>
							
							<@bootstrap.formPasswordInput path="user.password"
									label="${rc.getMessage('signup.password.label')}"
									placeholder="${rc.getMessage('signup.password.placeholder')}"
									attributes="required"/>
			
							<@bootstrap.formPasswordInput path="user.passwordMatch"
									label="${rc.getMessage('signup.passwordMatch.label')}"
									placeholder="${rc.getMessage('signup.passwordMatch.placeholder')}"
									attributes="required"/>

							<p>
								By clicking on "Sign up for myMerit" below, you are agreeing to the <a href="#">Terms of Service</a>
								and the <a href="#">Privacy Policy</a>.
							</p>
				
							<hr/>
				
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-lg btn-success btn-block" type="submit"><@spring.message "signup.submit"/></button>
				</div>
			</form>
		</div>
	</div>
</div>
