<#import "/spring.ftl" as spring/>
<#global contextroot>${rc.contextPath}</#global>
<#macro render pagetitle pagesubtitle="" windowtitle="">
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<meta name="description" content="">
			<meta name="author" content="Greg Baker">
			<link rel="icon" href="${contextroot}/assets/favicon.ico">

			<title>myMerit</title>

			<link rel="stylesheet" href="${contextroot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/mymerit.css">
		</head>

		<body>
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"/>
							<span class="icon-bar"/>
							<span class="icon-bar"/>
						</button>
						<a class="navbar-brand" href="#">myMerit</a>
					</div>
			
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
							<li><a href="#">Link</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"/></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"/>
									<li><a href="#">Separated link</a></li>
									<li class="divider"/>
									<li><a href="#">One more separated link</a></li>
								</ul>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">Help</a></li>
						</ul>
					</div>
				</div>
			</nav>
	
			<div class="container">
				<div class="page-header" id="banner">
					<div class="row">
						<div class="col-lg-12">
							<h1>${pagetitle}</h1>
							<#if pagesubtitle?has_content><p class="lead"><em>${pagesubtitle}</em></p></#if>
						</div>
					</div>
				</div>

				<#if dangerAlert??>
					<div class="row">
						<div class="col-lg-12">
							<div class="alert alert-dismissible alert-danger">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<@spring.message dangerAlert/>
							</div>
						</div>
					</div>
				</#if>
				
				<main class="row">
					<div class="col-lg-12">
						<#nested/>
					</div>
				</main>

				<footer>
					<div class="row">
						<div class="col-lg-12">
							<ul class="list-inline">
								<li><a href="#">Blog</a></li>
								<li><a href="#">RSS</a></li>
								<li><a href="#">Twitter</a></li>
								<li><a href="#">GitHub</a></li>
								<li><a href="#">Support</a></li>
							</ul>
							<p>Based on <a rel="nofollow" href="http://getbootstrap.com">Bootstrap</a>. Icons from <a rel="nofollow" href="http://fortawesome.github.io/Font-Awesome/">Font Awesome</a>. Web fonts from <a rel="nofollow" href="http://www.google.com/webfonts">Google</a>.</p>
						</div>
					</div>
				</footer>
			</div>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
			<script src="${contextroot}/assets/js/bootstrap.min.js"></script>
		</body>
	</html>
</#macro>