package ProyectoPizzeria;

import java.util.Scanner;

public class main {
	
	static private Scanner input=new Scanner(System.in);
	static private double totalPedidos = 0.0;
	static private boolean salir=false;
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido!!");
		
//		Hacemos los pedidos de las pizzas
		do {
			GestionPizzas pizzas = new GestionPizzas();
			totalPedidos += pizzas.calcularPrecio();
			System.out.println("Desea crear otra comanda? S/N");
			if(input.next().toUpperCase().charAt(0)=='N') {
				salir=true;
			}
		}while(!salir);
		
		System.out.println("Hoy se han facturado: " + totalPedidos + "€");
		
	}
}