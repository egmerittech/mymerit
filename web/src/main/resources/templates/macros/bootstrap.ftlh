<#import "/spring.ftl" as spring/>

<#macro formInput path label placeholder="" attributes="" fieldType="text">
	<@spring.bind path/>
	<#assign id = spring.status.expression?replace('[','')?replace(']','')/>
	<#assign error><#if spring.status.error>has-error</#if></#assign>
	<div class="form-group ${error}">
		<label class="control-label" for="${id}">${label}</label>
		<input class="form-control" type="${fieldType}" id="${id}"
				name="${spring.status.expression}" value="${spring.stringStatusValue}"
				<#if placeholder??>placeholder="${placeholder}"</#if> ${attributes}/>
		<#if error??><span class="help-block">${spring.status.errorMessage}</span></#if>
	</div>
</#macro>

<#macro formPasswordInput path label placeholder="" attributes="">
	<@formInput path label placeholder attributes "password"/>
</#macro>
