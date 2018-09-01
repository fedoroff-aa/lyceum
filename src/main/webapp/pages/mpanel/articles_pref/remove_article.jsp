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
	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>	
	
	<script type="text/javascript" src="../webres/js/articles_pref/remove_article.js"></script>
	<style type="text/css">
		body, html {
			width: 100%;
			margin: 0;
			padding: 0;
			background-color: #e6e6e6;
		}
		
		.wrapper {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			flex-direction: column;
		}
		
		
		.button_rm {
			width: 50%;
			height: auto;
			padding: 0.5em 0.5em;
			margin: 1em auto;
			background-color: rgb(240,60,0);
			color: white;
			text-align: center;
			font-family: sans-serif;
		}
		
		@media screen and (max-width: 349px){
		}
		
		@media screen and (min-width: 350px){ 
			.rmarticle {
				width: auto;
				font-size: 2.5em;
			}
		}
		
		@media screen and (min-width: 500px){ 
		}
		
		@media screen and (min-width: 750px){ 
			.rmarticle {
				font-size: 3.5em;
			}
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<select class="select_article js-example-responsive js-example-placeholder-single js-states form-control">
		</select>
		<div class="button_rm">Удалить статью</div>
	</div>
</body>
</html>