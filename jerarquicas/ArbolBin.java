package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

public class ArbolBin {

	private NodoArbol raiz;

	// Constructor
	public ArbolBin() {

		this.raiz = null;

	}

	// Modificadores
	public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
		boolean exito = false;

		if (this.esVacio()) {
			this.raiz = new NodoArbol(elemNuevo);
			exito = true;
		} else {
			NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);

			if (nodoPadre != null) {
				if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
					nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
					exito = true;
				} else {
					if (lugar == 'D' && nodoPadre.getDerecho() == null) {
						nodoPadre.setDerecho(new NodoArbol(elemNuevo));
						exito = true;
					}
				}
			}
		}

		return exito;
	}

	public void vaciar() {

		this.raiz = null;

	}

	// Observadores
	private NodoArbol obtenerNodo(NodoArbol nodo, Object buscado) {
		NodoArbol resultado = null;

		if (nodo != null) {
			if (nodo.getElem().equals(buscado)) {
				resultado = nodo;
			} else {
				resultado = obtenerNodo(nodo.getIzquierdo(), buscado);

				if (resultado == null) {
					resultado = obtenerNodo(nodo.getDerecho(), buscado);
				}
			}
		}

		return resultado;
	}

	public boolean esVacio() {

		return this.raiz == null;

	}

	public int altura() {

		return this.getCantNiveles(this.raiz, 0);

	}

	private int getCantNiveles(NodoArbol nodo, int nivel) {

		if (nodo != null) {
			nivel = Math.max(this.getCantNiveles(nodo.getIzquierdo(), nivel + 1),
					this.getCantNiveles(nodo.getDerecho(), nivel + 1));
		} else {
			nivel--;
		}

		return nivel;
	}

	public int nivel(Object elemento) {

		return buscarNivel(this.raiz, 0, elemento);

	}

	private int buscarNivel(NodoArbol nodo, int nivel, Object elemento) {
		// Recorrido de búsqueda en preorden
		int retorna = -1;

		if (nodo != null) {
			if (nodo.getElem().equals(elemento)) {
				retorna = nivel;
			} else {
				// Al buscar en un hijo aumenta el nivel
				retorna = buscarNivel(nodo.getIzquierdo(), nivel + 1, elemento);
				if (retorna == -1) {
					// Sólo sigue buscando si el retorna no cambió
					retorna = buscarNivel(nodo.getDerecho(), nivel + 1, elemento);
				}
			}
		}

		return retorna;
	}

	public Object padre(Object elemento) {

		return buscarPadre(this.raiz, elemento, null);

	}

	private Object buscarPadre(NodoArbol nodo, Object hijo, Object padre) {
		// Recorrido de búsqueda en preorden
		Object retorna = null;

		if (nodo != null) {
			if (nodo.getElem().equals(hijo)) {
				retorna = padre;
			} else {
				retorna = buscarPadre(nodo.getIzquierdo(), hijo, nodo.getElem());
				if (retorna == null) {
					// Sólo sigue buscando si el retorna no cambió
					retorna = buscarPadre(nodo.getDerecho(), hijo, nodo.getElem());
				}
			}
		}

		return retorna;
	}

	public Lista listarPreorden() {

		Lista lista = new Lista();
		listarPreordenAux(this.raiz, lista);
		return lista;

	}

	private void listarPreordenAux(NodoArbol nodo, Lista lista) {

		if (nodo != null) {
			lista.insertar(nodo.getElem(), lista.longitud() + 1);
			listarPreordenAux(nodo.getIzquierdo(), lista);

			listarPreordenAux(nodo.getDerecho(), lista);
		}

	}

	public Lista listarInorden() {

		Lista lista = new Lista();
		listarInordenAux(this.raiz, lista);
		return lista;

	}

	private void listarInordenAux(NodoArbol nodo, Lista lista) {

		if (nodo != null) {
			listarInordenAux(nodo.getIzquierdo(), lista);

			lista.insertar(nodo.getElem(), lista.longitud() + 1);
			listarInordenAux(nodo.getDerecho(), lista);
		}

	}

	public Lista listarPosorden() {

		Lista lista = new Lista();
		listarPosordenAux(this.raiz, lista);
		return lista;

	}

	private void listarPosordenAux(NodoArbol nodo, Lista lista) {

		if (nodo != null) {
			listarPosordenAux(nodo.getIzquierdo(), lista);
			listarPosordenAux(nodo.getDerecho(), lista);

			lista.insertar(nodo.getElem(), lista.longitud() + 1);
		}

	}

	public Lista listarPorNiveles() {
		Lista lista = new Lista();
		if (!esVacio()) {
			Cola cola = new Cola();
			NodoArbol nodoActual;
			cola.poner(this.raiz);

			while (!cola.esVacia()) {
				// Me coloco en el nivel
				nodoActual = (NodoArbol) cola.obtenerFrente();
				cola.sacar();
				lista.insertar(nodoActual.getElem(), lista.longitud() + 1);

				// Cargo en la lista los elementos
				if (nodoActual.getIzquierdo() != null) {
					cola.poner(nodoActual.getIzquierdo());
				}
				if (nodoActual.getDerecho() != null) {
					cola.poner(nodoActual.getDerecho());
				}
			}
		}

		return lista;
	}

	// Propias del tipo
	@Override
	public ArbolBin clone() {
		ArbolBin copia = new ArbolBin();

		if (!this.esVacio()) {
			copia.raiz = clonAux(this.raiz);
		}

		return copia;
	}

	private NodoArbol clonAux(NodoArbol nodo) {
		// Clonamos el actual
		NodoArbol nuevo = new NodoArbol(nodo.getElem());

		if (nodo.getIzquierdo() != null) {
			// Enlazamos el clon de su subarbol izquierdo
			nuevo.setIzquierdo(clonAux(nodo.getIzquierdo()));
		}

		if (nodo.getDerecho() != null) {
			// Enlazamos el clon de su subarbol derecho
			nuevo.setDerecho(clonAux(nodo.getDerecho()));
		}

		return nuevo;
	}

	public Lista frontera() {
		Lista retorno = new Lista();

		fronteraAux(this.raiz, retorno);

		return retorno;
	}

	private void fronteraAux(NodoArbol raiz, Lista lista) {

		if (raiz != null) {
			if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
				// Si estamos en una hoja lo agrega a la lista
				lista.insertar(raiz.getElem(), lista.longitud() + 1);
			} else {
				fronteraAux(raiz.getIzquierdo(), lista);
				fronteraAux(raiz.getDerecho(), lista);
			}
		}

	}

	// Testing
	public String toString() {
		String cadena = "Arbol vacio";

		if (this.raiz != null) {
			cadena = "";
			cadena = stringAux(this.raiz, cadena);
		}
		return cadena;
	}

	private String stringAux(NodoArbol nodo, String cadena) {
		String cadena2 = cadena;
		cadena2 += "Nodo:" + nodo.getElem();
		if (nodo.getIzquierdo() != null) {
			cadena2 += " HI:" + nodo.getIzquierdo().getElem();
		} else {
			cadena2 += " HI:-";
		}

		if (nodo.getDerecho() != null) {
			cadena2 += " HD:" + nodo.getDerecho().getElem() + "\n";
		} else {
			cadena2 += " HD:- \n";
		}

		if (nodo.getIzquierdo() != null) {
			cadena2 = stringAux(nodo.getIzquierdo(), cadena2);
		}

		if (nodo.getDerecho() != null) {
			cadena2 = stringAux(nodo.getDerecho(), cadena2);
		}

		return cadena2;

	}

}
