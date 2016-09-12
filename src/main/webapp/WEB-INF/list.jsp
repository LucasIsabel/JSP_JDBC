<%@ page import="br.com.jspJDBC.webProject.entity.User"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
<link rel="stylesheet"
	href="css/style.css">
<title> Users List </title>
</head>
<body>

	<div class="container">
		<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
			<thead>
				<tr>
					<th class="mdl-data-table__cell--non-numeric">Name</th>
					<th class="mdl-data-table__cell--non-numeric">Username</th>
					<th class="mdl-data-table__cell--non-numeric">Password</th>
				</tr>
			</thead>
			<tbody>
			
			<% 
				
				List<User> list = (List<User>) request.getAttribute("list");
				if(list != null)
				for(User user : list){
			%>
				
				<tbody>
			      <tr>
			      	<td class="mdl-data-table__cell--non-numeric"><%= user.getName() %></td>
			      	<td><%= user.getUsername() %></td>
			      	<td><%= user.getPassword() %></td>
			      	<td>
			      		<a href="user?action=delete&id=<%= user.getId() %>">
			      			<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">Delete</button>
			      		</a>
			      	</td>
			      	<td>
			      		<a href="user?action=update&id=<%= user.getId() %>">
			      			<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Update</button>
			      		</a>
			      	</td>
			      </tr>
			   </tbody>

			<%
				}
			%>
				
			</tbody>	
		</table>
	</div>
	
	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</body>
</html>