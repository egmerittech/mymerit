<#import "/spring.ftl" as spring/>
<#assign contextroot>${rc.contextPath}</#assign>

<#macro render windowtitle pagetitle pagesubtitle=""
		additionalmetadata="" additionalstylesheets=""
		additionalscripts="" showsignin=true showsignup=true>
	<#assign metadata = additionalmetadata/>
	<#assign stylesheets = additionalstylesheets/>
	<#assign scripts = additionalscripts/>
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<meta name="description" content="">
			<meta name="author" content="Greg Baker">
			
			<!-- additional metadata below -->
			${metadata}
			
			<title>${windowtitle}</title>

			<link rel="icon" href="${contextroot}/assets/favicon.ico">
			<link rel="stylesheet" href="${contextroot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/font-awesome.min.css">
			<link rel="stylesheet" href="${contextroot}/assets/css/mymerit.css">
			
			<!-- additional stylesheets below -->
			${stylesheets}
		</head>

		<body>
			<#include "def-navbar.ftlh"/>
			<#include "def-header.ftlh"/>
			<#include "def-alerts.ftlh"/>
			
			<div class="container">
				<main class="row">
					<#if principal??>				
						<div class="col-lg-9 col-md-9 col-sm-8">
							<#nested/>
						</div>
						<#include "def-sidebar.ftlh"/>
					<#else/>
						<div class="col-lg-12">
							<#nested/>
						</div>
					</#if>
				</main>
			</div>
			
			<#include "def-footer.ftlh"/>

			<script src="${contextroot}/assets/js/jquery.min.js"></script>
			<script src="${contextroot}/assets/js/bootstrap.min.js"></script>
			<script src="${contextroot}/assets/js/mymerit.js"></script>
			
			<script>$(document).ready(function() { $("[data-toggle=tooltip]").tooltip(); })</script>

			<!-- additional scripts below -->
			${scripts}
		</body>
	</html>
</#macro>
