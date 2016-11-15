<#import "/template.ftl" as template/>
<#import "/macros.ftl" as macros/>
<@template.render title="Sign up...">
	<form method="post">
		<@macros.textInput path="signupBean.email" placeholderKey="signupBean.email.placeholder" hideLabel=true attributes="required autofocus"/>
		<@macros.textInput path="signupBean.password" placeholderKey="signupBean.password.placeholder" hideLabel=true attributes="required"/>
		
		<@macros.textInput path="signupBean.firstName" placeholderKey="signupBean.firstName.placeholder" hideLabel=true/>
		<@macros.textInput path="signupBean.lastName" placeholderKey="signupBean.lastName.placeholder" hideLabel=true/>

		<@macros.submitButton messageKey="signupBean.submit" class="btn btn-lg btn-success btn-block"/>
	</form>
</@template.render>