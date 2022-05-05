package conjuntistas;

public class Nodo {

	private Object elem;
	private Nodo enlace;

	// Constructores
	public Nodo(Object unElem, Nodo unEnlace) {
		this.elem = unElem;
		this.enlace = unEnlace;
	}

	public Nodo(Object unElem) {
		this.elem = unElem;
		this.enlace = null;
	}

	// Observadores
	public Object getElem() {
		return this.elem;
	}

	public Nodo getEnlace() {
		return this.enlace;
	}

	// Modificadores
	public void setElem(Object unElem) {
		this.elem = unElem;
	}

	public void setEnlace(Nodo unEnlace) {
		this.enlace = unEnlace;
	}

}