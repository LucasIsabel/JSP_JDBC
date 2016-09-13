
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Home </title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
	
	<style>
	.container-box {
		height: 300px;
		width: 740px;
		margin-left: auto;
		margin-right: auto;
		padding: 20px;
	}
	
	.col {
		width: 49%;
		height: 100%;
		background: #fff;
		display: inline-block;
		margin-top: 100px;
	}
	
	.demo-card-square.mdl-card {
		width: 320px;
		height: 320px;
	}
	
	.demo-card-square>.mdl-card__title {
		color: #fff;
		background: url('../assets/demos/dog.png') bottom right 15% no-repeat
			#46B6AC;
	}
	
	</style>
	
</head>
<body>

	
	<%@ include file="menu.jsp" %>

	<div class="container-box">	
	
		<div class="col">
			<div class="demo-card-square mdl-card mdl-shadow--2dp">
				<div class="mdl-card__title mdl-card--expand">
					<h2 class="mdl-card__title-text">Register</h2>
				</div>
				<div class="mdl-card__supporting-text">
					Register a new user.
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<a href="register"
						class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
						New Register </a>
				</div>
			</div>
		</div>
		
		<div class="col">
					<div class="demo-card-square mdl-card mdl-shadow--2dp">
				<div class="mdl-card__title mdl-card--expand">
					<h2 class="mdl-card__title-text">List</h2>
				</div>
				<div class="mdl-card__supporting-text">
					List all users
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<a href="user?action=list"
						class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
						 View List </a>
				</div>
			</div>
		</div>
		
	</div>

	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
	
</body>
</html>