<#import "/template.ftl" as template/>
<#import "/macros.ftl" as macros/>
<@template.render title="Sign up...">
	<form method="post">
		<@macros.textInput path="signupBean.email" placeholderKey="signupBean.email.placeholder" hideLabel=true attributes="required autofocus"/>
		<@macros.textInput path="signupBean.password" placeholderKey="signupBean.password.placeholder" hideLabel=true attributes="required" type="password"/>
		<@macros.textInput path="signupBean.passwordMatch" placeholderKey="signupBean.passwordMatch.placeholder" hideLabel=true attributes="required" type="password"/>
		
		<@macros.submitButton messageKey="signupBean.submit" class="btn btn-lg btn-success btn-block"/>
	</form>
</@template.render>