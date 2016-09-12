package br.com.jspJDBC.webProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jspJDBC.webProject.entity.User;
import br.com.jspJDBC.webProject.jdbc.UserDAO;

@WebServlet(urlPatterns = {"/register","/register.do"})
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private String name,username,password;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.html");
		requestDispatcher.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		name = req.getParameter("name");
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		UserDAO userdao = new UserDAO();
		userdao.register(new User(name, username, password));
		
		resp.getWriter().print("<b> Registered Successful </b>");
	}
	
}
