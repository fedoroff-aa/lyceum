$(document).ready(function() {
	
	$cont_top = $('#container-top');
	$cont_wrapper = $('#contacts_outer');
	$logo_top = $('#logo-top');
	
	$(window).scroll(top_menu_fix);
	$(window).resize(top_menu_fix);
	
	/* to fix menu bar at top */
	function top_menu_fix(){
		if (from_top_to_logo_le0() && !isSmallScreen()){
			$('.toggle-to-top').css({'height':'','display':'flex'});
			$('.top-item').css({'width' : 'calc(12/48*100% - 15px)'});
			$('#for_ent').css({'border-right' : '2px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : 35+$('#container-top').height()});
			$cont_top.css({'position' : 'fixed','top' : '0',});
			
		} else if (!from_top_to_logo_le0() && !isSmallScreen()) {
			$('.toggle-to-top').css({'display':'none'});
			$('.top-item').css({'width' : 'calc(12/48*100%)'});
			$('#for_ent').css({'border-right' : '0px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : '35px'});
			$cont_top.css({'position' : 'relative','top' : '0'});
		} else if (isSmallScreen()) {
			$('.toggle-to-top').css({'height':'60px','display':'block'});
			$('.top-item').css({'width' : 'calc(12/48*100%)'});
			$('#for_ent').css({'border-right' : '0px solid rgb(240, 60, 0)'});
			$('#wrap').css({'margin-top' : '35px'});
			$cont_top.css({'position' : 'relative','top' : '0'});
		}
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
		$('.menu_in_c').not($(el).find('.menu_in_c')).removeClass('menu_in');
		$($(el).find('.menu_in_c')).toggleClass('menu_in');
	}

	/* to check if screen width more than 950px (like if 'desktop') */
	function isSmallScreen(){
		return window.matchMedia('(max-width: 950px)').matches;
	}
	/* to check if some elem is hovered */
	function ishovered(ele){
		return $(ele).is(":hover");
	}
	
	function scroll_to_top(){
		$('html, body').animate({
			scrollTop : 0
		}, 800);
		if (!isSmallScreen())$('#container-top').slideUp(700).slideDown(150);
	}

	/* onclick for buttons in menu bar
	 * for screens more, than 950px */
	$('#main_p').click(function() {
		if (isSmallScreen()) elem_h("#main_p");
	});
	$('#educ_p').click(function() {			
		if (isSmallScreen()) elem_h("#educ_p");
	});
	$('#extra_a').click(function() {		
		if (isSmallScreen()) elem_h("#extra_a");
	});
	$('#for_ent').click(function() {		
		if (isSmallScreen()) elem_h("#for_ent");
	});

	/* onhover for buttons in menu bar */
	$('#educ_p').hover(function() {			
		if (!isSmallScreen()){ elem_h("#educ_p");}
	});
	$('#extra_a').hover(function() {		
		if (!isSmallScreen()){ elem_h("#extra_a");}
	});
	$('#for_ent').hover(function() {	
		if (!isSmallScreen()) elem_h("#for_ent");
	});
	/* onclick for toggle to top */
	$('.toggle-to-top').click(function (){
		if ($(document).scrollTop() > $cont_top.height() + $logo_top.height()){scroll_to_top();} 
		else if ($(document).scrollTop() > $cont_top.height() && !isSmallScreen()){scroll_to_top();}
	});
});
//cause global
function on_main_click(){
	alert("main");
}