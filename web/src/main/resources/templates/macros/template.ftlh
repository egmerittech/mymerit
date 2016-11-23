<#import "/simplex/template.ftlh" as simplex/>
<#macro render windowtitle="" pagetitle="" pagesubtitle=""
		showsignin=true showsignup=true	pageMetadata="" pageStyles="" pageScripts="">

	<#assign contextRoot>${rc.contextPath}</#assign>
	
	<#local pageMetadata>
		${pageMetadata}
		<meta name="author" content="Greg Baker">
	</#local>
	<#local pageStyles>
		${pageStyles}
		<link rel="stylesheet" href="${contextRoot}/assets/css/mymerit.css">
	</#local>
	<#local pageScripts>
		${pageScripts}
		<script src="${contextRoot}/assets/js/mymerit.js"></script>
	</#local>
	
	<@simplex.render contextRoot=contextRoot
			windowTitle=windowtitle pageTitle=pagetitle pageSubtitle=pagesubtitle
			pageMetadata=pageMetadata pageStyles=pageStyles pageScripts=pageScripts
			showSignin=showsignin showSignup=showsignup
			alertMsg=alertMsg alertType=alertType>
		<#nested/>
	</@simplex.render>
</#macro>
