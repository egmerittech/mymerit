<#import "/spring.ftl" as spring/>
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

		<title>Sign In</title>

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
				integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
				integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	</head>

	<body>
		<div class="container">
			<form method="post" class="form-signin">
				<h2 class="form-signin-heading">Please sign in</h2>
	
				<label for="email" class="sr-only">Email Address</label>
				<input type="email" id="email" name="email" class="form-control" placeholder="Email Address" required autofocus>
				
				<label for="password" class="sr-only">Password</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				
				<div class="checkbox">
					<label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
				</div>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>
	</body>
</html>
