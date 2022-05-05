package test.conjuntistas;

import conjuntistas.ArbolBB;

public class TestingArbolBB {

	static String sOk = "OK!", sErr = "ERROR";

	public static void main(String[] args) {
		// uno de los arboles va a ordenar letras(1) y el otro numeros(2)
		ArbolBB A1 = new ArbolBB();
		ArbolBB A2 = new ArbolBB();
		// probamos los metodos de insercion
		System.out.println("metodos de insercion:");
		System.out.println("Arbol A1 letras:");
		System.out.println("Insertamos G espera OK!:\t\t\t" + (A1.insertar('G') ? sOk : sErr));
		System.out.println("Insertamos C espera OK!:\t\t\t" + (A1.insertar('C') ? sOk : sErr));
		System.out.println("Insertamos I espera OK!:\t\t\t" + (A1.insertar('I') ? sOk : sErr));
		System.out.println("Insertamos A espera OK!:\t\t\t" + (A1.insertar('A') ? sOk : sErr));
		System.out.println("Insertamos D espera OK!:\t\t\t" + (A1.insertar('D') ? sOk : sErr));
		System.out.println("Insertamos H espera OK!:\t\t\t" + (A1.insertar('H') ? sOk : sErr));
		System.out.println("Insertamos J espera OK!:\t\t\t" + (A1.insertar('J') ? sOk : sErr));
		System.out.println("Insertamos B espera OK!:\t\t\t" + (A1.insertar('B') ? sOk : sErr));
		System.out.println("Insertamos F espera OK!:\t\t\t" + (A1.insertar('F') ? sOk : sErr));
		System.out.println("Insertamos K espera OK!:\t\t\t" + (A1.insertar('K') ? sOk : sErr));
		System.out.println("Insertamos F espera ERROR:\t\t\t" + (A1.insertar('F') ? sOk : sErr));
		System.out.println("Insertamos B espera ERROR!:\t\t\t" + (A1.insertar('B') ? sOk : sErr));
		System.out.println("Insertamos J espera ERROR!:\t\t\t" + (A1.insertar('J') ? sOk : sErr));
		System.out.println("--------------------------------------");
		System.out.println("Arbol A2 numeros");
		for (int i = 10; i < 15; i++) {
			System.out.println("Insertamos " + i + " espera OK!:\t\t\t" + (A2.insertar(i) ? sOk : sErr));
			System.out.println("Insertamos " + i * 2 + " espera OK!:\t\t\t" + (A2.insertar(i * 2) ? sOk : sErr));
		}
		for (int j = 9; j > 6; j--) {
			System.out.println("Insertamos " + j + " espera OK!:\t\t\t" + (A2.insertar(j) ? sOk : sErr));
			System.out.println("Insertamos " + j * 2 + " espera OK!:\t\t\t" + (A2.insertar(j * 2 + 1) ? sOk : sErr));
		}
		// metodos toString
		System.out.println("--------------------------------------");
		System.out.println("Metodos ToString:");
		System.out.println("A1 toString: ");
		System.out.println(A1.toString());
		System.out.println("A2 toString:");
		System.out.println(A2.toString());

		// pertenece
		System.out.println("--------------------------------------");
		System.out.println("Metodo pertenece:");
		System.out.println("Pertenece F al Arbol espera OK!:\t\t" + (A1.pertenece('F') ? sOk : sErr));
		System.out.println("Pertenece B al Arbol espera OK!:\t\t" + (A1.pertenece('B') ? sOk : sErr));
		System.out.println("Pertenece J al Arbol espera OK!:\t\t" + (A1.pertenece('J') ? sOk : sErr));
		System.out.println("Pertenece L al Arbol espera ERROR:\t\t" + (A1.pertenece('L') ? sOk : sErr));
		System.out.println("Pertenece Z al Arbol espera ERROR:\t\t" + (A1.pertenece('Z') ? sOk : sErr));
		System.out.println("Pertenece E al Arbol espera ERROR:\t\t" + (A1.pertenece('E') ? sOk : sErr));

		// metodos listar y listar rango
		System.out.println("--------------------------------------");
		System.out.println("Metodo listar:");
		System.out.println("A1 listado en orden:\t\t\t" + A1.listar().toString());
		System.out.println("A2 listado en orden:\t\t\t" + A2.listar().toString());
		System.out.println("--------------------------------------");
		System.out.println("Metodo listar rango");
		System.out.println("Listado entre B y F :\t\t\t" + A1.listarRango('B', 'F').toString());
		System.out.println("Listado entre F y J :\t\t\t" + A1.listarRango('F', 'J').toString());
		System.out.println("Listado entre G y J :\t\t\t" + A1.listarRango('G', 'J').toString());
		System.out.println("Listado entre A y C :\t\t\t" + A1.listarRango('A', 'C').toString());
		System.out.println("Listado entre F y B espera lista Vacia:\t\t" + A1.listarRango('F', 'B').toString());

		// metodos maximo y minimo elemento
		System.out.println("--------------------------------------");
		System.out.println("Maximo Elemento:");
		Comparable maxElemento = A1.maximo();
		System.out.println("Maximo Elemento A1: " + maxElemento.toString());
		System.out.println("Maximo Elemento A2: " + A2.maximo().toString());
		System.out.println("Minimo Elemento: ");
		Comparable minElemento = A1.minimoElem();
		System.out.println("Minimo Elemento A1: " + minElemento.toString());
		System.out.println("Minimo Elemento A2: " + A2.minimoElem().toString());
		// clonamos
		System.out.println("--------------------------------------");
		System.out.println("Clonamos A1 y A2");
		ArbolBB A1clone = A1.clone();
		ArbolBB A2clone = A2.clone();
		System.out.println("A1clone toString: ");
		System.out.println(A1clone.toString());
		System.out.println("A2clone toString: ");
		System.out.println(A2clone.toString());
		// vaciamos
		System.out.println("--------------------------------------");
		System.out.println("Vaciamos el clon de A2");
		A2clone.vaciar();
		System.out.println("A2clone toString ");
		System.out.println(A2clone.toString());
		// probamos esVacio
		System.out.println("Consultamos si A1 esta vacio espera ERROR: " + (A1.vacio() ? sOk : sErr));
		System.out.println("Consultamos si A2clone esta vacio espera OK!: " + (A2clone.vacio() ? sOk : sErr));

		// eliminamos
		System.out.println("--------------------------------------");
		System.out.println("Probamos el metodo Eliminar sobre A1clone");
		System.out.println(
				"Como raiz tiene 2 hijo y ademas tiene la condicion de sera riaz \n vamos a eliminar para realizar el test");
		System.out.println("Eliminamos la raiz G de A1clone espera OK!: \t" + (A1clone.eliminar('G') ? sOk : sErr));
		System.out.println("A1clone toString : \n" + A1clone.toString());
		System.out.println("Lista: " + A1clone.listar().toString());
		System.out.println("Probamos eliminar el maximo elemento y que ademas no tiene hijos");
		System.out.println("Eliminamos el maximo elemento obtenido anteriormente espera OK!: \t"
				+ (A1clone.eliminar(maxElemento) ? sOk : sErr));
		System.out.println("A1clone toString : \n" + A1clone.toString());
		System.out.println("Lista: " + A1clone.listar().toString());
		System.out.println("Probamos eliminar el minimo elemento y ademas que tiene un hijo derecho");
		System.out.println("Eliminamos el minimo elemento obtenido anteriormente espera OK!: \t"
				+ (A1clone.eliminar(minElemento) ? sOk : sErr));
		System.out.println("A1clone toString : \n" + A1clone.toString());
		System.out.println("Lista: " + A1clone.listar().toString());
		System.out.println("Probemos eliminar a C que tien un hijo izquierdo");
		System.out.println("Eliminamos C espera OK!: \t" + (A1clone.eliminar('C') ? sOk : sErr));
		System.out.println("A1clone toString : \n" + A1clone.toString());
		System.out.println("Lista: " + A1clone.listar().toString());
	}
}
