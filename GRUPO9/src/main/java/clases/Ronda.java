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
	
	public void agregarPartido(Partido partido1) {
		this.partidos.add(partido1);
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

	
	
	/*
	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}

	public Pronostico[] getPronosticos() {
		return pronosticos;
	}

	public void setPronosticos(Pronostico[] pronosticos) {
		this.pronosticos = pronosticos;
	}

	// Funcion que calcula el puntaje de toda la partida
	public int calcularPuntaje() {
		int puntaje=0;
		for(int i=0; i<this.partidos.length ;i++){
			if(this.partidos[i].equipoGanador().equalsIgnoreCase(this.pronosticos[i].getRersultado())) {
				puntaje++;
			}
		}
		return puntaje;
	}
*/
}
