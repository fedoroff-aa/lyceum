$(document).ready(function() {
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "menu_items",
		dataType: 'json',
		timeout: 600000,
		success: function(fromserver) {
			$.each(fromserver, function(key,value){
				parent_dmenu = $('.menu_bar[mid="'+value.mid+'"]');
				var el = $('<div>')
					.text(value.content)
					.addClass('top-item_in')
					.attr('sid',value.sid)
					.appendTo(parent_dmenu);
				el.click(function(){
					$('#sid_f').val(el.attr('sid'));
					$('#mid_f').val(value.mid);
					$('#article_f').submit();
				});
			});
		},
		error : function(e) {
			console.log(e);
		}
	});
	
	$cont_top = $('#container-top');
	$cont_wrapper = $('#contacts_outer');
	$logo_top = $('#logo-top');
	
	$(window).scroll(top_menu_fix);
	$(window).resize(top_menu_fix);
	$(window).resize(hide_menu);
	top_menu_fix();
	/* to fix menu bar at top */
	function top_menu_fix(){
		if (from_top_to_logo_le0() && !isMidScreen() && !isSmallScreen()){
			$('.toggle-to-top').css({'height':'','display':'flex'});
			$('.top-item').css({'width' : 'calc(12/48*100% - 15px)'});
			$('#for_ent').css({'border-right' : '2px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : 35+$('#container-top').height()});
			$cont_top.css({'position' : 'fixed','top' : '0', 'display' : ''});
			
		} else if (!from_top_to_logo_le0() && !isMidScreen() && !isSmallScreen()) {
			$('.toggle-to-top').css({'display':'none'});
			$('.top-item').css({'width' : 'calc(12/48*100%)'});
			$('#for_ent').css({'border-right' : '0px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : '35px'});
			$cont_top.css({'position' : 'relative','top' : '0', 'display' : ''});
		} else if (isMidScreen()) {
			$('.toggle-to-top').css({'height':'60px','display':'block'});
			$('.top-item').css({'width' : 'calc(12/48*100%)'});
			$('#for_ent').css({'border-right' : '0px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : '35px'});
			$cont_top.css({'position' : 'relative','top' : '0'});
		} else if (isSmallScreen()){
			$('.toggle-to-top').css({'height':'40px','display':'block'});
			$('.top-item').css({'width' : ''});
			$('#wrap').css({'margin-top' : '35px'});
			$cont_top.css({});
		}
	}
	
	function hide_menu(){
		$('.menu_hide').removeClass('menu_in');
	}
	/* check if it's time to hold menu bar fixed at top 
	 * l - lower
	   e - equal */
	function from_top_to_logo_le0(){
		return $logo_top.height()-$(window).scrollTop() <= 0;
	}
	/* h - hover 
	 * common for buttons in menu bar to show drop-down menu*/
	function elem_h(el) {
		$('.menu_hide').not($(el).find('.menu_hide')).removeClass('menu_in');
		$($(el).find('.menu_hide')).toggleClass('menu_in');
	}
	function menu_bar_toggle() {
		$('#f_stripe').toggleClass('f_stripe');
		$('#s_stripe').toggleClass('s_stripe');
		$('#t_stripe').toggleClass('t_stripe');
		if (!$('#t_stripe').hasClass('t_stripe')) {
			$('#container-top').slideUp(500);
			$('#container-top').addClass('menu_hide');
			
			$('#f_stripe').addClass('f_stripe_back');
			$('#t_stripe').addClass('t_stripe_back'); 
		} 
		else {
			$('#container-top').removeClass('menu_hide');
			$('#container-top').slideDown(500);

			$('#f_stripe').removeClass('f_stripe_back');
			$('#t_stripe').removeClass('t_stripe_back'); 
		}
	}

	/* to check if screen width more than 950px (like if 'desktop') */
	function isMidScreen(){
		return window.matchMedia('(max-width: 950px) and (min-width: 550px)').matches;
	}
	function isSmallScreen(){
		return window.matchMedia('(max-width: 549px)').matches;
	}
	/* to check if some elem is hovered */
	function ishovered(ele){
		return $(ele).is(":hover");
	}
	
	function scroll_to_top(){
		$('html, body').animate({
			scrollTop : 0
		}, 800);
		if (!isSmallScreen() && !isMidScreen())$('#container-top').slideUp(700).slideDown(150);
	}
	
	/* menu bar with img and toggle */
	$('.container_toggle').click(function(){
		if (isSmallScreen()) menu_bar_toggle();
	});
	
	/* onclick for buttons in menu bar
	 * for screens less, than 950px */
	$('#main_p').click(function() {
		if (isMidScreen() || isSmallScreen()) elem_h("#main_p");
	});
	$('#educ_p').click(function() {			
		if (isMidScreen() || isSmallScreen()) elem_h("#educ_p");
	});
	$('#extra_a').click(function() {		
		if (isMidScreen() || isSmallScreen()) elem_h("#extra_a");
	});
	$('#for_ent').click(function() {		
		if (isMidScreen() || isSmallScreen()) elem_h("#for_ent");
	});

	/* onhover for buttons in menu bar */
	$('#educ_p').hover(function() {			
		if (!isMidScreen() && !isSmallScreen()){ elem_h("#educ_p");}
	});
	$('#extra_a').hover(function() {		
		if (!isMidScreen() && !isSmallScreen()){ elem_h("#extra_a");}
	});
	$('#for_ent').hover(function() {	
		if (!isMidScreen() && !isSmallScreen()) elem_h("#for_ent");
	});
	/* onclick for toggle to top */
	$('.toggle-to-top').click(function (){
		console.log(isMidScreen());
		if ($(document).scrollTop() > $cont_top.height() + $logo_top.height()){scroll_to_top();} 
		else if ($(document).scrollTop() > $cont_top.height() && !isMidScreen() && !isSmallScreen()){scroll_to_top();}
	});
});