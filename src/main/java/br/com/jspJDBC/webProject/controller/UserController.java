package br.com.jspJDBC.webProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jspJDBC.webProject.entity.User;
import br.com.jspJDBC.webProject.jdbc.UserDAO;

@WebServlet(urlPatterns = { "/user", "/user.do" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name, username, password;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/list.jsp");
		resp.setContentType("text/html");
		if (action != null) {
			UserDAO userdao = new UserDAO();

			if (action.equals("delete")) {
				String id = req.getParameter("id");
				if (id != null) {
					userdao.delete(Integer.valueOf(id));
					resp.sendRedirect("user?action=list");
				} else {
					resp.getWriter().println("<b> No ID </b>");
				}
			} else if (action.equals("list")) {
				req.setAttribute("list", userdao.getAll());
				requestDispatcher.forward(req, resp);
				
			} else if(action.equals("update")){
				String id = req.getParameter("id");
				req.setAttribute("update", userdao.getById(Integer.valueOf(id)));
				RequestDispatcher register = req.getRequestDispatcher("WEB-INF/register.jsp");
				register.forward(req,resp);
				
			} else {
				resp.getWriter().println("No parameters");
			}
		} else {
			resp.getWriter().println("<b> Nothing to Do </b>");
		}
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action.equals("delete")) {
			int id = Integer.valueOf(req.getParameter("id"));
			UserDAO userdao = new UserDAO();
			userdao.delete(id);
			resp.getWriter().println("<p/> ID : " + id + " Deleted </p>");
		}
	}
}
