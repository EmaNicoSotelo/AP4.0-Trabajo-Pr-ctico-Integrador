package clases;
public class Partido {
	private String equipo1;
	private String equipo2;
	private int cantidadGolesE1;
	private int cantidadGolesE2;



	public Partido() {
		super();
	}
	public Partido(String equipo1, String equipo2, int cantidadGolesE1, int cantidadGolesE2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.cantidadGolesE1 = cantidadGolesE1;
		this.cantidadGolesE2 = cantidadGolesE2;
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
	public int getCantidadGolesE1() {
		return cantidadGolesE1;
	}
	public void setCantidadGolesE1(int cantidadGolesE1) {
		this.cantidadGolesE1 = cantidadGolesE1;
	}
	public int getCantidadGolesE2() {
		return cantidadGolesE2;
	}
	public void setCantidadGolesE2(int cantidadGolesE2) {
		this.cantidadGolesE2 = cantidadGolesE2;
	}

	public String equipoGanador() {
		String ganador; 
		if (this.cantidadGolesE1>this.cantidadGolesE2) {
			ganador=this.equipo1;
		}else {
			if (this.cantidadGolesE2>this.cantidadGolesE1) {
				ganador=this.equipo2;
			}else {
				ganador="Empate";
			}
		}
		return ganador;
	}
	@Override
	public String toString() {
		return "\nEquipo 1=" + equipo1 + "\nCantidad de goles=" + cantidadGolesE1 + "\n\nEquipo 2=" + equipo2
				+ "\nCantidad de goles=" + cantidadGolesE2+"\n";
	}
	
	
}
