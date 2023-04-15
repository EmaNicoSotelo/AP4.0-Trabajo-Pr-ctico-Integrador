package clases;

import java.util.List;

public class Ronda {
	private int numRonda;
	private List<Partido>partidos;

	public Ronda() {
		super();
	}

	public Ronda(int numRonda, List<Partido> partidos) {
		super();
		this.numRonda = numRonda;
		this.partidos = partidos;
	}
	
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
	}

	public int getNumRonda() {
		return numRonda;
	}

	public void setNumRonda(int numRonda) {
		this.numRonda = numRonda;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
}
