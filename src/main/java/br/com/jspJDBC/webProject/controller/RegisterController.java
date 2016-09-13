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
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/register.jsp");
		requestDispatcher.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		name = req.getParameter("name");
		username = req.getParameter("username");
		password = req.getParameter("password");

		User user = new User(id,name, username, password);

		UserDAO userdao = new UserDAO();
		userdao.save(user);
		resp.sendRedirect("user?action=list");
	}
	
}
