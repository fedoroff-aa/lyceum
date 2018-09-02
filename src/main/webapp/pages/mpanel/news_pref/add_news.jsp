<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.3.1.js"
		integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="../webres/js/news_pref/add_news.js"></script>
	<style type="text/css">
		
		body, html {
			height: 100%;
			width: 100%;
			margin: 0;
			padding: 0;
			background-color: #e6e6e6;
		}
		
		.wrapper {
			width: 100%;
			height: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.inner {
			display: flex;
			width: 80%;
			flex-direction: column;
			justify-content: center;
			align-items: center;	
		}
		
		#header {
			padding: 1em 0;
			font-size: 2em;
			width: 40%;
			min-width: 250px;
		}
		
		#content {
			width: 80%;
			height: 400px;
			font-size: 1.5em;
		}
		
		#date {
			padding: 0.5em 0;	
			min-width: 250px;
			font-size: 2em;
			width: 50%;
		}
		
		.button_add {
			padding: 2%;
			height: auto;
			background-color: rgb(240,60,0);
			color: white;
			text-align: center;
			font-family: sans-serif;
			font-size: 3.5em;
		}
		
		::-webkit-input-placeholder {
		   text-align: center;
		}
		
		:-moz-placeholder { /* Firefox 18- */
		   text-align: center;  
		}
		
		::-moz-placeholder {  /* Firefox 19+ */
		   text-align: center;  
		}
		
		:-ms-input-placeholder {  
		   text-align: center; 
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<div class="inner">
			<input type="text" id="header" placeholder="Заголовок новости"/><br>
			<textarea id="content" placeholder="Содержание новости"></textarea><br>
			<input type="text" id="date" placeholder="дд.мм.гггг чч:мм"/><br>
			<div class="button_add">Добавить новость</div>
		</div>
	</div>
</body>
</html>