package br.com.jspJDBC.webProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jspJDBC.webProject.entity.User;
import br.com.jspJDBC.webProject.jdbc.UserDAO;

@WebServlet(urlPatterns = { "/authentication", "/authentication.do" })
public class AuthenticateController extends HttpServlet {

	/**
	 * Version 1L
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		resp.sendRedirect("login.html");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("login");
		String password = req.getParameter("password");

		UserDAO userdao = new UserDAO();
		User user = new User();

		if ((username != "") && (password != "")) {

			user.setUsername(username);
			user.setPassword(password);

			User newUser = userdao.authentication(user);

			if (newUser != null) {
				HttpSession session = req.getSession();
				session.setAttribute("authentication", newUser);
				session.setMaxInactiveInterval(60 * 5);
				req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);

			} else {
				resp.getWriter().print("<script> alert('No User found'); window.location.href = 'login.html'</script>");
			}
		} else {
			resp.getWriter()
					.print("<script> alert('No credential found'); window.location.href = 'login.html'</script>");
		}

	}

}
