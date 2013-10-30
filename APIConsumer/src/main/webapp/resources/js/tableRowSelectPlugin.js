(function($){
	$.fn.tableRowClickable = function(){
		this.on("click", function(){
			$(this).closest("tr").find(".table-anchor")[0].click();
		})
		.find('.delete-form').on('click', function (e) {
			e.stopPropagation();
		});
		$(".delete-form").on("mouseenter", function(){
			$(this).closest("tr").children("td").addClass("normal");
			$(this).closest("tr").find(".table-anchor").addClass("normal");
		});
		$(".delete-form").on("mouseleave", function(){
			$(this).closest("tr").children("td").removeClass("normal");
			$(this).closest("tr").find(".table-anchor").removeClass("normal");
		});
		return this;
	};
}(jQuery));