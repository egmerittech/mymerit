<#assign contextRoot>${rc.contextPath}</#assign>
<div class="modal-dialog">
	<div class="modal-content">
		<form id="signin-form-ajax" action="${contextRoot}/sign-in?ajax" method="post">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Sign in to myMerit</h4>
			</div>
			<div class="modal-body">
				<div id="signin-form-error-alert" class="alert alert-danger collapse">
					<span id="signin-form-error-alert-message"></span>
				</div>
				<div class="well">
					<div class="form-group ">
						<label for="username" class="control-label">Email Address</label>
						<input type="email" id="username" name="username" class="form-control" placeholder="Email Address" required>
					</div>

					<div class="form-group ">
						<label for="password" class="control-label">Password</label>
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
					</div>

					<div class="checkbox">
						<label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="signin-button" class="btn btn-lg btn-primary btn-block" type="submit">Sign in to <i id="mymerit-button-logo" class="fa fa-trophy fa-fw" aria-hidden="true"></i> myMerit</button>
			</div>
		</form>
	</div>
</div>

<script>
	$("#signin-form-ajax").submit(function(event) {
		event.preventDefault();
		$("#mymerit-button-logo").removeClass("fa-trophy");
		$("#mymerit-button-logo").addClass("fa-refresh fa-spin");
		$("#signin-form-error-alert").slideUp();
		$.ajax({
			method: $("#signin-form-ajax").attr("method"),
			url: $("#signin-form-ajax").attr("action"),
			data: $("#signin-form-ajax").serialize(),
			success: function (response) {
				$("#login-modal").modal("hide");
				$(location).attr("href", response["successUrl"]);
			},
			error: function (response) {
				$("#mymerit-button-logo").removeClass("fa-refresh fa-spin");
				$("#mymerit-button-logo").addClass("fa-trophy");
				$("#signin-form-error-alert-message").html(response.responseJSON["errorMsg"])
				$("#signin-form-error-alert").slideDown();
			}
		});
	});
</script>