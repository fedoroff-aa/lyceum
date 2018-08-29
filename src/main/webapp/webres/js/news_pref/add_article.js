$(document).ready(function(){
	$('.button_add').click(function(){
		toserver_full = {};
		news_add = {};
		
		news_add["header"] = $('#header').val();
		news_add["content"] = $('#content').val();
		news_add["date"] = $('#date').val();
		
		toserver_full = {news:news_add, istorm:"0"};
		console.log(toserver_full);
		$.ajax({
			type: "POST",
			contentType: "application/json;charset=utf-8",
			url: "mpanel_aur_news",
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