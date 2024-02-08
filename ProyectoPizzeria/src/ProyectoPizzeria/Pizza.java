package ProyectoPizzeria;

public class Pizza {
	
	private String masa;
	private String base;
	private String[] ingredientes;
	
	public Pizza(String masa, String base, String[] ingredientes) {
		this.masa=masa;
		this.base=base;
		this.ingredientes=ingredientes;
	}

	public String getMasa() {
		return masa;
	}

	public void setMasa(String masa) {
		this.masa = masa;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}

}
