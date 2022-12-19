package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.PrenotaBean;
import com.JavaWebApplication.Model.insertUser;

/**
 * Servlet implementation class Prenota
 */
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prenota() {
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
		PrintWriter out = response.getWriter();
		Enumeration<String> params = request.getParameterNames();
		PrenotaBean prenotazione;
		insertUser iu = new insertUser();
		
		String nomePaziente = request.getParameter("nomePaziente");
		String dataPrenotazione = request.getParameter("dataPrenotazione");
		String genere = request.getParameter("inlineRadioOptions");
		String tipologiaVisita = request.getParameter("inlineRadioOptions2");
		String codicePrenotazione = request.getParameter("codicePrenotazione");
		
		prenotazione  = new PrenotaBean(nomePaziente,dataPrenotazione,genere,tipologiaVisita,codicePrenotazione);
		String s1 = iu.InserPrenotazione(prenotazione);
		if(s1 == " Prenotazione andata a buon fine") {			
			response.sendRedirect("http://localhost:8080/Sample-WebApp/jsp/success.jsp");
		}else {
			out.println("ERRORE");
		}

		}
		
	}
