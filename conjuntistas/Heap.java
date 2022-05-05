package conjuntistas;

public class Heap {

	// Atributos
	private static final int TAMANIO = 10;
	private Comparable[] heap;
	private int ultimo;

	// Constructor
	public Heap() {
		heap = new Comparable[TAMANIO];
		ultimo = 0;
	}

	// Modificadores
	public boolean insertar(Comparable nuevo) {
		boolean exito = false;

		if (this.ultimo + 1 < this.heap.length) {
			exito = true;
			this.ultimo++;
			this.heap[this.ultimo] = nuevo;
			subir(this.ultimo);
		}

		return exito;
	}

	private void subir(int posHijo) {
		int posPadre;
		Comparable temp = this.heap[posHijo];
		boolean exito = true;
		while (exito) {
			posPadre = posHijo / 2;
			if (posPadre >= 1) {
				if (this.heap[posPadre].compareTo(temp) > 0) {
					// Intercambio
					this.heap[posHijo] = this.heap[posPadre];
					this.heap[posPadre] = temp;
					posHijo = posPadre;
				} else {
					exito = false;
				}
			} else {
				exito = false;
			}
		}
	}

	public boolean eliminarCima() {
		boolean exito;

		if (this.esVacio()) {
			exito = false;
		} else {
			this.heap[1] = this.heap[ultimo];
			this.heap[ultimo] = null;
			this.ultimo--;

			hacerBajar(1);
			exito = true;
		}

		return exito;
	}

	private void hacerBajar(int posPadre) {
		int hijoIzq;
		Comparable temp = this.heap[posPadre];
		boolean exito = true;
		while (exito) {
			hijoIzq = posPadre * 2;
			if (hijoIzq <= this.ultimo) {
				if (hijoIzq < this.ultimo) {
					if (this.heap[hijoIzq + 1].compareTo(this.heap[hijoIzq]) < 0) {
						hijoIzq++;
					}
				}

				if (this.heap[hijoIzq].compareTo(temp) < 0) {
					this.heap[posPadre] = this.heap[hijoIzq];
					this.heap[hijoIzq] = temp;
					posPadre = hijoIzq;
				} else {
					exito = false;
				}

			} else {
				exito = false;
			}
		}
	}

// Observadores
	public Object recuperarCima() {
		return this.heap[1];
	}

	public boolean esVacio() {
		return this.ultimo == 0;
	}

	// Propias del tipo
	@Override
	public Heap clone() {
		Heap clon = new Heap();

		// Clonamos el arreglo y ultimo
		clon.heap = this.heap.clone();
		clon.ultimo = this.ultimo;

		return clon;
	}

	@Override
	public String toString() {
		String retorno = "Arbol vacio";

		if (!this.esVacio()) {
			int posicion = 1;
			retorno = "";
			while (posicion <= this.ultimo) {
				retorno += this.heap[posicion] + "-> HI: ";
				if (posicion * 2 <= this.ultimo) {
					retorno += this.heap[posicion * 2];
				} else {
					retorno += "-";
				}
				retorno += " HD: ";
				if (posicion * 2 + 1 <= this.ultimo) {
					retorno += this.heap[posicion * 2 + 1];
				} else {
					retorno += "-";
				}
				retorno += "\n";
				posicion++;
			}
		}

		return retorno;
	}

}