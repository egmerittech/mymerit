<#import "/spring.ftl" as spring/>
<#import "/template.ftl" as template/>
<@template.render pagetitle="Join myMerit" pagesubtitle="The best way to feel good about yourself.">

	<div class="row">
		<div class="col-lg-12">
			<div class="well">
				<form name="signupBean" method="post">
					<fieldset>
						<legend>Create your personal account</legend>
						
						<div class="form-group">
							<label class="control-label sr-only" for="email"><@spring.message "signupBean.email"/></label>
							<input class="form-control" id="email" name="email" type="text" placeholder="<@spring.message "signupBean.email.placeholder"/>" required>
						</div>
						<div class="form-group">
							<label class="control-label sr-only" for="password"><@spring.message "signupBean.password"/></label>
							<input class="form-control" id="password" name="password" type="password" placeholder="<@spring.message "signupBean.password.placeholder"/>" required>
						</div>

						<div class="form-group">
							<label class="control-label sr-only" for="passwordMatch"><@spring.message "signupBean.passwordMatch"/></label>
							<input class="form-control" id="passwordMatch" name="passwordMatch" type="password" placeholder="<@spring.message "signupBean.passwordMatch.placeholder"/>" required>
						</div>
						<p>By clicking on "Sign up for myMerit" below, you are agreeing to the <a href="#">Terms of Service</a> and the <a href="#">Privacy Policy</a>.</p>
						<hr/>
						<button class="btn btn-lg btn-success btn-block" type="submit"><@spring.message "signupBean.submit"/></button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	
</@template.render>