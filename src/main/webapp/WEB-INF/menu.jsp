<%@ page import="br.com.jspJDBC.webProject.entity.User"%>

<%
	User userSession  = (User) request.getSession().getAttribute("authentication");
%>

<div class="mdl-layout mdl-js-layout">
  <header class="mdl-layout__header">
    <div class="mdl-layout-icon"></div>
    <div class="mdl-layout__header-row">
      <span class="mdl-layout__title">Bem vindo, <%= userSession.getName() %>  ( <%= userSession.getUsername() %> )</span>
	  <div class="mdl-layout-spacer"></div>
	        <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="authentication.do"> Logout </a>
      </nav>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout__title"> Where to go ? </span>
      <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="home.do"> Home </a>
      <a class="mdl-navigation__link" href="register"> Register User</a>
      <a class="mdl-navigation__link" href="user?action=list"> List User</a>
    </nav>
  </header>
</div>