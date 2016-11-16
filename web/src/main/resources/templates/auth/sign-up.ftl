<#import "/template.ftl" as template/>
<#import "/macros.ftl" as macros/>
<@template.render pagetitle="Join myMerit" pagesubtitle="The best way to feel good about yourself.">

	<div class="row">
		<div class="col-lg-6">
			<div class="well">
				<form method="post">
					<fieldset>
						<legend>Create your personal account</legend>
						<@macros.textInput path="signupBean.email" placeholderKey="signupBean.email.placeholder" hideLabel=true attributes="required autofocus"/>
						<@macros.textInput path="signupBean.password" placeholderKey="signupBean.password.placeholder" hideLabel=true attributes="required" type="password"/>
						<@macros.textInput path="signupBean.passwordMatch" placeholderKey="signupBean.passwordMatch.placeholder" hideLabel=true attributes="required" type="password"/>
						<p>By clicking on "Sign up for myMerit" below, you are agreeing to the <a href="#">Terms of Service</a> and the <a href="#">Privacy Policy</a>.</p>
						<hr/>
						<@macros.submitButton messageKey="signupBean.submit" class="btn btn-lg btn-success btn-block"/>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	
</@template.render>