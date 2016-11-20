<#import "/simplex/template.ftlh" as simplex/>
<#global contextroot>${rc.contextPath}</#global>
<#macro render windowtitle="" pagetitle="" pagesubtitle="" additionalstylesheets="" additionalscripts="">
	<@simplex.render windowtitle=windowtitle pagetitle=pagetitle pagesubtitle=pagesibtitle additionalstylesheets=additionalstylesheets additionalscripts=additionalscripts>
		<#nested/>
	</@simplex.render>
</#macro>
