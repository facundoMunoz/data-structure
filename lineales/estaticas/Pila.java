package lineales.estaticas;

public class Pila {

	private static final int TAMANIO = 10;
	private Object[] arreglo;
	private int tope;

	// Constructor
	public Pila() {
		this.arreglo = new Object[TAMANIO];
		this.tope = -1;
	}

	// Modificadores
	public boolean apilar(Object nuevoElem) {
		boolean exito;

		if (this.tope == Pila.TAMANIO - 1) {
			exito = false;
		} else {
			this.tope++;
			this.arreglo[tope] = nuevoElem;
			exito = true;
		}

		return exito;
	}

	public boolean desapilar() {
		boolean exito;

		if (this.tope == -1) {
			exito = false;
		} else {
			this.arreglo[tope] = null;
			this.tope--;
			exito = true;
		}

		return exito;
	}

	// Observadores
	public Object obtenerTope() {
		Object objeto = null;

		if (this.tope > -1) {
			objeto = this.arreglo[tope];
		}

		return objeto;
	}

	public boolean esVacia() {

		return this.tope == -1;

	}

	// Propias del tipo
	public void vaciar() {

		this.arreglo = new Object[TAMANIO];
		this.tope = -1;

	}

	public Pila clone() {
		Pila clon = new Pila();

		clon.tope = this.tope;
		clon.arreglo = this.arreglo.clone();

		return clon;
	}

	public boolean capicua() {
		// Método para verificar si una pila es capicua
		boolean esCapicua = true;
		int tope = this.tope;
		int fondo = 0;

		while (fondo < tope && esCapicua) {
			// Recorremos de forma simétrica
			if (this.arreglo[fondo] != this.arreglo[tope]) {
				// Si no coinciden los lados detenemos la búsqueda
				esCapicua = false;
			}
			fondo++;
			tope--;
		}

		return esCapicua;
	}

	// Testing
	@Override
	public String toString() {
		String texto;

		if (this.esVacia()) {
			texto = "Pila vacia";
		} else {
			int i = 0;
			texto = "";

			while (i < Pila.TAMANIO && arreglo[i] != null) {
				texto += arreglo[i];
				if (i < Pila.TAMANIO - 1 && arreglo[i + 1] != null) {
					texto += ",";
				}
				i++;
			}

		}

		return texto;
	}

}