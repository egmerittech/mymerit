<#import "/simplex/template.ftlh" as simplex/>
<#global contextroot>${rc.contextPath}</#global>
<#macro render windowtitle="" pagetitle="" pagesubtitle="" additionalstylesheets="" additionalscripts="" showsignin=true showsignup=true>
	<@simplex.render windowtitle=windowtitle pagetitle=pagetitle pagesubtitle=pagesibtitle additionalstylesheets=additionalstylesheets additionalscripts=additionalscripts showsignin=showsignin showsignup=showsignup>
		<#nested/>
	</@simplex.render>
</#macro>
