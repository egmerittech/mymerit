<#import "/spring.ftl" as spring/>

<#macro formInput path label placeholder="" attributes="" fieldType="text">
	<@spring.bind path/>
	<#assign id = spring.status.expression?replace('[','')?replace(']','')/>
	<#assign error><#if spring.status.errorMessages?has_content>has-error</#if></#assign>
	[hasErrors: ${spring.status.errors.hasErrors()?c}]
	[isError: ${spring.status.isError()?c}]
	<div class="form-group ${error}">
		<label class="control-label" for="${id}">${label}</label>
		<input class="form-control" type="${fieldType}" id="${id}" name="${spring.status.expression}"
				<#if fieldType != "password">value="${spring.stringStatusValue}"</#if>
				<#if placeholder != "">placeholder="${placeholder}"</#if> ${attributes}/>
	</div>
</#macro>

<#macro formPasswordInput path label placeholder="" attributes="">
	<@formInput path, label, placeholder, attributes, "password"/>
</#macro>
