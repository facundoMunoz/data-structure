package test.jerarquicas;

import jerarquicas.ArbolGen;

public class TestGen2 {

	static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
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
				ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Generico                        *");
		System.out.println(ANSI_CYAN_BACKGROUND + ROJO
				+ "**************************************************************" + "\n\n" + RESET);

		ArbolGen a = new ArbolGen();
		ArbolGen b = new ArbolGen();

		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "--------------------------------------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n");

		System.out.println("********************************");
		System.out.println("*      Insercion basica        *");
		System.out.println("********************************");

		System.out.println("Checkeo si es vacio " + ((a.esVacio()) ? sOk : sErr));
		System.out.println("Intento vaciar arbol vacio ");
		a.vaciar();
		System.out.println("Altura de arbol vacio:  " + a.altura());
		System.out.println("Busco elemento inexistente en arbol vacio con pertenece." + "Tiene que dar " + sOk
				+ " ---> " + ((!b.pertenece(20)) ? sOk : sErr));

		System.out.println("Inserto el 10 en raiz " + ((a.insertar(10, 1)) ? sOk : sErr));
		System.out.println("\n toString()  deberia dar:\n" + "\n        10" + "\n");
		System.out.println(a.toString());
		System.out.println("");

		System.out.println("Altura de arbol solo con raiz:  " + a.altura());
		System.out.println(
				"Busco el nivel de raiz. Tiene que dar " + sOk + " --> " + (((int) a.nivel(10) == 0) ? sOk : sErr));
		System.out.println("Inserto el 9 como hijo de 10 " + ((a.insertar(9, 10)) ? sOk : sErr));
		System.out.println("\n toString()  deberia dar:\n" + "\n        10 " + "\n    +---+  " + "\n    |      "
				+ "\n    9      " + "\n");
		System.out.println(a.toString());
		System.out.println("");

		System.out.println(
				"Busco el nivel de 9. Tiene que dar " + sOk + " --> " + (((int) a.nivel(9) == 1) ? sOk : sErr));
		System.out.println("Inserto el 7 como hijo de 9 " + ((a.insertar(7, 9)) ? sOk : sErr));
		System.out.println("Inserto el 3 como hijo de 9 " + ((a.insertar(3, 9)) ? sOk : sErr));
		System.out.println("Altura de arbol deberia dar 2:  " + a.altura());
		System.out.println(
				"Busco el nivel de 3. Tiene que dar " + sOk + " --> " + (((int) a.nivel(3) == 2) ? sOk : sErr));
		System.out.println("Inserto el 15 como hijo de 10 " + ((a.insertar(15, 10)) ? sOk : sErr));
		System.out.println("Inserto el 12 como hijo de 15 " + ((a.insertar(12, 15)) ? sOk : sErr));
		System.out.println("Inserto el 20 como hijo de 15 " + ((a.insertar(20, 15)) ? sOk : sErr));
		System.out.println("Inserto el 22 como hijo de 15 " + ((a.insertar(22, 15)) ? sOk : sErr));
		System.out.println("Inserto el 30 como hijo de 15 " + ((a.insertar(30, 15)) ? sOk : sErr));
		System.out.println("Inserto el 40 como hijo de 30 " + ((a.insertar(40, 30)) ? sOk : sErr));
		System.out.println("Inserto el 45 como hijo de 30 " + ((a.insertar(45, 30)) ? sOk : sErr));
		System.out.println("Inserto el 55 como hijo de 30 " + ((a.insertar(55, 30)) ? sOk : sErr));
		System.out.println("\n toString()  deberia dar: \n" + "\n                                10"
				+ "\n                +---------------+------------+"
				+ "\n                |                            |"
				+ "\n                9                            15"
				+ "\n            +---+---+              +-------+--+---+-------+"
				+ "\n            |       |              |       |      |       |"
				+ "\n            7       3              12     20     22       30"
				+ "\n                    +                                +-----+-----+"
				+ "\n                    |                                |     |     |"
				+ "\n                   10                                40    45    55" + "\n" + a.toString());
		System.out.println("\n");
		System.out.println(
				"Inserto con padre inexistente. Tiene que dar " + sErr + " --> " + ((a.insertar(5, 50)) ? sOk : sErr));
		System.out.println("Inserto elemento duplicado en pos valida. 10 como hijo de 3. Tiene que dar " + sOk + " --> "
				+ ((a.insertar(10, 3)) ? sOk : sErr));
		System.out.println("Checkeo si es vacio. Tiene que dar " + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));
		System.out.println("Altura de arbol deberia dar 3:  " + a.altura());

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "-------------------------------------------------------------------------------------------------------"
				+ "-------------------------------------------------------------------------------------------"
				+ RESET);

		System.out.println("\n\n********************************");
		System.out.println("*      Test de clonado         *");
		System.out.println("********************************\n");

		b = a.clone();
		System.out.println("Altura de arbol clon:  " + b.altura());
		System.out.println("\n CLON toString()  deberia dar: \n" + "\n                                10"
				+ "\n                +---------------+------------+"
				+ "\n                |                            |"
				+ "\n                9                            15"
				+ "\n            +---+---+              +-------+--+---+-------+"
				+ "\n            |       |              |       |      |       |"
				+ "\n            7       3              12     20     22       30"
				+ "\n                    +                                +-----+-----+"
				+ "\n                    |                                |     |     |"
				+ "\n                   10                                40    45    55" + "\n" + b.toString());
		System.out.println("\n");
		System.out.println("Inserto el 25 como hijo de 20 en CLON" + ((b.insertar(25, 20)) ? sOk : sErr));
		System.out.println("Inserto el 27 como hijo de 20 en CLON" + ((b.insertar(27, 20)) ? sOk : sErr));
		System.out.println("Inserto el 35 como hijo de 20 en CLON" + ((b.insertar(35, 20)) ? sOk : sErr));
		System.out.println("\n" + AZUL + "CLON toString() \t\t\n" + b.toString() + "\n\n");
		System.out.println(VERDE + "ORIGINAL toString()\t\t\n " + a.toString() + "\n\n");

		System.out.println("Vacio el CLON");
		b.vaciar();
		System.out.println("Busco al padre 20 en Arbol vacio. Tiene que dar " + sOk + " --> "
				+ ((b.padre(20) == null) ? sOk : sErr));
		System.out.println(
				"Busco a 25 con pertenece. Tiene que dar " + sOk + " ---> " + ((!b.pertenece(20)) ? sOk : sErr));

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n********************************");
		System.out.println("*      Test de Busqueda         *");
		System.out.println("********************************\n");
		System.out.println(
				"Busco al padre de 55. Tiene que dar " + sOk + " --> " + (((int) a.padre(55) == 30) ? sOk : sErr));
		System.out.println(
				"Busco al padre de 20. Tiene que dar " + sOk + " --> " + (((int) a.padre(20) == 15) ? sOk : sErr));
		System.out.println(
				"Busco al padre de raiz. Tiene que dar " + sOk + " --> " + ((a.padre(10) == null) ? sOk : sErr));
		System.out.println("Busco al padre de elemento inexistente. Tiene que dar " + sErr + " --> "
				+ ((a.padre(1011) != null) ? sOk : sErr));
		System.out.println(
				"Busco a raiz con pertenece. Tiene que dar " + sOk + " ---> " + ((a.pertenece(10)) ? sOk : sErr));
		System.out.println(
				"Busco a 55 con pertenece. Tiene que dar " + sOk + " ---> " + ((a.pertenece(55)) ? sOk : sErr));
		System.out
				.println("Busco a 7 con pertenece. Tiene que dar " + sOk + " ---> " + ((a.pertenece(7)) ? sOk : sErr));
		System.out.println("Busco elemento inexistente con pertenece. Tiene que dar " + sOk + " ---> "
				+ ((!a.pertenece(200)) ? sOk : sErr));

		System.out.println("Busco ancentros de raiz deberia dar vacio: " + a.ancestros(10).toString());
		System.out.println("Busco ancentros de 3 deberia dar 9 - 10 : " + a.ancestros(3).toString());
		System.out.println("Busco ancentros de 40 deberia dar  30 - 15 - 10  : " + a.ancestros(40).toString());
		System.out
				.println("Busco ancentros de elemento inexistente deberia dar vacio: " + a.ancestros(3333).toString());

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n**********************************");
		System.out.println("*        Test de Niveles         *");
		System.out.println("**********************************\n");

		System.out.println(
				"Busco el nivel de raiz. Tiene que dar 0: " + sOk + " --> " + (((int) a.nivel(10) == 0) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 3. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(3) == 2) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 20. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(20) == 2) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 9. Tiene que dar 1: " + sOk + " --> " + (((int) a.nivel(9) == 1) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 22. Tiene que dar 2: " + sOk + " --> " + (((int) a.nivel(22) == 2) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 45. Tiene que dar 3: " + sOk + " --> " + (((int) a.nivel(45) == 3) ? sOk : sErr));
		System.out.println(
				"Busco el nivel 55. Tiene que dar 3: " + sOk + " --> " + (((int) a.nivel(55) == 3) ? sOk : sErr));

		System.out.println("Busco nivel de elemento inexistente: Tiene que dar -1: " + a.nivel(1000));

		System.out.println("\n\n");
		System.out.println(ANSI_YELLOW_BACKGROUND
				+ "----------------------------------------------------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------" + RESET);
		System.out.println("\n\n**********************************");
		System.out.println("*      Test de Recorridos        *");
		System.out.println("**********************************\n");

		System.out.println("\n toString()  deberia dar: \n" + "\n                                10"
				+ "\n                +---------------+------------+"
				+ "\n                |                            |"
				+ "\n                9                            15"
				+ "\n            +---+---+              +-------+--+---+-------+"
				+ "\n            |       |              |       |      |       |"
				+ "\n            7       3              12     20     22       30"
				+ "\n                    +                                +-----+-----+"
				+ "\n                    |                                |     |     |"
				+ "\n                   10                                40    45    55" + "\n" + a.toString());
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Recorrido en preOrden.\n Tiene que dar: "
				+ "\n OP1 (si inserta al final)  [ 10 - 9 - 7 - 3 - 10 - 15 - 12 - 20 - 22 - 30 - 40 - 45 - 55]"
				+ "\n OP2 (si inserta al ppio)   [ 10 - 15 - 30 - 55 - 45 - 40 - 22 - 20 - 12 - 9 - 3 - 10 - 7]"
				+ "\n --> " + a.listarPreorden().toString());
		System.out.println("\n");
		System.out.println("Recorrido en posOrden.\n Tiene que dar: "
				+ "\n OP1 (si inserta al final)  [ 7 - 10 - 3 - 9 - 12 - 20 - 22 - 40 - 45 - 55 - 30 - 15 - 10]  "
				+ "\n OP2 (si inserta al ppio)   [ 55 - 45 - 40 - 30 - 22 - 20 - 12 - 15 - 10 - 3 - 7 - 9 - 10]  "
				+ "\n --> " + a.listarPosorden().toString());
		System.out.println("\n");
		System.out.println("Recorrido en InOrden.\n Tiene que dar: "
				+ "\n OP1 (si inserta al final)  [ 7 - 9 - 10 - 3 - 10 - 12 - 15 - 20 - 22 - 40 - 30 - 45 - 55]  "
				+ "\n OP2 (si inserta al ppio)   [ 55 - 30 - 45 - 40 - 15 - 22 - 20 - 12 - 10 - 10 - 3 - 9 - 7]  "
				+ "\n --> " + a.listarInorden().toString());
		System.out.println("\n");
		System.out.println("Recorrido por Niveles.\n Tiene que dar: "
				+ "\n OP1 (si inserta al final)  [ 10 - 9 - 15 - 7 - 3 - 12 - 20 - 22 - 30 - 10 - 40 - 45 - 55]  "
				+ "\n OP2 (si inserta al ppio)   [ 10 - 15 - 9 - 30 - 22 - 20 - 12 - 3 - 7 - 55 - 45 - 40 - 10]  "
				+ "\n --> " + a.listarPorNiveles().toString());
		System.out.println("\n");
		System.out.println("Pruebas de métodos GRADO");
		System.out.println("------------------------");
		ArbolGen vacio = new ArbolGen();
		System.out.println(
				"Grado de árbol completo: Tiene que dar 4: " + sOk + " --> " + (((int) a.grado() == 4) ? sOk : sErr));
		System.out.println("Grado de subarbol con raiz 9: Tiene que dar 2: " + sOk + " --> "
				+ (((int) a.gradoSubarbol(9) == 2) ? sOk : sErr));
		System.out.println("Grado de subarbol con raiz 15: Tiene que dar 4: " + sOk + " --> "
				+ (((int) a.gradoSubarbol(15) == 4) ? sOk : sErr));
		System.out.println("Grado de subarbol con raiz 30: Tiene que dar 3: " + sOk + " --> "
				+ (((int) a.gradoSubarbol(30) == 3) ? sOk : sErr));
		System.out.println("Grado de subarbol con raiz 45: Tiene que dar 0: " + sOk + " --> "
				+ (((int) a.gradoSubarbol(45) == 0) ? sOk : sErr));
		System.out.println("Grado de subarbol con raiz inexistente 90: Tiene que dar -1: " + sOk + " --> "
				+ (((int) a.gradoSubarbol(90) == -1) ? sOk : sErr));
		System.out.println("Grado de árbol vacío: Tiene que dar -1: " + sOk + " --> "
				+ (((int) vacio.grado() == -1) ? sOk : sErr));
	}

}
