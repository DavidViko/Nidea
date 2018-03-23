//1. Definici�n paquete Package
package com.ipartek.formacion.nidea.pojo;

//2. Imports

//3. Definici�n de la clase
public class Mesa {

	// Por defecto de 4 patas, blanco, madera y 1 metro cuadrado

	// precios en �
	public static final int PRECIO_PATA = 1; // publis static para poder usarlas en otros metodos de la clase
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_MATERIAL_MADERA = 4;
	public static final int PRECIO_MATERIAL_ACERO = 6;
	public static final int PRECIO_MATERIAL_ALUMINIO = 5;
	public static final int PRECIO_MATERIAL_PLASTICO = 2;
	public static final int PRECIO_COLOR_CUSTOM = 23;
	public static final String PRECIO_COLOR_NAME_CUSTOM = "custom";

	public static final int MATERIAL_MADERA = 1;
	public static final int MATERIAL_ACERO = 2;
	public static final int MATERIAL_ALUMINIO = 3;
	public static final int MATERIAL_PLASTICO = 4;

	// estos arrays para hacer mas comodo, para cuando las listas sean mas largas,
	// poder manipualrla mas comodo
	public static final String[] MATERIALES_LISTA = { "madera", "acero", "aluminio", "plastico" };
	public static final int[] MATERIALES_LISTA_CODIGO = { 1, 2, 3, 4 };

	// 4. Atributos. Siempre PRIVATE para mantener la encapsulaci�n
	private int numeroPatas;
	private int dimension;// metros cuadrados
	private String color;
	private boolean custom;
	private int material;

	/*
	 * 5. M�todos 5.1 Constructores 5.2 Getters y setters 5.3 Otros
	 */

	/**
	 * Constructor por defecto. Inicializa los atrubutos a valores por defecto
	 */
	public Mesa() {
		super(); // el constructor por defecto siempre llama a super()
		setNumeroPatas(4);
		setColor("blanco");
		// isCustom() = false;
		setDimension(1);
		setMaterial(MATERIAL_MADERA);
	}

	/**
	 * Constructor con 1 par�metro (Sobrecarga del constructor)
	 * 
	 * @param material
	 */
	public Mesa(int material) {
		this(); // llamar siempre al constructor por defecto
		this.material = material;
	}

	/**
	 * Constructr con 2 par�metros
	 * 
	 * @param material
	 * @param dimension
	 */
	public Mesa(int material, int dimension) {
		this(material); // llamar siempre al constructor padre
		this.dimension = dimension;
	}

	public int getNumeroPatas() {
		return numeroPatas;
	}

	/**
	 * El n�mero de patas no puede ser negativo. En ese caso se le asignar� 0.
	 * 
	 * @param numeroPatas
	 */
	public void setNumeroPatas(int numeroPatas) {
		this.numeroPatas = (numeroPatas <= 0) ? 1 : numeroPatas;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Mesa [numeroPatas=" + numeroPatas + ", dimension=" + dimension + ", color=" + color + ", material="
				+ material + "]";
	}

	/**
	 * Calculamos el precio de la mesa en funcion de los materiales
	 * 
	 * @see consultar las constantes definidas para los precios
	 * @return int precio en �
	 */
	public int getPrecio() {
		int precio = 0;

		precio = precio + numeroPatas * PRECIO_PATA;

		switch (material) {
		case MATERIAL_MADERA:
			precio = precio + PRECIO_MATERIAL_MADERA;
			break;
		case MATERIAL_ACERO:
			precio = precio + PRECIO_MATERIAL_ACERO;
			break;
		case MATERIAL_ALUMINIO:
			precio = precio + PRECIO_MATERIAL_ALUMINIO;
			break;
		case MATERIAL_PLASTICO:
			precio = precio + PRECIO_MATERIAL_PLASTICO;
			break;
		}

		precio = precio + PRECIO_M2 * dimension;

		if ("custom".equalsIgnoreCase(color)) { // IgnoreCase ignora las mayusculas
			precio = precio + PRECIO_COLOR_CUSTOM;
		}

		return precio;
	}
}
