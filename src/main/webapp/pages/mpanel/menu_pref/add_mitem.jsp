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
	
	<script type="text/javascript" src="../webres/js/menu_pref/add_mitem.js"></script>
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
		
		.select_mitem {
			width: 60%;
		}
		
		
		.button_askforla {
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
			.button_askforla {
				font-size: 1.5em;
			}
		}
		
		@media screen and (min-width: 350px){ 
			.button_askforla {
				width: auto;
				font-size: 2.5em;
			}
		}
		
		@media screen and (min-width: 500px){ 
		}
		
		@media screen and (min-width: 750px){ 
			.button_askforla {
				font-size: 3.5em;
			}
		}
		
		@media screen and (min-width: 1000px){ 
		}
		.form_to_upd {
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;	
		}	
		#pagecontents {
			width: 80%;
			margin: 5em 0;
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<select class="select_mitem js-example-responsive">
			<option value="2">Учебный процесс</option>
			<option value="3">Внеурочная деятельность</option>
			<option value="4">Поступающим</option>
		</select>
		<textarea rows="2" id="pagecontents"></textarea>
		<div class="button_askforla">Добавить пункт</div>
	</div>
</body>
</html>