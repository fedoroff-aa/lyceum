$(document).ready(function() {	
	$(".button_askforla").click(function(){
		toserver = {};
		toserver["mid"] = $('.select_mitem').val();
		toserver["content"] = $('#pagecontents').val();
		toserver_full = {mi:toserver, istorm:"0"};
		console.log(toserver_full);
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : "aur_mitem",
			dataType : 'json',
			data : JSON.stringify(toserver_full),
			timeout : 600000,
			success : function(fromserver) {
				console.log(fromserver);
			},
			error : function(e) {
				console.log(e);
			}
		});
	});
});