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
<script type="text/javascript" src="../webres/js/news_pref/remove_article.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>

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
		}
		.inner {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;	
		}
		
		.button_rm {
			padding: 2%;
			height: auto;
			margin: 1em 0;
			background-color: rgb(240,60,0);
			color: white;
			text-align: center;
			font-family: sans-serif;
			font-size: 3.5em;
		}
				
		
		.select_article, .element {
			width: 80%;
			padding: 2em 2em;
			font-size: 1.5em;
			margin-top: 1em;
		}
		
		@media screen and (min-width: 350px){ 
			.select_article {
				padding: 0.25em 0.25em;
				font-size: 1.7em;
			}
		}
		
		@media screen and (min-width: 500px){ 
			.select_article {
				padding: 0.25em 0.25em;
				font-size: 2em;
			}
		}
		
		@media screen and (min-width: 750px){ 
			.select_article {
				padding: 0.25em 0.25em;
				font-size: 3em;
			}
		}
		
		@media screen and (min-width: 1000px){ 
			.select_article {
				padding: 0.5em 0.5em;
				font-size: 4em;
			}
		}
	
	</style>
</head>
<body>
	<div class="wrapper">
		<div class="inner">
			<select class="select_article js-example-responsive">
			</select>
			<div class="button_rm">Удалить</div>
		</div>	
	</div>
</body>
</html>