<nav class="navbar navbar-default navbar-fixed-top" id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<i class="fa fa-bars fa-fw" aria-hidden="true"></i> Menu
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="${contextroot}"><i class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<#if principal??>
					<li title="No notifications" data-toggle="tooltip" data-placement="bottom">
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-bell-slash fa-fw" aria-hidden="true"></i> Notifications <i class="fa fa-caret-down fa-fw"></i>
						</a>
					</li>
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<i class="fa fa-user fa-fw" aria-hidden="true"></i> ${principal.firstname!} ${principal.lastname!} <i class="fa fa-caret-down fa-fw"></i>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-header">Signed in as <strong>${principal.username}</strong></li>
							<li class="divider"/>
							<li><a href="${contextroot}/auth/profile"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i> Edit your profile</a></li>
							<li><a href="${contextroot}/help"><i class="fa fa-question fa-fw" aria-hidden="true"></i> Help</a></li>
							<li class="divider" aria-hidden="true"/>
							<li><a href="${contextroot}/help"><i class="fa fa-cog fa-fw" aria-hidden="true"></i> Settings</a></li>
							<li><a href="${contextroot}/sign-out"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Sign out</a></li>
						</ul>
					</li>
				</#if>
				<#if showsignup && (principal?? == false)><li><a href="${contextroot}/sign-up"><i class="fa fa-user-plus fa-fw" aria-hidden="true"></i> Create account</a></li></#if>
				<#if showsignin && (principal?? == false)><li><a href="#" data-toggle="modal" data-target="#signin-modal"><i class="fa fa-sign-in fa-fw" aria-hidden="true"></i> Sign in</a></li></#if>
			</ul>
		</div>
	</div>
</nav>

<#if showsignin && (principal?? == false)>
	<#include "../modals/signin-modal.ftlh"/>
	
	<#assign scripts>
		${scripts}
		
		<script>
			function ajaxlogin(url) {
				$.ajax({
					method : "POST",
					dataType : "json",
					url : url,
					data : $("#signin-form-ajax").serialize(),
					success : function (response) {
						$("#login-modal").modal("hide");
						$(location).attr("href", response["successUrl"]);
					},
					error : function (response) {
						$("#signin-form-error-alert").html(
							$("<div>").addClass("alert alert-danger alert-dismissible fade in").html([
								$("<button>").addClass("close").attr("data-dismiss", "alert").attr("aria-hidden", "true").attr("type", "button").html("&times;"),
								$("<p>").text(response.responseJSON["errorMsg"])
							])
						);
					}
				});
			}	
		
			$("#signin-form-ajax").submit(function(event) {
				event.preventDefault();
				ajaxlogin("${contextroot}/sign-in?ajax");
			});
		</script>
	</#assign>
</#if>

<#-- 
<#if showsignup && (principal?? == false)>
	<#include "../modals/signup-modal.ftlh"/>

	<#assign scripts>
		${scripts}
	</#assign>
</#if>
-->