<#import "/macros.ftl" as macros/>
<#import "/spring.ftl" as spring/>
<#assign contextroot><@spring.url ''/></#assign>
<#macro render pagetitle pagesubtitle="" windowtitle="">
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

			<link rel="stylesheet" href="${contextroot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/mymerit.css">
		</head>

		<body>
			<div class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a href="${contextroot}" class="navbar-brand">myMerit</a>
						<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>

					<div class="navbar-collapse collapse" id="navbar-main">

						<ul class="nav navbar-nav navbar-right">
							<li>
								<ul class="nav navbar-nav">
									<li class="dropdown">
										<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Services <span class="caret"></span></a>
										<ul class="dropdown-menu" aria-labelledby="themes">
											<li><a href="#">Service A</a></li>
											<li class="divider"></li>
											<li><a href="#">Service B</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a href="#">Help</a></li>
						</ul>

					</div>
				</div>
			</div>

			<div class="container">
				<div class="page-header row" id="banner">
						<div class="col-lg-12">
							<h1>${pagetitle}</h1>
							<#if pagesubtitle?has_content><p class="lead">${pagesubtitle}</p></#if>
						</div>
				</div>

				<main>
					<#nested/>
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