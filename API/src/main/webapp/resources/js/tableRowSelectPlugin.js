(function($){
	$.fn.tableRowClickable = function(){
		this.on("click", function(){
			$(this).closest("tr").find(".table-anchor")[0].click();
		});
		$(".delete-form").on("mouseenter", function(){
			$(this).closest("tr").children("td").toggleClass("normal");
			$(this).closest("tr").find(".table-anchor").toggleClass("normal");
		});
		$(".delete-form").on("mouseleave", function(){
			$(this).closest("tr").children("td").toggleClass("normal");
			$(this).closest("tr").find(".table-anchor").toggleClass("normal");
		});
		return this;
	};
}(jQuery));