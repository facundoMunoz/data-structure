package jerarquicas;

public class NodoArbol {

	private Object elemento;
	private NodoArbol izquierdo;
	private NodoArbol derecho;

	public NodoArbol(Object unElemObject) {

		this.elemento = unElemObject;

	}

	public NodoArbol(Object unElemento, NodoArbol unIzquierdo, NodoArbol unDerecho) {

		this.elemento = unElemento;
		this.izquierdo = unIzquierdo;
		this.derecho = unDerecho;

	}

	public Object getElem() {

		return this.elemento;

	}

	public NodoArbol getIzquierdo() {

		return this.izquierdo;

	}

	public NodoArbol getDerecho() {

		return this.derecho;

	}

	public void setElem(Object nuevoElemento) {

		this.elemento = nuevoElemento;

	}

	public void setIzquierdo(NodoArbol nuevoIzquierdo) {

		this.izquierdo = nuevoIzquierdo;

	}

	public void setDerecho(NodoArbol nuevoDerecho) {

		this.derecho = nuevoDerecho;

	}

}