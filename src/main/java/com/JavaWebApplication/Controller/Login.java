package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.User;
import com.JavaWebApplication.Model.insertUser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user;
		insertUser iu = new insertUser();
		PrintWriter out = response.getWriter();
		
		user = iu.readUser(email,password);
		
		if (user.isFound()) {   // falso di default, se viene trovato viene settato a true
			out.println("Successul log in:\n");
			out.println(user.getName());
			out.println(user.getCognome());
			out.println(user.getEmail());
			out.println(user.getPassword());
			
			HttpSession session = request.getSession();
			session.setAttribute("nome",user.getName());

			session.setAttribute("cognome",user.getCognome());

			session.setAttribute("email",user.getEmail());

			session.setAttribute("password",user.getPassword());
			
			response.sendRedirect("http://localhost:8080/Sample-WebApp/jsp/welcome.jsp");
		}
		else {
			out.println(" \n Errore!");
		}
		
		
	}

}
