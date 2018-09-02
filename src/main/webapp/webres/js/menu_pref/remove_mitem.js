$(document).ready(function() {
	var gotfromserver;
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "menu_items",
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			var sel_article = $('.select_mitem');
			if (fromserver.length > 0){
				$.each(fromserver, function(key,value){
					$('<option/>')
						.text(value.content)
						.val(value.sid)
						.appendTo(sel_article);
				});
				$(".select_mitem").select2();
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
	
	$(".button_rm").click(function(){
		toserver = {};
		toserver["sid"] = $('.select_mitem').val();
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : "aur_mitem",
			dataType : 'json',
			data : JSON.stringify({mi:toserver, istorm:"1"}),
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