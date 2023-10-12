import java.util.Queue;
import java.util.LinkedList;
public class Aerodromo {
 public Queue<String> pista;
 public Queue<String> auxiliar;
 public Queue<String> espera;
 
 public void llegada(String avioneta) {
	 if (pista.size()<3) {
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
	while(pista.peek()!=a) {//mientra frente no es a
		 auxiliar.offer(pista.peek());// agregar a auxiliar frete de pista
		 pista.poll();// borrar frente de pista
			
		if(pista.peek()==a) { //si frente de pista es a
				
			pista.poll();//quitar a de pista
			System.out.println("se dio salida a "+a);
					
		if(pista.isEmpty()==false) {//SI PISTA no ESTA VACIO
			while(pista.isEmpty()==false) {//mientras pista no este vacio
				auxiliar.offer(pista.peek());// agregar a auxiliar frete de pista
				pista.poll();// borrar frente de pista
				if(pista.isEmpty()==true) {
				break;
					}
			}
			
		}
		break;}
	}
		if(auxiliar.isEmpty()==false) {//si auxiliar no esta vacio
			while(auxiliar.isEmpty()==false) { //mientras auxiliar no esta vacio
		
			pista.offer(auxiliar.peek()); //agregar a pista frente de auxiliar
			auxiliar.poll();// quitar frente de auxiliar
						
			if(auxiliar.isEmpty()==true) {// si auxiliar esta vacio
				break;}	//cerrar el mientras	
		}
		}
		if(pista.size()<3) {	//si pista menos de 3
			System.out.println("Se dejo un estacionamiento libre");
		while(pista.size()<3) {//mientras pista menor a 3
			this.llegada((String) espera.peek());//agrego frente de espera a pista
			espera.poll();
			
			if(pista.size()==3) {
				break;
			}
		}
		}
 }
			
 
 public Aerodromo() {
	 Queue<String> pista = new LinkedList();
	 Queue<String> auxiliar = new LinkedList();
	 Queue<String> espera = new LinkedList();

	 this.pista=pista;
	 this.espera=espera;
	 this.auxiliar=auxiliar;
	 System.out.print("se creo correctamete el aerodromo");
 }
	public static void main(String[] args) {

		Aerodromo palomar = new Aerodromo();
		
		//System.out.println(""+palomar.pista);
		palomar.llegada("aaa");
		System.out.println("pista: "+palomar.pista);
		palomar.llegada("bbb");
		palomar.llegada("ccc");
		palomar.llegada("ddd");
		palomar.salida("ccc");
		palomar.salida("bbb");
		palomar.llegada("xxx");
		palomar.llegada("yyy");
	}

}
