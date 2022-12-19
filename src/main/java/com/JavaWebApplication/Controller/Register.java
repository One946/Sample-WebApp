package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.RegisterBean;
import com.JavaWebApplication.Model.insertUser;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

		RegisterBean rb = new RegisterBean();
		rb.setNome(nome);
		rb.setCognome(cognome);
		rb.setEmail(email);
		rb.setPassword(password);
		
		out.println("\n I tuoi dati:");
		out.println(nome);
		out.println(cognome);
		out.println(email);
		out.println(password);
		
		
		insertUser iu = new insertUser();
		String s1 = iu.InserUser(rb);
		
		if(s1 == "Data inserted correctly") {
		HttpSession session = request.getSession();
		session.setAttribute("nome",nome);
		session.setAttribute("cognome",cognome);
		session.setAttribute("email",email);
		session.setAttribute("password",password);
		
		response.sendRedirect("http://localhost:8080/Sample-WebApp/jsp/welcomeSignUp.jsp");
		}
	}

}
