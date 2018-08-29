$(document).ready(function(){
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "mpanel_getns", //get list of articles
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			var sel_article = $('.select_article');
			if (fromserver.length > 0){
				$.each(fromserver, function(key,value){
					$('<option/>')
						.val(value.nid)
						.text(value.header + " " + value.date)
						.appendTo(sel_article);
				});
				$(".js-example-responsive").select2();
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
	$('.button_rm').click(function(){		
		toserver_full = {};
		news_remove = {};
		
		news_remove["nid"] = $('.select_article').val();
		toserver_full = {news:news_remove, istorm:"1"};
		console.log(toserver_full);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "mpanel_aur_news", //get specific article by id
			data: JSON.stringify(toserver_full),
			dataType: 'json',
			timeout: 600000,
			success: function(fromserver) {
				console.log(fromserver);
			},
			error : function(e) {
				console.log(e);
			}
		});
	});
});