import java.util.Scanner;
//El programa para emular este estacionamiento tiene como entrada un carácter que indica una acción 
//sobre la avioneta , y la matrícula de la avioneta. La acción puede ser llegada (E) o salida (S) 
//de avioneta. En la llegada puede ocurrir que el estacionamiento esté lleno; si es así, la avioneta 
//espera hasta que se quede una plaza libre, o hasta que se de la orden de retirada (salida).
public class Menu {
public void menu(Estacionamiento a) {
	Scanner Teclado = new Scanner(System.in);
	int opc, x;
	do
	{
	do
	{
	System.out.println("MENU DE OPERACIONES BIBLIOTECA");
	System.out.println("1 - Dar entrada o salida a avioneta") ;
	System.out.println("2 - Ver avionetas estacionadas") ;
	System.out.println("3 - Ver avionetas en espera") ;
	
	System.out.println("4 - Salir") ;
	System.out.println("Ingrese una opcion: ");
	opc=Teclado.nextInt();
	if(opc==4)
	{
	System.out.println("Fin Programa");
	}

	} while(opc < 1 && opc > 3);
	switch (opc)
	{
	case 1:
	operarEstacionamiento(a);
	seguir(Teclado);
	break;
	case 2:
	mostrarPista(a);
	seguir(Teclado);
	break;
	case 3:
	mostrarEspera(a);
	seguir(Teclado);
	break;
	
	}
	}while (opc != 4);
	}

static void seguir(Scanner Teclado)
{
int x;
System.out.print("\nPara volver a menu apriete cualquier numero ");

x=Teclado.nextInt();
}	
public void operarEstacionamiento(Estacionamiento a) {
	Scanner teclado = new Scanner(System.in);
	String accion;
	String mat;
	System.out.println("Indique la accion que desea realizar ");
	System.out.println("la letra E para llegada o S para salida: ");
	accion= teclado.nextLine();
	System.out.println("Ingrese la matricula de la avioneta: ");
	mat=teclado.nextLine();
	switch (accion)
	{
	case "E":
		a.llegada(mat);
	break;
	case "e":
		a.llegada(mat);
	break;
	case "S":
		a.salida(mat);
	break;
	case "s":
		a.salida(mat);
		break;
	
	}
	
		
	}
public void mostrarPista(Estacionamiento a) {
	System.out.println("Estacionamiento\n"+a.pista);
}
public void mostrarEspera(Estacionamiento a) {
	System.out.println("Avionetas en espera:\n"+a.espera);
}



}// fin menu