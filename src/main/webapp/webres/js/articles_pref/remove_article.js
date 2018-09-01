$(document).ready(function() {
	var gotfromserver;
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "menu_items",
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			var sel_article = $('.select_article');
			if (fromserver.length > 0){
				$.each(fromserver, function(key,value){
					$('<option/>')
						.text(value.content)
						.val(value.sid)
						.appendTo(sel_article);
				});
				$(".select_article").select2();
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
	
	$(".button_rm").click(function(){
		toserver = {};
		toserver["pagename"] = "article_"+$('.select_article').val()+".html";
		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : "rmarticle",
			dataType : 'json',
			data : JSON.stringify(toserver),
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