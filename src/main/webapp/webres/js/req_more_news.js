var stopqueries = false;
$(document).ready( function(){
		var toserver = {};
		toserver["id"] = 0;
		toserver["id"] = req(toserver);
		$('#req_more').click(function(){toserver["date"] = req(toserver);});
});
	
function req(toserver) {
	if (!stopqueries) {
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "news",
		data: JSON.stringify(toserver),
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			if (fromserver.length > 0) {
				var contentDiv;
				$.each(fromserver, function(key, value) {
					var mainDiv = $('#update_news');
					
					var contentDiv = $('<div>')
						.addClass('newsinner')
						.attr('nid', value.nid)
						.attr('date', value.date)
						.appendTo(mainDiv);
					
					$('<span>')
						.addClass('news_hdr')
						.attr('nid', value.nid)
						.text(value.header)
						.appendTo(contentDiv);
					
					var cont = $('<span>')
					.addClass('clearme news_text')
					.html(value.content)
					.appendTo(contentDiv);

					$('<span>')
					.addClass('clearb news_date')
					.text(value.date)
					.appendTo(contentDiv);
				});
				
				var lastdate = fromserver[fromserver.length - 1].date;
				
				$('html, body').animate({
					scrollTop : $(".newsinner[date='"+lastdate+"']").offset().top-50
				}, 500);
				console.log(lastdate);
				return toserver["date"] = lastdate;
			} else {
				$('#req_more').addClass('disable-elem');
				$('#req_more').text("No news left");
				stopqueries = true;
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
	}
}