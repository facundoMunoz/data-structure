package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {

	private NodoGen raiz;

	// Constructor
	public ArbolGen() {
		this.raiz = null;
	}

	public boolean insertar(Object hijo, Object padre) {
		boolean exito;

		if (this.esVacio()) {
			// Caso especial, arbol vacio
			this.raiz = new NodoGen(hijo, null, null);
			exito = true;
		} else {
			exito = insertarAux(this.raiz, hijo, padre);
		}

		return exito;
	}

	private boolean insertarAux(NodoGen actual, Object hijo, Object padre) {
		boolean exito = false;

		if (actual != null) {
			// Visita nodo actual
			if (actual.getElem().equals(padre)) {
				if (actual.getHijoIzquierdo() != null) {
					// Si ya tiene hijos lo inserto al final de estos
					NodoGen aux = actual.getHijoIzquierdo();
					while (aux.getHermanoDerecho() != null) {
						aux = aux.getHermanoDerecho();
					}
					aux.setHermanoDerecho(new NodoGen(hijo, null, null));
				} else {
					actual.setHijoIzquierdo(new NodoGen(hijo, null, null));
				}
				exito = true;
			} else {
				// Si no, llama a los hijos
				exito = insertarAux(actual.getHijoIzquierdo(), hijo, padre);
				// Si no, llama a los hermanos
				if (!exito) {
					exito = insertarAux(actual.getHermanoDerecho(), hijo, padre);
				}
			}
		}

		return exito;
	}

	public boolean pertenece(Object buscado) {
		boolean encontrado = perteneceAux(this.raiz, buscado);

		return encontrado;
	}

	private boolean perteneceAux(NodoGen actual, Object buscado) {
		boolean encontrado = false;

		if (actual != null) {
			// Visita n
			if (actual.getElem().equals(buscado)) {
				encontrado = true;
			} else {
				// Si no, llama a los hijos
				encontrado = perteneceAux(actual.getHijoIzquierdo(), buscado);
				// Si no, llama a los hermanos
				if (!encontrado) {
					encontrado = perteneceAux(actual.getHermanoDerecho(), buscado);
				}
			}
		}

		return encontrado;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public Object padre(Object hijo) {
		Object padre = null;

		if (!(this.esVacio() || this.raiz.getElem().equals(hijo))) {
			padre = padreAux(this.raiz.getHijoIzquierdo(), this.raiz, hijo);
		}

		return padre;
	}

	private Object padreAux(NodoGen actual, NodoGen padre, Object buscado) {
		Object encontrado = null;

		if (actual != null) {
			// Visita n
			if (actual.getElem().equals(buscado)) {
				encontrado = padre.getElem();
			} else {
				// Buscamos del lado izquierdo
				encontrado = padreAux(actual.getHijoIzquierdo(), actual, buscado);
				// Buscamos en los hermanos con el mismo padre
				if (encontrado == null) {
					encontrado = padreAux(actual.getHermanoDerecho(), padre, buscado);
				}
			}
		}

		return encontrado;
	}

	public int altura() {
		int niveles = -1;

		if (!this.esVacio()) {
			niveles = alturaAux(this.raiz, 0);
		}

		return niveles;
	}

	public int alturaAux(NodoGen nodo, int nivel) {

		if (nodo != null) {
			// Si tiene hermano lo revisamos con la misma altura
			int hermano = alturaAux(nodo.getHermanoDerecho(), nivel);
			// Cada vez que baja a un hijo la altura aumenta en 1
			if (nodo.getHijoIzquierdo() != null) {
				nivel = alturaAux(nodo.getHijoIzquierdo(), nivel + 1);
			}
			// Si el contador de algun hermano es mayor usamos ese
			if (hermano > nivel) {
				nivel = hermano;
			}
		}

		return nivel;
	}

	public int nivel(Object buscado) {
		int niveles = nivelAux(this.raiz, buscado, 0);

		return niveles;
	}

	private int nivelAux(NodoGen actual, Object buscado, int nivel) {
		int retorna = -1;

		if (actual != null) {
			// Visita n
			if (actual.getElem().equals(buscado)) {
				retorna = nivel;
			} else {
				// Si no, llama a los hijos
				retorna = nivelAux(actual.getHijoIzquierdo(), buscado, nivel + 1);
				// Si no, llama a los hermanos
				if (retorna == -1) {
					retorna = nivelAux(actual.getHermanoDerecho(), buscado, nivel);
				}
			}
		}

		return retorna;
	}

	public Lista ancestros(Object elem) {
		Lista ancestros = new Lista();

		if (!this.esVacio()) {
			ancestrosAux(this.raiz, elem, ancestros);
		}

		return ancestros;
	}

	private boolean ancestrosAux(NodoGen nodo, Object elem, Lista ancestros) {
		boolean encontrado = false;

		if (nodo != null) {
			if (nodo.getElem().equals(elem)) {
				encontrado = true;
			} else {
				// Buscamos en preorden
				encontrado = ancestrosAux(nodo.getHijoIzquierdo(), elem, ancestros);
				if (encontrado) {
					// Si nos retornan true estamos en un ancestro
					ancestros.insertar(nodo.getElem(), ancestros.longitud() + 1);
				} else {
					// Si no, el llamado de los hermanos al final para no ingresarlos si se
					// encuentra
					encontrado = ancestrosAux(nodo.getHermanoDerecho(), elem, ancestros);
				}
			}
		}

		return encontrado;
	}

	public boolean insertarSobrino(Object t, Object h, Object s) {
		return insertarSobrinoAux(this.raiz, null, t, h, s, false);
	}

	private boolean insertarSobrinoAux(NodoGen nodo, NodoGen posiblePadre, Object t, Object h, Object s,
			boolean coincideTio) {
		boolean exito = false;
		if (nodo != null) {
			if (nodo.getElem().equals(t)) {
				coincideTio = true;
			}
			if (nodo.getElem().equals(h)) {
				posiblePadre = nodo;
			}
			if (posiblePadre != null && coincideTio) {
				if (posiblePadre.getHijoIzquierdo() != null) {
					// Si ya tiene hijos lo inserto al final de estos
					NodoGen aux = posiblePadre.getHijoIzquierdo();
					while (aux.getHermanoDerecho() != null) {
						aux = aux.getHermanoDerecho();
					}
					aux.setHermanoDerecho(new NodoGen(s, null, null));
				} else {
					nodo.setHijoIzquierdo(new NodoGen(s, null, null));
				}
				exito = true;
			} else {
				exito = insertarSobrinoAux(nodo.getHermanoDerecho(), posiblePadre, t, h, s, coincideTio);
				if (!exito) {
					exito = insertarSobrinoAux(nodo.getHijoIzquierdo(), posiblePadre, t, h, s, false);
				}
			}
		}

		return exito;
	}

	@Override
	public ArbolGen clone() {
		ArbolGen clon = new ArbolGen();

		if (!this.esVacio()) {
			// Clona la raiz primero
			NodoGen nodo = new NodoGen(this.raiz.getElem(), null, null);
			clon.raiz = nodo;
			cloneAux(clon.raiz, this.raiz);
		}

		return clon;
	}

	private void cloneAux(NodoGen actual, NodoGen copia) {

		if (copia != null) {
			// Si tiene hijo lo clona y lo revisa recursivamente
			if (copia.getHijoIzquierdo() != null) {
				actual.setHijoIzquierdo(new NodoGen(copia.getHijoIzquierdo().getElem(), null, null));
				cloneAux(actual.getHijoIzquierdo(), copia.getHijoIzquierdo());
			}
			// Si tiene hermano lo clona y lo revisa recursivamente
			if (copia.getHermanoDerecho() != null) {
				actual.setHermanoDerecho(new NodoGen(copia.getHermanoDerecho().getElem(), null, null));
				cloneAux(actual.getHermanoDerecho(), copia.getHermanoDerecho());
			}
		}

	}

	public void vaciar() {
		this.raiz = null;
	}

	public Lista listarPreorden() {
		Lista salida = new Lista();

		listarPreordenAux(this.raiz, salida);

		return salida;
	}

	private void listarPreordenAux(NodoGen n, Lista ls) {
		if (n != null) {
			// Visita n
			ls.insertar(n.getElem(), ls.longitud() + 1);
			// Llama a los demas hijos
			if (n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo();
				while (hijo != null) {
					listarPreordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho();
				}
			}
		}
	}

	public Lista listarInorden() {
		Lista salida = new Lista();

		listarInordenAux(this.raiz, salida);

		return salida;
	}

	private void listarInordenAux(NodoGen n, Lista ls) {
		if (n != null) {
			// Llamado recursivo con primer hijo de n
			if (n.getHijoIzquierdo() != null) {
				listarInordenAux(n.getHijoIzquierdo(), ls);
			}
			// Visita n
			ls.insertar(n.getElem(), ls.longitud() + 1);
			// Llama a los demás hijos
			if (n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
				while (hijo != null) {
					listarInordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho();
				}
			}
		}
	}

	public Lista listarPosorden() {
		Lista salida = new Lista();

		listarPosordenAux(this.raiz, salida);

		return salida;
	}

	private void listarPosordenAux(NodoGen n, Lista ls) {
		if (n != null) {
			// Llama a los demas
			if (n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo();
				while (hijo != null) {
					listarPosordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho();
				}
			}
			// Visitar n
			ls.insertar(n.getElem(), ls.longitud() + 1);
		}
	}

	public Lista listarPorNiveles() {
		Lista niveles = new Lista();
		Cola cola = new Cola();
		cola.poner(this.raiz);
		int longitud = 1;

		while (!cola.esVacia()) {
			NodoGen nodo = (NodoGen) cola.obtenerFrente();
			cola.sacar();
			niveles.insertar(nodo.getElem(), longitud);
			longitud++;
			nodo = nodo.getHijoIzquierdo();
			while (nodo != null) {
				cola.poner(nodo);
				nodo = nodo.getHermanoDerecho();
			}
		}

		return niveles;
	}

	// Propias del tipo
	public int grado() {
		int niveles = -1;

		if (!this.esVacio()) {
			niveles = gradoAux(this.raiz, 0);
		}

		return niveles;
	}

	private int gradoAux(NodoGen nodo, int mayor) {

		if (nodo != null) {
			// Cada vez que baja a un hijo "resetea" el contador
			int hijo = 0;
			if (nodo.getHijoIzquierdo() != null) {
				hijo = gradoAux(nodo.getHijoIzquierdo(), 1);
			}
			// Si tiene hermano sumamos uno a ese contador
			if (nodo.getHermanoDerecho() != null) {
				mayor = gradoAux(nodo.getHermanoDerecho(), mayor + 1);
			}
			// Si el contador de algun hijo es mayor usamos ese
			if (hijo > mayor) {
				mayor = hijo;
			}
		}

		return mayor;
	}

	public int gradoSubarbol(Object buscado) {
		int grado = -1;

		if (!this.esVacio()) {
			NodoGen nodo = buscarNodo(this.raiz, buscado);
			// Sólo revisamos el nuevo subarbol si tiene hijos
			if (nodo != null) {
				NodoGen auxiliar = nodo.getHijoIzquierdo();
				int actual = 0;
				// Revisamos los hijos del nodo encontrado por separado para evitar que gradoAux
				// recorra los hermanos de este
				while (auxiliar != null) {
					actual++;
					auxiliar = auxiliar.getHermanoDerecho();
				}
				// Luego suponemos que el mayor está en los hijos de la raiz del subarbol
				grado = this.gradoAux(nodo.getHijoIzquierdo(), 0);
				// En caso contrario nos quedamos con el actual
				if (grado < actual) {
					grado = actual;
				}
			}
		}

		return grado;
	}

	private NodoGen buscarNodo(NodoGen actual, Object buscado) {
		NodoGen encontrado = null;

		if (actual != null) {
			// Visita n
			if (actual.getElem().equals(buscado)) {
				encontrado = actual;
			} else {
				// Si no, llama a los hijos
				encontrado = buscarNodo(actual.getHijoIzquierdo(), buscado);
				// Si no, llama a los hermanos
				if (encontrado == null) {
					encontrado = buscarNodo(actual.getHermanoDerecho(), buscado);
				}
			}
		}

		return encontrado;
	}

	public Lista listarHastaNivel(int nivel) {
		Lista lista = new Lista();

		listarHastaNivelAux(lista, this.raiz, 0, nivel);

		return lista;
	}

	public void listarHastaNivelAux(Lista lista, NodoGen nodo, int nivelActual, int nivel) {
		if (nodo != null && nivelActual <= nivel) {
			// Visita n
			lista.insertar(nodo.getElem(), lista.longitud() + 1);
			// Llama a los demas hijos
			// Al revisar hijos aumentamos el nivel
			nivelActual += 1;
			NodoGen hijo = nodo.getHijoIzquierdo();
			if (hijo != null && nivelActual <= nivel) {
				while (hijo != null) {
					listarHastaNivelAux(lista, hijo, nivelActual, nivel);
					hijo = hijo.getHermanoDerecho();
				}
			}
		}
	}

	public Lista listarEntreNiveles(int min, int max) {
		Lista lista = new Lista();

		listarEntreNivelesAux(lista, this.raiz, 0, min, max);

		return lista;
	}

	private void listarEntreNivelesAux(Lista lista, NodoGen nodo, int nivelActual, int min, int max) {
		if (nodo != null && nivelActual <= max) {
			// Reviso a la izquierda
			if (nodo.getHijoIzquierdo() != null && nivelActual < max) {
				listarEntreNivelesAux(lista, nodo.getHijoIzquierdo(), nivelActual + 1, min, max);
			}

			// Visita n
			if (nivelActual >= min) {
				lista.insertar(nodo.getElem(), lista.longitud() + 1);
			}

			// Revisamos los hermanos sin condición porque ya sabemos que estamos en un
			// nivel aceptado
			if (nodo.getHermanoDerecho() != null) {
				listarEntreNivelesAux(lista, nodo.getHermanoDerecho(), nivelActual, min, max);
			}
		}
	}

	public boolean verificarCamino(Lista lista) {
		return verificarCaminoAux(this.raiz, lista);
	}

	private boolean verificarCaminoAux(NodoGen nodo, Lista lista) {
		boolean tieneCamino = false;

		if (nodo != null) {
			if (nodo.getElem().equals(lista.recuperar(1))) {
				lista.eliminar(1);
				if (lista.esVacia()) {
					tieneCamino = true;
				} else {
					tieneCamino = verificarCaminoAux(nodo.getHijoIzquierdo(), lista);
				}
			} else {
				tieneCamino = verificarCaminoAux(nodo.getHermanoDerecho(), lista);
			}
		}

		return tieneCamino;
	}

	public void eliminar(Object buscado) {

		if (this.raiz.getElem().equals(buscado)) {
			this.raiz = null;
		} else {
			eliminarAux(this.raiz, raiz.getHijoIzquierdo(), raiz.getHijoIzquierdo(), buscado);
		}

	}

	public boolean eliminarAux(NodoGen padre, NodoGen actual, NodoGen anterior, Object buscado) {
		// El anterior se utiliza para enlazar en caso de que sea intermedio
		boolean exito = false;

		if (actual != null) {
			// Visita n
			if (actual.getElem().equals(buscado)) {
				if (actual == anterior) {
					// Es hijo izquierdo
					padre.setHijoIzquierdo(actual.getHermanoDerecho());
				} else {
					// Es hijo intermedio u hoja
					anterior.setHermanoDerecho(actual.getHermanoDerecho());
				}
				exito = true;
			} else {
				// Buscamos del lado izquierdo
				exito = eliminarAux(actual, actual.getHijoIzquierdo(), actual.getHijoIzquierdo(), buscado);
				// Buscamos en los hermanos con el mismo padre
				if (!exito) {
					exito = eliminarAux(padre, actual.getHermanoDerecho(), actual, buscado);
				}
			}
		}

		return exito;
	}

	public boolean esHermanoAnterior(Object a, Object b) {
		boolean anterior = false;
		if (!this.esVacio()) {
			anterior = esAnteriorAux(this.raiz.getHijoIzquierdo(), false, a, b);
		}
		return anterior;
	}

	private boolean esAnteriorAux(NodoGen nodo, boolean anterior, Object a, Object b) {
		boolean resultado = false;
		if (nodo != null) {
			if (nodo.getElem().equals(b) && anterior) {
				resultado = true;
			} else {
				if (nodo.getElem().equals(a)) {
					anterior = true;
				}
				resultado = esAnteriorAux(nodo.getHermanoDerecho(), anterior, a, b);
				if (!resultado) {
					resultado = esAnteriorAux(nodo.getHijoIzquierdo(), false, a, b);
				}
			}
		}
		return resultado;
	}

	// Testing
	@Override
	public String toString() {
		return toStringAux(this.raiz);
	}

	private String toStringAux(NodoGen n) {
		String salida = "";

		if (n != null) {
			// Visita n
			salida += n.getElem().toString() + " -> ";
			NodoGen hijo = n.getHijoIzquierdo();
			while (hijo != null) {
				salida += hijo.getElem().toString() + ", ";
				hijo = hijo.getHermanoDerecho();
			}
			/*
			 * Recorre hijos de n recursivamente para que agregen su subcadena a la original
			 */
			hijo = n.getHijoIzquierdo();
			while (hijo != null) {
				salida += "\n" + toStringAux(hijo);
				hijo = hijo.getHermanoDerecho();
			}
		}

		return salida;
	}

}
