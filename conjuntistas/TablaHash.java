package conjuntistas;

public class TablaHash {
	// Implementación abierta de tabla Hash

	private static final int TAMANIO = 100;
	private Nodo[] hash;
	private int cant;

	public TablaHash() {
		this.hash = new Nodo[TAMANIO];
		this.cant = 0;
	}

	public boolean pertenece(Object buscado) {
		int pos = buscado.hashCode() % TablaHash.TAMANIO;
		Nodo aux = this.hash[pos];
		boolean encontrado = false;

		while (!encontrado && aux != null) {
			encontrado = aux.getElem().equals(buscado);
			aux = aux.getEnlace();
		}

		return encontrado;
	}

	public boolean insertar(Object nuevo) {
		int pos = nuevo.hashCode() % TablaHash.TAMANIO;
		Nodo aux = this.hash[pos];
		boolean encontrado = false;

		while (!encontrado && aux != null) {
			encontrado = aux.getElem().equals(nuevo);
			aux = aux.getEnlace();
		}

		// Si no está en la lista lo pone delante
		if (!encontrado) {
			this.hash[pos] = new Nodo(nuevo, this.hash[pos]);
			this.cant++;
		}

		return !encontrado;
	}

	public boolean eliminar(Object buscado) {
		int pos = buscado.hashCode() % TablaHash.TAMANIO;
		Nodo predecesor = this.hash[pos];
		boolean encontrado = false;

		while (!encontrado && predecesor.getEnlace() != null) {
			encontrado = predecesor.getEnlace().getElem().equals(buscado);
			predecesor = predecesor.getEnlace();
		}

		if (!encontrado) {
			this.hash[pos] = this.hash[pos].getEnlace();
			this.cant--;
		}

		return !encontrado;
	}

	public boolean esVacia() {
		return (this.cant == 0);
	}

	@Override
	public String toString() {
		String texto = "";
		int pos = 0;

		while (pos < TAMANIO) {
			Nodo nodo = hash[pos];
			while (nodo != null) {
				texto = texto + nodo.getElem() + ", ";
				nodo = nodo.getEnlace();
			}
			pos++;
		}

		return texto;
	}

}
