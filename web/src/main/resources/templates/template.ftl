<#import "/simplex/template.ftl" as simplex/>
<#global contextroot>${rc.contextPath}</#global>
<#macro render pagetitle pagesubtitle="" windowtitle="myMerit">
	<@simplex.render pagetitle pagesubtitle windowtitle>
		<#nested/>
	</@simplex.render>
</#macro>
