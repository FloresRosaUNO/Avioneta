
public class TesEstacionamiento {
	public static void main(String[] args) {

		Estacionamiento palomar = new Estacionamiento();
		palomar.pista.offer("A1");
		palomar.pista.offer("A2");
		palomar.pista.offer("A3");
		palomar.pista.offer("A4");
		palomar.pista.offer("A5");
		palomar.pista.offer("A6");
		palomar.pista.offer("A7");
		palomar.pista.offer("A8");
		palomar.pista.offer("A9");
		palomar.pista.offer("A10");
		Menu sist = new Menu();
		sist.menu(palomar);
//palomar.salida("A3");
		
	}

}

