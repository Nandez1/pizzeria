package ProyectoPizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionPizzas {
//	Atributos
	static Scanner input = new Scanner(System.in);
	private ArrayList<Pizza> pizzas = new ArrayList<>();
	
//	Constructor
	public GestionPizzas() {
		boolean salir=false;
		do {
			//Mostramos el menú
			System.out.println("Seleccione una opción: \n"
					+ "1.Añadir pizza \n"
					+ "2.Mostrar todas las pizzas añadidas \n"
					+ "3.Eliminar Pizza \n"
					+ "4.Calcular precio \n"
					+ "5.Pagar ");
			switch(input.nextInt()) {
				case 1:
					Pizza p=new Pizza(seleccionMasa(),seleccionBase(),seleccionIngredientes());
					pizzas.add(p);
					break;
				case 2:
					mostrarPizzas();
					break;
				case 3:
					eliminarPizza();
					break;
				case 4:
					System.out.println("El precio de la comanda es: "+calcularPrecio());
					break;
				case 5:
					salir=true;
					break;
				default:
					System.out.println("ERROR");
			}
		}while(!salir);
	}
	
//	Elegir tamaño de pizza
	public int menuPizza() {
		int opcion=0;
		boolean salir=false;
		do {
			System.out.println("Seleccione una opcion: \n"
					+ "1.Pizza Familiar. 13.95€ (5 Ingredientes) \n"
					+ "2.Pizza Mediana. 9.95€ (3 Ingredientes) \n"
					+ "3.Pizza Individual. 5.95€ (2 Ingredientes) \n");
			switch(input.nextInt()) {
			case 1:
				opcion=5;
				salir=true;
				break;
			case 2:
				opcion=3;
				salir=true;
				break;
			case 3:
				opcion=2;
				salir=true;
				break;
			default:
				System.out.println("ERROR");
			}
		}while(!salir);
		return opcion;
	}
	
//	Elegir ingredientes
	public String[] seleccionIngredientes() {
		int numIngredientes;
		String[] ingredientes=new String[numIngredientes=menuPizza()];
		for(int i=0;i<numIngredientes;i++) {
			System.out.println("Te quedan: "+(numIngredientes-i)+" ingredientes a elegir");
			ingredientes[i]=input.next();
		}
		return ingredientes;
	}
	
//	Elegir base
	public String seleccionBase() {
		boolean salir=false;
		String opcion="";
		do {
			System.out.println("Seleccione una opcion: \n"
					+ "1.Tomate \n"
					+ "2.Carbonara \n"
					+ "3.Barbacoa");
			switch(input.nextInt()) {
				case 1:
					opcion="Tomate";
					salir=true;
					break;
				case 2:
					opcion="Carbonara";
					salir=true;
					break;
				case 3:
					opcion="Barbacoa";
					salir=true;
					break;
				default:
					System.out.println("ERROR");
			}
		}while(!salir);
		return opcion;
	}
	
//	Elegir masa
	public String seleccionMasa() {
		boolean salir=false;
		String opcion="";
		do {
			System.out.println("Seleccione una opcion: \n"
					+ "1.Fina \n"
					+ "2.Clasica \n");
			switch(input.nextInt()) {
				case 1:
					opcion="Fina";
					salir=true;
					break;
				case 2:
					opcion="Clasica";
					salir=true;
					break;
				default:
					System.out.println("ERROR");
			}
		}while(!salir);
		return opcion;
	}
	
//	Listar pizzas encargadas
	public void mostrarPizzas() {
		if (pizzas.size()>0){
			int i=0;
			for(Pizza p: pizzas) {
				System.out.println("Pizza "+(i+1)+": \n"
						+ "Masa: "+p.getMasa()+"\n"
						+ "Base: "+p.getBase());
				mostrarIngredientes(p.getIngredientes());
				i++;
			}
		}else {
			System.out.println("No hay pizzas en este pedido");
		}
	}
	
//	Listar ingredientes
	public void mostrarIngredientes(String [] ingredientes) {
		for(int i=0;i<ingredientes.length;i++) {
			System.out.println("Ingrediente "+(i+1)+": "+ingredientes[i]);
		}
	}
	
//	Calcular precio de la comanda
	public double calcularPrecio() {
		double precio=0.0;
		for(Pizza p: pizzas) {
			switch (p.getIngredientes().length) {
				case 2:
					precio+=5.95;
					break;
				case 3:
					precio+=9.95;
					break;
				case 5:
					precio+=13.95;
					break;
			}
		}
		return precio;
	}
	
//	Eliminar pizza de la comanda
	public void eliminarPizza () {
		int opcionEliminar = -1;
		
		if (pizzas.size()>0) {
			do {
				opcionEliminar = -1;
				mostrarPizzas();
				
				while(opcionEliminar < 0 || opcionEliminar > pizzas.size() ) {
					System.out.println("Dime el número de la pizza a eliminar. Pulsa 0 para salir y no eliminar nada.");
					opcionEliminar = input.nextInt();
					input.nextLine();
				}	
				
				if(opcionEliminar==0) {
					return;
				}
				
				pizzas.remove(opcionEliminar - 1);
				input.nextLine();
				
				System.out.println("Desea eliminar una pizza más? Si/No");
				
			}while(!input.nextLine().toLowerCase().equals("no") && pizzas.size()>0);
		}else {
			System.out.println("No hay ninguna pizza en el pedido");
		}


	}
}


