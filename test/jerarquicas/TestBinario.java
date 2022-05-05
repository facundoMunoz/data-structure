package test.jerarquicas;

import jerarquicas.ArbolBin;

public class TestBinario {

	static String sOk = "\u001B[32m OK! \u001B[0m";
	static String sErr = " \u001B[31m ERROR \u001B[0m";
	public static final String NEGRO = "\u001B[30m";
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String BLANCO = "\u001B[37m";

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static final String RESET = "\u001B[0m";

	public static void main(String args[]) {

		System.out.println(
				ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************");
		System.out.println(
				ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Binario                        *");
		System.out.println(ANSI_CYAN_BACKGROUND + ROJO
				+ "**************************************************************" + "\n\n" + RESET);

		ArbolBin a = new ArbolBin();
		ArbolBin b = new ArbolBin();

		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "--------------------------------------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n");

		System.out.println("****************************************");
		System.out.println("*      Pruebas sobre arbol vacio       *");
		System.out.println("****************************************");
		System.out.println("Checkeo si es vacio " + ((a.esVacio()) ? sOk : sErr));
		System.out.println("Listar preorden vacio: " + a.listarPreorden().toString());
		System.out.println("Listar inorden vacio: " + a.listarInorden().toString());
		System.out.println("Listar posorden vacio: " + a.listarPosorden().toString());
		System.out.println("Listar por niveles vacio: " + a.listarPorNiveles().toString());
		System.out.println("Altura de arbol vacio (debe dar -1):  " + a.altura());
		System.out.println("Intento vaciar arbol vacio ");
		a.vaciar();
		System.out.println("Intento obtener padre de un elemento cualquiera (debe dar null): "
				+ ((a.padre(10)) == null ? sOk : sErr));
		System.out.println(
				"Intento obtener nivel de un elemento cualquiera (debe dar -1): " + ((a.nivel(10)) == -1 ? sOk : sErr));
		System.out.println("toString de arbol vacío: " + a.toString());
		System.out.println();
		System.out.println();

		System.out.println("****************************************");
		System.out.println("*          Insercion - altura          *");
		System.out.println("****************************************");
		System.out.println("Inserto el 10 en raiz " + ((a.insertar(10, 1, 'I')) ? sOk : sErr));
		System.out.println("Altura de arbol solo con raiz (debe dar 0):  " + a.altura());
		System.out.println(
				"Busco el nivel de raiz. Tiene que dar 0: " + sOk + " --> " + (((int) a.nivel(10) == 0) ? sOk : sErr));
		System.out.println("");
		System.out.println("Inserto el 9 como hijo I de 10: " + ((a.insertar(9, 10, 'I')) ? sOk : sErr));
		System.out.println(
				"Busco el nivel de 9. Tiene que dar 1: " + sOk + " --> " + (((int) a.nivel(9) == 1) ? sOk : sErr));
		System.out.println("Inserto el 7 como hijo I de 9 " + ((a.insertar(7, 9, 'I')) ? sOk : sErr));
		System.out.println("Inserto el 3 como hijo D de 9 " + ((a.insertar(3, 9, 'D')) ? sOk : sErr));
		System.out.println("Altura de arbol deberia dar 2:  " + a.altura());
		System.out.println(
				"Busco el nivel de 3. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(3) == 2) ? sOk : sErr));
		System.out.println("Inserto el 15 como hijo D de 10 " + ((a.insertar(15, 10, 'D')) ? sOk : sErr));
		System.out.println("Inserto el 12 como hijo I de 15 " + ((a.insertar(12, 15, 'I')) ? sOk : sErr));
		System.out.println("Inserto el 20 como hijo D de 15 " + ((a.insertar(20, 15, 'D')) ? sOk : sErr));
		System.out.println("\n toString()  deberia dar: \n" + "            10 \n" + "        /       \\    \n"
				+ "      9           15  \n" + "   /     \\      /    \\ \n" + " 7         3   12      20 \n" + "\n");
		System.out.println("" + a.toString() + "\n\n");

		System.out.println("\n");
		System.out.println("Inserto con padre inexistente. Tiene que dar: " + sErr + " --> "
				+ ((a.insertar(5, 50, 'I')) ? sOk : sErr));
		System.out.println("Inserto sin caracter válido de hijo. Tiene que dar:" + sErr + " --> "
				+ ((a.insertar(5, 3, ' ')) ? sOk : sErr));
		System.out.println("Inserto hijo I a raiz en pos llena. Tiene que dar: " + sErr + " --> "
				+ ((a.insertar(5, 10, 'I')) ? sOk : sErr));
		System.out.println("Inserto hijo D a raiz en pos llena. Tiene que dar: " + sErr + " --> "
				+ ((a.insertar(5, 10, 'D')) ? sOk : sErr));
		System.out.println("Inserto elemento duplicado en pos valida 10 como hijo I de 3. Tiene que dar " + sOk
				+ " --> " + ((a.insertar(10, 3, 'I')) ? sOk : sErr));
		System.out.println("Checkeo si arbol es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));

		System.out.println("\n toString() antes de clonar. Deberia dar: \n" + "            10 \n"
				+ "        /       \\    \n" + "      9           15  \n" + "   /     \\      /    \\ \n"
				+ " 7         3   12      20 \n" + "         /  \n" + "        10  \n" + "\n");
		System.out.println("" + a.toString() + "\n\n");
		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "-------------------------------------------------------------------------------------------------------"
				+ "-------------------------------------------------------------------------------------------"
				+ RESET);

		System.out.println("\n\n********************************");
		System.out.println("*      Test de clone           *");
		System.out.println("********************************\n");
		b = a.clone();
		System.out.println("Altura de arbol clon (debe dar 3):  " + b.altura());
		System.out.println("\n clon toString()  deberia dar: \n" + "            10 \n" + "        /       \\    \n"
				+ "      9           15  \n" + "   /     \\      /    \\ \n" + " 7         3   12      20 \n"
				+ "         /  \n" + "        10  \n" + "\n");
		System.out.println("" + b.toString() + "\n\n");

		System.out.println("\n");
		System.out.println("Inserto el 25 como hijo D de 20 en CLON" + ((b.insertar(25, 20, 'D')) ? sOk : sErr));
		System.out.println("Inserto el 35 como hijo I de 20 en CLON" + ((b.insertar(35, 20, 'I')) ? sOk : sErr));
		System.out.println("\n" + AZUL + "CLON toString() \t\t\t");
		System.out.println("\n clon toString()  deberia dar: \n" + "            10 \n" + "        /       \\    \n"
				+ "      9           15  \n" + "   /     \\      /    \\ \n" + " 7         3   12      20 \n"
				+ "         /           /     \\\n" + "        10         35      25 \n" + "\n");
		System.out.println("" + b.toString() + "\n\n");

		System.out.println(VERDE + "ORIGINAL toString() - verifica que tenga igual estructura que antes \t\t\t ");
		System.out.println("\n original toString()  deberia dar: \n" + "            10 \n" + "        /       \\    \n"
				+ "      9           15  \n" + "   /     \\      /    \\ \n" + " 7         3   12      20 \n"
				+ "         /  \n" + "        10  \n" + "\n");
		System.out.println("" + a.toString() + "\n\n");

		System.out.println("Vacio el CLON");
		b.vaciar();
		System.out.println("toString de arbol vacio (CLON)");
		System.out.println("" + b.toString() + "\n\n");
		System.out.println("Busco al padre 20 en Arbol vacio (tiene que dar null): " + sOk + " --> "
				+ ((b.padre(20) == null) ? sOk : sErr));

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n********************************");
		System.out.println("*   Test de Busqueda de Padre  *");
		System.out.println("********************************\n");
		System.out.println(
				"Busco al padre de 3. Tiene que dar 9: " + sOk + " --> " + (((int) a.padre(3) == 9) ? sOk : sErr));
		System.out.println(
				"Busco al padre de 20. Tiene que dar 15: " + sOk + " --> " + (((int) a.padre(20) == 15) ? sOk : sErr));
		System.out.println(
				"Busco al padre de raiz. Tiene que dar null: " + sOk + " --> " + ((a.padre(10) == null) ? sOk : sErr));
		System.out.println("Busco al padre de elemento inexistente. Tiene que dar null: " + sErr + " --> "
				+ ((a.padre(1011) != null) ? sOk : sErr));

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n**********************************");
		System.out.println("*        Test de Niveles         *");
		System.out.println("**********************************\n");
		System.out.println("Busco el nivel de raiz. Tiene que dar 0 -- " + sOk + " --> "
				+ (((int) a.nivel(10) == 0) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 3. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(3) == 2) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 20. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(20) == 2) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 9. Tiene que dar 1: " + sOk + " --> " + (((int) a.nivel(9) == 1) ? sOk : sErr));
		System.out.println("Busco nivel de elemento inexistente. Tiene que dar -1: " + sErr + " --> "
				+ (((int) a.nivel(1000) == -1) ? sErr : sOk));

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n**********************************");
		System.out.println("*      Test de Recorridos        *");
		System.out.println("**********************************\n");
		System.out.println("Listar en preOrden.\n Tiene que dar: [ 10 - 9 - 7 - 3 - 10 - 15 - 12 - 20 ]  "
				+ a.listarPreorden().toString());
		System.out.println("\n");
		System.out.println("Listar en posOrden.\n Tiene que dar: [ 7 - 10 - 3 - 9 - 12 - 20 - 15 - 10 ]  "
				+ a.listarPosorden().toString());
		System.out.println("\n");
		System.out.println("Listar en InOrden.\n Tiene que dar: [ 7 - 9 - 10 - 3 - 10 - 12 - 15 - 20 ]  "
				+ a.listarInorden().toString());
		System.out.println("\n");
		System.out.println("Listar por niveles.\n Tiene que dar: [ 10 - 9 - 15 - 7 - 3 - 12 - 20 - 10 ]  "
				+ a.listarPorNiveles().toString());
		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println();
		System.out.println("\n\n**********************************");
		System.out.println("*      Test de FRONTERA          *");
		System.out.println("**********************************\n");
		System.out.println("Frontera de original.\n Tiene que dar: [ 7 - 10 - 12 - 20 ]  " + a.frontera().toString());
		System.out.println("");
		System.out.println("Inserto el 40 como hijo D de 12 " + ((a.insertar(40, 12, 'D')) ? sOk : sErr));
		System.out.println("");
		System.out.println(
				"Frontera de original modificado.\n Tiene que dar: [ 7 - 10 - 40 - 20 ]  " + a.frontera().toString());
		System.out.println("");
		System.out.println("Frontera de clon que está vacio.\n Tiene que dar: [ ]  " + b.frontera().toString());
		System.out.println("");
		System.out.println("Inserto el 50 en el clon " + ((b.insertar(50, null, 'D')) ? sOk : sErr));
		System.out.println("");
		System.out.println("Frontera de clon con solo raiz.\n Tiene que dar: [ 50 ]  " + b.frontera().toString());
	}

}
