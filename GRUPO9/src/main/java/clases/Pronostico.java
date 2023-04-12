package clases;

public class Pronostico {
	private String equipo1;
	private String equipo2;
	private String rersultado;
	
	

	
	public Pronostico() {
		super();
	}

	public Pronostico(String equipo1, String equipo2, String rersultado) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.rersultado = rersultado;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

	public String getRersultado() {
		return rersultado;
	}

	public void setRersultado(String rersultado) {
		this.rersultado = rersultado;
	}

	
	
	
}
