package lineales.dinamicas;

public class Pila {

	private Nodo tope;

	// Constructor
	public Pila() {

		this.tope = null;

	}

	// Modificadores
	public boolean apilar(Object nuevoElem) {
		this.tope = new Nodo(nuevoElem, this.tope);

		return true;
	}

	public boolean desapilar() {
		boolean exito;

		if (this.tope == null) {
			exito = false;
		} else {
			this.tope = this.tope.getEnlace();
			exito = true;
		}

		return exito;
	}

	// Observadores
	public Object obtenerTope() {
		Object elemento = null;

		if (this.tope != null) {
			elemento = this.tope.getElemento();
		}

		return elemento;
	}

	public boolean esVacia() {

		return this.tope == null;

	}

	// Propias del tipo
	public void vaciar() {

		this.tope = null;

	}

	public Pila clone() {
		Pila clon = new Pila();
		Nodo nodoAdelante = this.tope;
		clon.tope = new Nodo(nodoAdelante.getElemento(), null);
		nodoAdelante = nodoAdelante.getEnlace();
		Nodo nodoAtras = clon.tope;

		while (nodoAdelante != null) {
			nodoAtras.setEnlace(new Nodo(nodoAdelante.getElemento(), null));
			nodoAtras = nodoAtras.getEnlace();
			nodoAdelante = nodoAdelante.getEnlace();
		}

		return clon;
	}

	// Testing
	@Override
	public String toString() {
		String texto;

		if (this.esVacia()) {
			texto = "Pila vacia";
		} else {
			Nodo nodoAuxiliar = this.tope;
			texto = "";

			while (nodoAuxiliar != null) {
				texto = nodoAuxiliar.getElemento() + texto;
				nodoAuxiliar = nodoAuxiliar.getEnlace();
				if (nodoAuxiliar != null) {
					texto = "," + texto;
				}
			}
		}

		return texto;
	}

}