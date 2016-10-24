package com.dromedicas.webcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateMail
 */
@WebServlet("/ValidateMail")
public class ValidateMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Obtengo el parametro tipo que me permitira saber cual tabla modificar
		String tipo = request.getParameter("tokencliente");
		String correoLeido = request.getParameter("openmail");

		

		System.out.println("Mensaje leido enviado a: " + correoLeido);

		// request.setAttribute("mensaje", respuesta);
		// request.getRequestDispatcher("confirmacion.jsp").forward(request,
		// response);

	}

}
