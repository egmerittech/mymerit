<#import "/spring.ftl" as spring/>
<#import "/macros/bootstrap.ftlh" as bootstrap/>
<#import "/macros/template.ftlh" as template/>
<@template.render pagetitle="Join myMerit">
	<div class="well">
		<form name="user" method="post">
			<fieldset>
				<legend>Create your personal account</legend>
				
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
				
				<button class="btn btn-lg btn-success btn-block" type="submit"><@spring.message "signup.submit"/></button>
			</fieldset>
		</form>
	</div>
</@template.render>