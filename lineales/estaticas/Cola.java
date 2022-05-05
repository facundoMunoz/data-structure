package lineales.estaticas;

public class Cola {

	private static final int TAMANIO = 10;
	private Object[] arreglo;
	private int frente;
	private int fin;

	// Constructores
	public Cola() {

		arreglo = new Object[TAMANIO];
		this.frente = 0;
		this.fin = 0;

	}

	// Modificadores
	public boolean poner(Object nuevoElemento) {
		boolean exito = false;
		int siguientePosicion = (this.fin + 1) % Cola.TAMANIO;

		if (this.arreglo[siguientePosicion] == null) {
			this.arreglo[this.fin] = nuevoElemento;
			this.fin = siguientePosicion;
			exito = true;
		}

		return exito;
	}

	public boolean sacar() {
		boolean exito = false;

		if (!this.esVacia()) {
			this.arreglo[this.frente] = null;
			this.frente = (this.frente + 1) % Cola.TAMANIO;
			exito = true;
		}

		return exito;
	}

	// Observadores
	public Object obtenerFrente() {
		Object objeto = null;

		if (this.arreglo[frente] != null) {
			objeto = this.arreglo[frente];
		}

		return objeto;
	}

	public boolean esVacia() {

		return this.fin == this.frente;

	}

	// Propias del tipo
	public void vaciar() {

		arreglo = new Object[TAMANIO];
		this.frente = 0;
		this.fin = 0;

	}

	public Cola clone() {
		Cola clon = new Cola();

		clon.fin = this.fin;
		clon.frente = this.frente;
		int posicion = clon.frente;

		while (posicion != this.fin) {
			clon.arreglo[posicion] = this.arreglo[posicion];
			posicion = (posicion + 1) % Cola.TAMANIO;
		}

		return clon;
	}

	@Override
	public String toString() {
		String texto;

		if (this.esVacia()) {
			texto = "Cola vacia";
		} else {
			int i = this.frente;
			texto = "";

			while (i != this.fin) {
				texto += arreglo[i];
				if (arreglo[(i + 1) % Cola.TAMANIO] != null) {
					texto += ",";
				}
				i = (i + 1) % Cola.TAMANIO;
			}

		}

		return texto;
	}

}