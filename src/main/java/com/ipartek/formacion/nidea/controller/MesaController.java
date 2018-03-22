package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MesaController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mesa m = new Mesa();

		// recoger parametros SIEMPRE String
		String sPatas = request.getParameter("patas");
		String sDimension = request.getParameter("dimension");
		String sColor = request.getParameter("color");
		String sMaterial = request.getParameter("material");

		// si los parametros no son NULL (se viene desde el formulario) recoger y crear
		// una a medida
		if (sPatas != null) {
			int patas = Integer.parseInt(sPatas);
			m.setNumeroPatas(patas);
		}
		if (sDimension != null) {
			int dimension = Integer.parseInt(sDimension);
			m.setDimension(dimension);
		}
		if (sColor != null) {
			m.setColor(sColor);
		}
		if (sPatas != null) {
			int material = Integer.parseInt(sMaterial);
			m.setMaterial(material);
		}

		/*
		 * si se llega al Controller desde el index, los parametros se quedan con los de
		 * defecto
		 */

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);// lo que se pasa puede ser cualquier cosa (int, string, objeto...)

		// ir a la JSP
		request.getRequestDispatcher("mesa.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
