<#import "/spring.ftl" as spring/>
<#assign contextroot>${rc.contextPath}</#assign>

<#macro render windowtitle pagetitle pagesubtitle="" additionalstylesheets="" additionalscripts="">
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<meta name="description" content="">
			<meta name="author" content="Greg Baker">
			<link rel="icon" href="${contextroot}/assets/favicon.ico">

			<title>${windowtitle}</title>

			<link rel="stylesheet" href="${contextroot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/mymerit.css">
			${additionalstylesheets}
		</head>

		<body>
			<#include "def-navbar.ftl"/>
			<#include "def-header.ftl"/>
			<#include "def-alerts.ftl"/>
			
			<div class="container">
				<main class="row">
					<div class="col-lg-12">
						<#nested/>
					</div>
				</main>
			</div>
			
			<#include "def-footer.ftl"/>

			<script src="${contextroot}/assets/js/jquery.min.js"></script>
			<script src="${contextroot}/assets/js/bootstrap.min.js"></script>
			<script src="${contextroot}/assets/js/mymerit.js"></script>
			${additionalscripts}
		</body>
	</html>
</#macro>
