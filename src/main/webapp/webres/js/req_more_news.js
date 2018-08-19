$(document).ready( function(){
		var toserver = {};
		toserver["id"] = 0;
		toserver["id"] = req(toserver);
		$('#req_more').click(function(){toserver["id"] = req(toserver);});
});
	
function req(toserver) {
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "./make",
		data: JSON.stringify(toserver),
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			if (fromserver.length > 0) {
				var contentDiv;
				$.each(fromserver, function(key, value) {
					var mainDiv = $('#update_news');
					
					var contentDiv = $('<div>').addClass(
							'newsinner').appendTo(mainDiv);
					
					$('<span>')
						.addClass('news_hdr')
						.attr('nid', value.nid)
						.text(value.header)
						.appendTo(contentDiv);
					
					$('<span>')
					.addClass('clearme news_text')
					.text(value.text)
					.appendTo(contentDiv);
					
					$('<span>')
					.addClass('clearb news_date')
					.text(value.date)
					.appendTo(contentDiv);
				});
				
				$('html, body').animate({
					scrollTop : $('#req_more').offset().top
				}, 1000);
				
				return toserver["id"] = fromserver[fromserver.length - 1].nid;
			} else {
				$('#req_more').addClass('disable-elem');
				
				$('#req_more').text("No news left");
			}
		},
		error : function(e) {
			console.log(e);
		}
	});
}