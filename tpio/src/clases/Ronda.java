package clases;

public class Ronda {
	Partido partidos[] = new Partido[2];
	Pronostico pronosticos[] = new Pronostico[2];

	public Ronda() {
		super();
	}

	public Ronda(Partido[] partidos, Pronostico[] pronosticos) {
		super();
		this.partidos = partidos;
		this.pronosticos = pronosticos;
	}

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

}
