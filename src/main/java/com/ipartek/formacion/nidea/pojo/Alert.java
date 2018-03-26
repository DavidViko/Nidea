package com.ipartek.formacion.nidea.pojo;

public class Alert {
	private String mensaje;
	private String tipo;

	// tipos de alertas
	public static final String TIPO_DANGER = "danger";
	public static final String TIPO_WARNING = "warning";
	public static final String TIPO_PRIMARY = "primary";

	public Alert() {
		super();
		this.mensaje = "Sentimos las molestias. Tenemos un error inesperado";
		this.tipo = "TIPO_DANGER";
	}

	public Alert(String mensaje) {
		this();// hay que cambiar el super que viene por defecto
		this.mensaje = mensaje;
	}

	public Alert(String mensaje, String tipo) {
		this();
		this.mensaje = mensaje;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alert [mensaje=" + mensaje + ", tipo=" + tipo + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
