$(document).ready(function(){
	if (Cookies.get("article_sid") > 0)
	$('.newsinner').load("../pages/articles/article_"+Cookies.get("article_sid")+".html");
	else {
		$('.newsinner').load("../pages/articles/article_1.html");
	}
});