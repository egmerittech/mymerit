<#macro render title>
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
	
			<title>${title}</title>
	
			<link rel="stylesheet" crossorigin="anonymous" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
					integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="/>
			
			<!--[if lt IE 9]>
				<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
				<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
			<![endif]-->
		</head>
		
		<body>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar">test</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a href="#" class="navbar-brand">myMerit</a>
					</div>
					
					<div id="navbar" class="navbar-collapse collapse">
						<div class="navbar-form navbar-right">
							<a href="#" class="btn btn-default">Sign In</a>
							<a href="#" class="btn btn-success">Sign Up</a>
						</div>
<#--
						<s:if test="%{#attr['user'] == 'anonymousUser'}">
							<div class="navbar-form navbar-right">
								<s:a action="login" cssClass="btn btn-success">Stub Login</s:a>
							</div>
						</s:if>
						<s:else>
							<form method="post" action="#" class="navbar-form navbar-right">
								<a href="#" class="btn btn-link">Greg</a>
								<s:hidden name="%{#attr._csrf.parameterName}" value="%{#attr._csrf.token}"/>
								<button type="submit" class="btn btn-success">Log out</button>
							</form>
						</s:else>
-->
					</div>
				</div>
			</nav>
			
			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<div class="container">
					<h1>${title}</h1>
					<#nested/>
				</div>
			</div>
			
			<div class="container">
				<!-- Example row of columns -->
				<div class="row">
					<div class="col-md-4">
						<h2>Unsecured Page</h2>
						<p>Click the button below to access an <strong>unsecured</strong> page.</p>
						<p><s:a namespace="/" action="index" cssClass="btn btn-default" role="button">Unsecured &raquo;</s:a></p>
					</div>
					<div class="col-md-4">
						<h2>Authenticated Page</h2>
						<p>Click the button below to access an <strong>authenticated</strong> page.</p>
						<p><s:a namespace="/auth" action="index" cssClass="btn btn-default" role="button">Authenticated &raquo;</s:a></p>
					</div>
					<div class="col-md-4">
						<h2>Admin Page</h2>
						<p>Click the button below to access an <strong>admin</strong> page.</p>
						<p><s:a namespace="/admin" action="index" cssClass="btn btn-default" role="button">Admin &raquo;</s:a></p>
					</div>
				</div>
			
				<hr>
			
				<footer>
					<p>&copy; Greg Baker 2015</p>
				</footer>
			</div>
	
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" crossorigin="anonymous"
					integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="></script>		
		</body>
	</html>
</#macro>