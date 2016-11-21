<#import "/spring.ftl" as spring/>

<#macro render windowTitle="" pageTitle="" pageSubtitle=""
		pageMetadata="" pageStyles="" pageScripts=""
		showSignin=true showSignup=true
		contextRoot="" charset="utf-8"
		alertMsg="" alertType="">
		
	<#assign templateMetadata></#assign>
	<#assign templateStyles></#assign>
	<#assign templateScripts></#assign>
	
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="${charset}">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			${templateMetadata}
			${pageMetadata}
			
			<title>${windowTitle}</title>

			<link rel="icon" href="${contextRoot}/assets/favicon.ico">
			<link rel="stylesheet" href="${contextRoot}/assets/css/bootstrap.min.css">
			<link rel="stylesheet" href="${contextRoot}/assets/css/font-awesome.min.css">
			
			${templateStyles}
			${pageStyles}
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

			<script src="${contextRoot}/assets/js/jquery.min.js"></script>
			<script src="${contextRoot}/assets/js/bootstrap.min.js"></script>

			${templateScripts}
			${pageScripts}
			
			<script>$(document).ready(function() { $("[data-toggle=tooltip]").tooltip(); })</script>
		</body>
	</html>
</#macro>
