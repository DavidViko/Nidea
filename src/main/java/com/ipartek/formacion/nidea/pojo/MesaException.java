package com.ipartek.formacion.nidea.pojo;

public class MesaException extends Exception {
	private static final long serialVersionUID = 1L; // Cuando se da a seralize en el error. Se supone que es para que
														// compile mas rapido
	public static String MENSAJE_PATAS = "Minimo debe tener 1 pata";

	public MesaException(String mensaje) {
		super(mensaje);
	}

}
