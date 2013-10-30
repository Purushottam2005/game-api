$(document).ready(function() {
	editOrAddGameAjax();
});
var editOrAddGameAjax = function(){
	$("#content").find("#game").on("submit", function(event){
		event.preventDefault();
		var request = $.ajax({
				type:"post",
				url:$("#game").attr("action") +".inline",
				data:$("#game").serialize()
		});

		request.done(function(){
			console.log("success");
		})
		request.fail(function(){
			console.log("error");

		})
		request.always(function(data){
			console.log(data);
			$("body").find("#content").html(data);
			editOrAddGameAjax();
		});
	});
};