$(document).ready(function() {
	$("[data-toggle='tooltip']").tooltip();
});

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
					$("<button>").addClass("close").attr("data-dismiss", "alert").html("&times;"),
					$("<p>").text(response.responseJSON["errorMsg"])
				])
			);
		}
	});
}
