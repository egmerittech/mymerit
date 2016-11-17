<#import "/template.ftl" as template/>
<@template.render pagetitle="Sign in to myMerit">

	<div class="col-lg-12">
		<#if error??>
			<div class="alert alert-danger">
				<strong>Invalid username or password!</strong>
			</div>		
		</#if>
	
		<div class="well">
			<form method="post">
				<fieldset>
					<legend>Sign in</legend>
					
					<div class="form-group ">
						<label for="email" class="control-label">Email Address</label>
						<input type="email" id="email" name="email" class="form-control" placeholder="Email Address" required>
					</div>
					
					<div class="form-group ">
						<label for="password" class="control-label">Password</label>
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
					</div>
					
					<div class="checkbox">
						<label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
					</div>

					<hr/>
					
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</fieldset>
			</form>
		</div>
	</div>
	
</@template.render>