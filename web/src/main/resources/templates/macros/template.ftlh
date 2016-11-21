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

<#macro render windowtitle="" pagetitle="" pagesubtitle=""
		additionalmetadata=metadata additionalstylesheets=styles additionalscripts=scripts
		showsignin=true showsignup=true>
	<@simplex.render contextRoot=contextRoot windowTitle=windowtitle pageTitle=pagetitle pageSubtitle=pagesubtitle
			pageMetadata=additionalmetadata pageStyles=additionalstylesheets pageScripts=additionalscripts
			showSignin=showsignin showSignup=showsignup>
		<#nested/>
	</@simplex.render>
</#macro>
