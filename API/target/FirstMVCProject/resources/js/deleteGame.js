$(document).ready(function() {
	deleteGameAjaxController();
});
var deleteGameAjaxController = function(){
	$("#deleteForm").on("submit", function(event){
		event.preventDefault();
		var request = $.ajax({
			type:"post",
			url:"addGame.inline",
			data:$("#deleteForm").serialize()
		});

		request.done(function(){
			console.log("success");
		})
		request.fail(function(){
			console.log("error");

		})
		request.always(function(data){
			$("body").find("#addGameContent").html(data);
			deleteGameAjaxController();
		});
	});
};