	import java.util.Queue;
	import java.util.LinkedList;
public class Estacionamiento {
	public int conta=0;
	public int bandera=1;
	public int cant = 0;
	public Queue<String> pista;
	public Queue<String> auxiliar;
	public Queue<String> espera;
	 
	 public void llegada(String avioneta) {
		 if (pista.size()<12) {
			 pista.offer(avioneta);
			 System.out.println("SE HA INGRESADO LA AVIONETA AL ESTACIONAMIENTO: "+avioneta);
		 }
		 else {
			 espera.offer(avioneta);
			 System.out.println("El estacionamiento se encuentra completo.");
			 System.out.println("La avineta "+avioneta+" permanecera en espera. Con "+(espera.size()-1)+" avionetas por delante para ingresar al estacionamiento.");
		 }
	 }
	 
	 public void salida(String a) {
		 System.out.println("vamos a dar salida a la avineta : "+a);
		 this.buscar(a);
		 this.reconstruirPista();
		 
	 }
	 public void mover(Queue a,Queue b) {
		 b.offer(a.peek()); // agrega a b el frente de a
		 a.poll(); // quita el frente de a
	 }
	
	 public void buscar(String a) {

		 if(bandera==1) { // bandera para guardar size inicial de pista
			 cant=pista.size();
			 bandera=0;
			 }	
		 if(a.equals(pista.peek())) { //si frente de pista es a
			 pista.poll();
			 System.out.println("se dio salida a la avioneta: "+a);
			 if(pista.size()<12) { //si pista menos de 12
				 System.out.println("Se dejo un estacionamiento libre");
				 while(pista.size()<12 && espera.peek()!=null) {//mientras pista menor a 12
					 this.llegada((String) espera.peek());//agrego frente de espera a pista
					 espera.poll();
					 if(pista.size()==12) {
						 break;
					 }
				 }
			 }
			 if(pista.isEmpty()==false) {//si pista no esta vacio
				 this.mover(pista,auxiliar);// pasar frente de pista a auxiliar
				 this.buscar(a);
			 }				 
		 }		 
		 else if(pista.isEmpty()==false && pista.peek()!=a){ //si frente de pista es distinto a 'a'
		 		conta++;
				this.mover(pista,auxiliar);
				if(cant==conta){// si cant size inicial de pista = cant de veces que frente distinto a 'a'
					System.out.println("No hay avioneta estacionada con esa matricula"); 
					
				}
				this.buscar(a);
		 }	 	 
	 }
	 public void reconstruirPista() {
		 if(bandera==0) {// inicializa nuevamente bandera
			 conta=0;
			 bandera=1;
		 }
		 if(auxiliar.isEmpty()==false && auxiliar.peek()!=null) {
			 this.mover(auxiliar,pista);
			 this.reconstruirPista();
		 }

	 }
	 
	 public Estacionamiento() {
		 Queue<String> pista = new LinkedList();
		 Queue<String> auxiliar = new LinkedList();
		 Queue<String> espera = new LinkedList();

		 this.pista=pista;
		 this.espera=espera;
		 this.auxiliar=auxiliar;
		 System.out.print("se creo correctamete el aerodromo");
	 }
	
}
