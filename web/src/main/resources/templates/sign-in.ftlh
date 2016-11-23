<#import "/macros/template.ftlh" as template/>
<#assign contextRoot>${rc.contextPath}</#assign>

<#assign pageScripts>
	<script>
		$("#signin-form").submit(function(event) {
			$("#mymerit-button-logo").removeClass("fa-trophy");
			$("#mymerit-button-logo").addClass("fa-refresh fa-spin");
		});	
	</script>
</#assign>

<@template.render pagetitle="Sign in to myMerit" showsignin=false pageScripts=pageScripts>
	<div class="well">
		<form id="signin-form" action="${contextRoot}/sign-in" method="post">
			<fieldset>
				<legend>Sign in</legend>
				
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

				<hr/>
				
				<button id="signin-button" class="btn btn-lg btn-primary btn-block" type="submit">Sign in to <i id="mymerit-button-logo" class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</button>
			</fieldset>
		</form>
	</div>
</@template.render>