package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();
	private static final String USER = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ir a la JSP
		view = "/views/login/login.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mesa m = new Mesa();
		MaterialDAO dao = new MaterialDAO();

		try {
			String sUsuario = request.getParameter("usuario");
			String sPassword = request.getParameter("password");

			// enviar atributos a la JSP
			request.setAttribute("mesa", m);// lo que se pasa puede ser cualquier cosa (int, string, objeto...)
			request.setAttribute("materiales", dao.getAll());

			if (USER.equalsIgnoreCase(sUsuario) && PASS.equals(sPassword)) {
				view = "backoffice/index.jsp";
				alert = new Alert("ONGI ETORRI", Alert.TIPO_PRIMARY);
			} else {
				view = "views/login/login.jsp";
				alert = new Alert("Credenciales incorrectas");
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
