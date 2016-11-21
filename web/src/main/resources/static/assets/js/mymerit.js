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
			$("#signin-form-ajax #signin-msg").html(
				"<div class=\"alert alert-dismissible alert-danger\">" +
				"	<button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>" +
				"	<p>"+ response.responseJSON["errorMsg"] + "</p>" +
				"</div>"
			);
		}
	});
}
