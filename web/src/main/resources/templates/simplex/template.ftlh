<#import "/spring.ftl" as spring/>
<#assign contextroot>${rc.contextPath}</#assign>

<#macro render windowtitle pagetitle pagesubtitle=""
		additionalmetadata="" additionalstylesheets=""
		additionalscripts="" showsignin=true showsignup=true>
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<meta name="description" content="">
			<meta name="author" content="Greg Baker">
			
			<!-- additional metadata below -->
			${additionalmetadata}
			
			<title>${windowtitle}</title>

			<link rel="icon" href="${contextroot}/assets/favicon.ico">
			<link rel="stylesheet" href="${contextroot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/font-awesome.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/mymerit.css">
			
			<!-- additional stylesheets below -->
			${additionalstylesheets}
		</head>

		<body>
			<#include "def-navbar.ftlh"/>
			<#include "def-header.ftlh"/>
			<#include "def-alerts.ftlh"/>
			
			<div class="container">
				<main class="row">
					<#include "def-sidebar.ftlh"/>
					<div class="col-lg-9 col-md-9 col-sm-8">
						<#nested/>
					</div>
				</main>
			</div>
			
			<#include "def-footer.ftlh"/>

			<script src="${contextroot}/assets/js/jquery.min.js"></script>
			<script src="${contextroot}/assets/js/bootstrap.min.js"></script>
			<script src="${contextroot}/assets/js/mymerit.js"></script>

			<#if showsignin && principal?? == false>
				<script>
					$("#signin-form-ajax").submit(function(event) {
						event.preventDefault();
						ajaxlogin("${contextroot}/sign-in?ajax");
					});
				</script>
			</#if>
						
			<!-- additional scripts below -->
			${additionalscripts}
		</body>
	</html>
</#macro>
