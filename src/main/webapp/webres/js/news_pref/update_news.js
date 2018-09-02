$(document).ready(function(){
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
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
	$('.button_askforln').click(function(){
		var toserver = {};
		toserver["id"] = $('.select_article').val();
		
		console.log(toserver);
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "mpanel_getnf", //get specific article by id
			data: JSON.stringify(toserver),
			dataType: 'json',
			timeout: 600000,
			success: function(fromserver) {
				$('.form_to_upd').slideDown(300);
				$('.form_to_upd').attr('nid', fromserver.nid);
				$('#header').val(fromserver.header);
				$('#content').val(fromserver.content);
				$('#date').val(fromserver.date);
			},
			error : function(e) {
				console.log(e);
			}
		});
	});

	$('.button_upd').click(function(){
		var toserver_upd = {};
		toserver_full = {};
		
		toserver_upd["nid"] = $('.form_to_upd').attr('nid');
		toserver_upd["header"] = $('#header').val();
		toserver_upd["content"] = $('#content').val();
		toserver_upd["date"] = $('#date').val();
		
		toserver_full = {n:toserver_upd, istorm:"0"};
		console.log(toserver_full);
		$.ajax({
			type: "POST",
			contentType: "application/json;charset=UTF-8",
			url: "mpanel_aur_news", //get list of articles
			data: JSON.stringify(toserver_full),
			dataType: 'json',
			timeout: 600000,
			success: function(fromserver) {
				$console.log(fromserver);
			},
			error : function(e) {
				console.log(e);
			}
		});	
		$('.form_to_upd').slideUp(300);
	});
});