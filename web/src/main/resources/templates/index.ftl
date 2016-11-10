<#import "/spring.ftl" as spring/>
<#import "/macros.ftl" as macros/>
<#assign contextroot><@spring.url ''/></#assign>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="${contextroot}/assets/favicon.ico">

		<title>myMerit</title>

		<link href="${contextroot}/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<link href="${contextroot}/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
		<link href="${contextroot}/assets/css/sign-in.css" rel="stylesheet">

		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<div class="container">
			<form method="post">
				<div class="row">
					<div class="col-md-6">
						<h1 class="form-signin-heading">
							<span>myMerit</span>
							<small class="help-block"><em>Making kids smarter</em></small>
						</h1>
					</div>
		
					<div class="col-md-6">
						<p>Sign up...</p>

						<@macros.textInput "command.email"/>

						<div class="form-group">
							<label for="email" class="sr-only">Email Address</label>
							<input type="email" id="email" name="email" class="form-control" placeholder="Your email address" required autofocus>
						</div>
						
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" id="password" name="password" class="form-control" placeholder="Create a password" required>
						</div>
						
						<div class="form-group">
							<label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
						</div>

						<button class="btn btn-lg btn-success btn-block" type="submit">Sign up for myMerit</button>
					</div>
					
				</div>
			</form>
		</div>
		<script src="${contextroot}/assets/js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>