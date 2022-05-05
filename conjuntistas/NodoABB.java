package conjuntistas;

public class NodoABB {

	private Comparable elem;
	private NodoABB izquierdo;
	private NodoABB derecho;

	// Constructores
	public NodoABB(Comparable elemento) {
		this.elem = elemento;
		this.izquierdo = null;
		this.derecho = null;
	}

	public NodoABB(Comparable elemento, NodoABB izq, NodoABB der) {
		this.elem = elemento;
		this.izquierdo = izq;
		this.derecho = der;
	}

	// Observadores
	public Comparable getElem() {
		return this.elem;
	}

	public NodoABB getIzquierdo() {
		return this.izquierdo;
	}

	public NodoABB getDerecho() {
		return this.derecho;
	}

	// Modificadores
	public void setElem(Comparable elemento) {
		this.elem = elemento;
	}

	public void setIzquierdo(NodoABB izq) {
		this.izquierdo = izq;
	}

	public void setDerecho(NodoABB der) {
		this.derecho = der;
	}

}