<#import "/bootstrap.ftl" as bootstrap/>
<#import "/spring.ftl" as spring/>
<#import "/template.ftl" as template/>
<@template.render pagetitle="Join myMerit" pagesubtitle="The best way to feel good about yourself.">

	<div class="col-lg-12">
		<div class="well">
			<form name="signupBean" method="post">
				<fieldset>
					<legend>Create your personal account</legend>
					
					<@bootstrap.formInput path="signupBean.email"
							label="${rc.getMessage('signupBean.email.label')}"
							placeholder="${rc.getMessage('signupBean.email.placeholder')}"
							attributes="required"/>
					
					<@bootstrap.formPasswordInput path="signupBean.password"
							label="${rc.getMessage('signupBean.password.label')}"
							placeholder="${rc.getMessage('signupBean.password.placeholder')}"
							attributes="required"/>

					<@bootstrap.formPasswordInput path="signupBean.passwordMatch"
							label="${rc.getMessage('signupBean.passwordMatch.label')}"
							placeholder="${rc.getMessage('signupBean.passwordMatch.placeholder')}"
							attributes="required"/>

					<p>
						By clicking on "Sign up for myMerit" below, you are agreeing to the <a href="#">Terms of Service</a>
						and the <a href="#">Privacy Policy</a>.
					</p>
					
					<hr/>
					
					<button class="btn btn-lg btn-success btn-block" type="submit"><@spring.message "signupBean.submit"/></button>
				</fieldset>
			</form>
		</div>
	</div>
	
</@template.render>