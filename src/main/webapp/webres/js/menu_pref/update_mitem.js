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
						.attr('mid', value.mid)
						.appendTo(sel_article);
				});
				$(".select_article").select2();
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
	
	$(".button_get").click(function(){
		console.log($('.select_mitem').val() + " " + $('.select_mitem option:selected').text());
		$('#mitem_contents').val($('.select_mitem option:selected').text());
	});
	
	$(".button_update").click(function(){
		toserver = {};
		toserver["mid"] = $('.select_mitem option:selected').attr('mid');
		toserver["sid"] = $('.select_mitem').val();
		toserver["content"] = $('#mitem_contents').val();
		console.log(toserver);
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : "aur_mitem",
			dataType : 'json',
			data : JSON.stringify({mi:toserver, istorm:"0"}),
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