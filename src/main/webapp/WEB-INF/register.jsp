<%@page import="br.com.jspJDBC.webProject.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>

<style>

	body{
		margin:0;
		padding:0
	}

	.form{
		padding: 20px;
		width:220px;
		height:auto;
		margin-left:auto;
		margin-right:auto;
		margin-top: 80px;
		border: 1px dotted #000;
		box-shadow:1px  1px 1px 1px;
	}
	
	.form input{
		width: 92%;
		text-align: center;
	}
	
</style>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">

</head>
<body>

	<%
		    User user = (User)request.getAttribute("update");
			String name = (user != null) ? user.getName() : ""; 
			String username = (user != null) ? user.getUsername() : "";
			String password = (user != null) ? user.getPassword() : "";
			int id = (user != null) ? user.getId() : 0;
	%>

	<div class="form">
		<form action="register.do" method="post" onsubmit="return register();">
		
		<input type="hidden" name="id" value="<%= id %>">
		
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
	     <input class="mdl-textfield__input" name="name" type="text" id="name" value="<%= name %>">
	     <label class="mdl-textfield__label" for="sample3">Name...</label>
	    </div>
	    
	    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
	     <input class="mdl-textfield__input" name="username" type="text" id="username" value="<%= username %>">
	     <label class="mdl-textfield__label" for="sample3">Username...</label>
	    </div>
		
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
	     <input class="mdl-textfield__input" name="password" type="password" id="password" value="<%= password %>">
	     <label class="mdl-textfield__label" for="sample3">Password...</label>
	    </div>
	
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored"><%= (user != null) ? "Update" : "Register" %></button>
		
		</form>
	</div>
	
	<script>

	
		function register(){
			var name = document.getElementById("name").value;
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
				
			if((name != '') && (username != '') && (password != '')){
				return true;
			}
			
			return false;
		}

	
	</script>
	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</body>
</html>