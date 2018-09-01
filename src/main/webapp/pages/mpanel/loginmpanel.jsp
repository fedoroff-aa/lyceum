<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.wrapper {
			width: 100%;
			height: 100%;
			display: flex;
			justify-content: center;
		}
		html, body {
			width: 100%;
			height: 100%;
			margin: 0;
			padding: 0;
			background-color: #e6e6e6;
		}
		#inner { 
			display: flex;
			flex-direction: column;
			align-self: center;
		}
		#name, #pass {
			width: 100%;
			font-size: 3em;
			margin-bottom: 30px;
		}
		
		button {
			background-color: rgb(240,60,0);
			width: calc(24/48*100%);
			color: white;
			font-size: 3em;
			border: 0;
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<div id="inner">
			<spring:form method="post"  modelAttribute="user" action="mpanel">
				<spring:input path="name" id="name" placeholder="Username"/><br/>
			  	<spring:input path="password" id="pass" placeholder="Password" type="password"/><br/>
			  	<spring:button id="login_b">Log in</spring:button>
			</spring:form>  
		</div>
	</div>	
</body>
</html>