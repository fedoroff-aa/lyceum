<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
			margin: 2em 0;
			padding: 2em;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			background-color: white;
		}
		input[value="Log out"] {
			width: 100%;
			border: 0;
			padding: 0.25em 1em;
			font-size: 4em;
			font-weight: 800;
			background-color: rgb(240,60,0);
			color: white;
			margin: auto 0;
		}
		a, p {
			font-weight: 800;
			margin: auto 0;
			font-size: 3.5em;
			color: rgb(0, 0, 200);
			text-decoration: none; 
		} 
		@media screen and (max-width: 570px){ a,p{font-size: 2em;} input[value="Log out"] {font-size:3em;padding: 0.1em 0.5em;}}
		p { 
			align-self: flex-start;
			color: rgb(240,60,0);
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<div class="inner">
			<form method="post" action="mpanel">
				<input type="hidden" name="logout" value="1">
				<input type="submit" value="Log out">
			</form>
			<p>Новости</p>
			<a href="/add_news">Добавить новость</a>
			<a href="/update_news">Изменить новость</a>
			<a href="/remove_news">Удалить новость</a>
			<p>Статьи</p>
			<a href="/add_article">Добавить статью</a>
			<a href="/update_article">Изменить статью</a>
			<a href="/remove_article">Удалить статью</a>
			<p>Панель навигации</p>
			<a href="/add_mitem">Добавить пункт</a>
			<a href="/update_mitem">Изменить пункт</a>
			<a href="/remove_mitem">Удалить пункт</a>
		</div>
	</div>
</body>
</html>