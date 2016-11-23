<#import "/simplex/template.ftlh" as simplex/>

<#assign contextRoot>${rc.contextPath}</#assign>

<#assign metadata>
	<meta name="author" content="Greg Baker">
</#assign>

<#assign styles>
	<link rel="stylesheet" href="${contextRoot}/assets/css/mymerit.css">
</#assign>

<#assign scripts>
	<script src="${contextRoot}/assets/js/mymerit.js"></script>
</#assign>

<#macro render windowtitle="" pagetitle="" pagesubtitle="" pageMetadata="" pageStylesheets="" pageScripts="" showsignin=true showsignup=true>
	<@simplex.render contextRoot=contextRoot windowTitle=windowtitle pageTitle=pagetitle pageSubtitle=pagesubtitle
			pageMetadata=additionalmetadata pageStyles=additionalstylesheets pageScripts=pageScripts
			showSignin=showsignin showSignup=showsignup
			alertMsg=alertMsg alertType=alertType>
		<#nested/>
	</@simplex.render>
</#macro>
