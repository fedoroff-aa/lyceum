<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Don't forget to insert</title>
<link rel="stylesheet" href="./webres/css/article.css" type="text/css" />

<link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu+Condensed" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Domine" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Merienda" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Molengo" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Baloo" rel="stylesheet">


<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
	
<script type="text/javascript" src="./webres/js/main_onany.js"></script>
<script type="text/javascript" src="./webres/js/article.js"></script>

<link href="https://fonts.googleapis.com/css?family=Exo+2"
	rel="stylesheet" />
</head>
<body>
	<div id="logo-top" class="logo_top">
		<div id="logo_common">
			<div id="header_text">Инфо-система Школы 1502 при МЭИ</div>	
			<div id="logo_img_mmid">
				<img alt="" src="./webres/img/logo.jpg" id="logo" />
			</div>
		</div>
	</div>
	
	<div class="menu_bar_toggle">
		<div id="logo_img"><img alt="" src="./webres/img/logo.jpg" id="logo" /></div>
		<div class="container_toggle">
			<span id="f_stripe" class="stripe"></span>
			<span id="s_stripe" class="stripe"></span>
			<span id="t_stripe" class="stripe"></span>
		</div>
	</div>
	
	<div id="container-top" class="top-container menu_hide" align="center">
		<div class="top-item" id="main_p">
			<div class="top-item-in" id="tomain">Главная</div>
			<div class="top-item-in" onclick="location.href = '/'" id="tomainh">Главная</div>
			<div class="menu_hide">
				<div class="top-item_in" onclick="location.href = '/'">Новости</div>
				<div class="top-item_in" onclick="location.href = '/#mobile_contacts'">Контакты</div>
			</div>
		</div>

		<div class="top-item" id="educ_p">
			<div class="top-item-in">Учебный процесс</div>
			<div class="menu_hide menu_bar" mid="2">
			</div>
		</div>

		<div class="top-item" id="extra_a">
			<div class="top-item-in">Внеурочная деятельность</div>
			<div class="menu_hide menu_bar" mid="3">
			</div>
		</div>

		<div class="top-item" id="for_ent">
			<div class="top-item-in">Поступающим</div>
			<div class="menu_hide menu_bar" mid="4">
			</div>
		</div>
		<div class="toggle-to-top" id="ttt_mb">
			<div class="toggle-inner">
				<span class="marker-left"></span>
				<span class="marker-right"></span>
				<span class="marker-center"></span>
			</div>
		</div>
	</div>
	<div class="wrapper" id="wrap" align="center">
		
		<div id="mobile_contacts">
			<div id="contacts_outer">
				<div id="contacts_common">
					<div class="contacts">
						<div id="contacts_inner">
							<div>Наши контакты</div>
							<div class="text_s" id="main_email">E-mail: <a class="link_">1502@edu.mos.ru</a></div>
							<div class="text_s"><a class="link_">Public</a> in VK<br></div>
							Директор
							<p class="text_s">Чудов Владимир Львович</p>
							<a class="link_" href="">ChudovVL@edu.mos.ru</a><br>
							<a class="link_" href="">+7 (495) 300-00-20</a><br>
							<a class="link_" href="">+7 (965) 340-77-16</a><br>
							Секретарь
							<p class="text_s">Кулагина Нина Валентиновна</p>
							<div><a class="link_ text_s" href="">+7(495)307-11-61</a></div>
							Адрес
							<p class="text_s">Москва, улица Молостовых, дом 10А</p>
						</div>
					</div>
	
					<div class="map">
						<script type="text/javascript" charset="utf-8" async
							src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A54d396fb123eb8bbc8ac34256e4bd182958109a68f5e7509c19ca52c57ff12d9&amp;width=320&amp;height=400&amp;lang=ru_RU&amp;scroll=true"></script>
					</div>
				</div>
			</div>
		</div>
		
		<div class="wrap-blocks news-container">
			<div id="update_news">
				<div class="newsinner"></div>
			</div>
		</div>
	</div>
	<div class="toggle-to-top" id="ttt_small">
			<div class="toggle-inner">
				<span class="marker-left"></span>
				<span class="marker-right"></span>
				<span class="marker-center"></span>
			</div>
	</div>
	<form action="article" method="post" id="article_f" style="display:none;">
		<input type="submit">
	</form>
</body>
</html>