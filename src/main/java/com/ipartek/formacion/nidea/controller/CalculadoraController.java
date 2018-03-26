package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;

	public static final int OP_SUMAR = 1;
	public static final int OP_RESTAR = 2;
	public static final int OP_MULTIPLICAR = 3;
	public static final int OP_DIVIDIR = 4;

	float num1 = 0;// Si se pone entero =0 =3 no hace falta la f. Si es 3.2f, si es necesaria
	float num2 = 0;
	int opcion = CalculadoraController.OP_SUMAR;
	float resultado = 0f;
	String resul = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Nos llaman a través de un enlace, peticion GET
		request.getRequestDispatcher("views/calculadora/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// recoger los parámetros
			getParameters(request);

			// lógica de negocio
			calcular();

			// enviar atributos a la vista
			request.setAttribute("resultado", resul);

			// Nos llaman a través de un FORM con method="post"
			dispatch = request.getRequestDispatcher("views/calculadora/resultado.jsp");
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
			request.setAttribute("alert", new Alert("Mete los numeros bien, torpe", Alert.TIPO_DANGER));
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alert", new Alert("Disculpa, hay un error sin controlar"));

			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");
		} finally {
			dispatch.forward(request, response);
		}

	}

	private void getParameters(HttpServletRequest request) {
		String sNum1 = request.getParameter("num1"); // lo que se pone entre parentesis es el name del input
		String sNum2 = request.getParameter("num2");
		String sOpcion = request.getParameter("opcion");

		sNum1 = sNum1.replaceAll(",", ".");
		sNum2 = sNum2.replaceAll(",", ".");

		num1 = Float.parseFloat(sNum1);
		num2 = Float.parseFloat(sNum2);
		opcion = Integer.parseInt(sOpcion);
	}

	private void calcular() {
		switch (opcion) {
		case 1:
			resultado = num1 + num2;
			break;
		case 2:
			resultado = num1 - num2;
			break;
		case 3:
			resultado = num1 * num2;
			break;
		case 4:
			resultado = num1 / num2;
			break;
		}
		resul = Float.toString(resultado);
		resul = resul.replaceAll(".", ",");
	}

}
