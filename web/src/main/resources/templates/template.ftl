<#import "/spring.ftl" as spring/>
<#assign contextroot><@spring.url ''/></#assign>
<#macro render title>
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
	
			<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.3.7/simplex/bootstrap.min.css"
					integrity="sha384-C0X5qw1DlkeV0RDunhmi4cUBUkPDTvUqzElcNWm1NI2T4k8tKMZ+wRPQOhZfSJ9N" crossorigin="anonymous">
		</head>
	
		<body>
			<div class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a href="../" class="navbar-brand">myMerit</a>
						<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					
					<div class="navbar-collapse collapse" id="navbar-main">
						<ul class="nav navbar-nav">
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Themes <span class="caret"></span></a>
								<ul class="dropdown-menu" aria-labelledby="themes">
									<li><a href="../default/">Default</a></li>
									<li class="divider"></li>
									<li><a href="../cerulean/">Cerulean</a></li>
								</ul>
							</li>
							<li>
								<a href="../help/">Help</a>
							</li>
							<li>
								<a href="http://news.bootswatch.com">Blog</a>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="download">Simplex <span class="caret"></span></a>
								<ul class="dropdown-menu" aria-labelledby="download">
									<li><a href="http://jsfiddle.net/bootswatch/3he50zsf/">Open Sandbox</a></li>
									<li class="divider"></li>
									<li><a href="./bootstrap.min.css">bootstrap.min.css</a></li>
									<li><a href="./bootstrap.css">bootstrap.css</a></li>
									<li class="divider"></li>
									<li><a href="./variables.less">variables.less</a></li>
									<li><a href="./bootswatch.less">bootswatch.less</a></li>
									<li class="divider"></li>
									<li><a href="./_variables.scss">_variables.scss</a></li>
									<li><a href="./_bootswatch.scss">_bootswatch.scss</a></li>
								</ul>
							</li>
						</ul>
	
						<ul class="nav navbar-nav navbar-right">
							<li><a href="http://builtwithbootstrap.com/" target="_blank">Built With Bootstrap</a></li>
							<li><a href="https://wrapbootstrap.com/?ref=bsw" target="_blank">WrapBootstrap</a></li>
						</ul>
	
					</div>
				</div>
			</div>
			
			<div class="container">
				<div class="page-header" id="banner">
					<div class="row">
						<div class="col-lg-12">
							<h1>Sign up</h1>
							<p class="lead">You must have a myMerit account in order to use this service. Please sign up using the form below.</p>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-12">
						<#nested/>
					</div>
				</div>
			</div>
			
			<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
					integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
			<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
					integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		</body>
	</html>
</#macro>