package clases;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private String nombre;
	private List<Pronostico>pronosticos;
	private int aciertos;
	private int puntos;
	private int valor_puntos;
	private boolean partida_perfecta = true;
	private boolean ronda_perfecta = true;
	
	public Participante() {
		super();
	}


	public Participante(String nombre, List<Pronostico> pronosticos) {
		super();
		this.nombre = nombre;
		this.pronosticos = pronosticos;
	}


	public Participante(String nombre, List<Pronostico> pronosticos, int valor_puntos) {
		super();
		this.nombre = nombre;
		this.pronosticos = new ArrayList<Pronostico>();
		this.valor_puntos = valor_puntos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Pronostico> getPronosticos() {
		return pronosticos;
	}


	public void setPronosticos(List<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void agregarPronostico(Pronostico pronostico1){
		this.pronosticos.add(pronostico1);
	}


	public int getAciertos() {
		return aciertos;
	}


	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}
	
	public void acierto() {
		this.puntos+= this.valor_puntos;
		this.aciertos++;
	}


	
	public int getValor_puntos() {
		return valor_puntos;
	}


	public void setValor_puntos(int valor_puntos) {
		this.valor_puntos = valor_puntos;
	}


	public boolean isPartida_perfecta() {
		return partida_perfecta;
	}


	public void setPartida_perfecta(boolean partida_perfecta) {
		this.partida_perfecta = partida_perfecta;
	}

	public void partida_perfecta() {
		this.puntos += 2;
	}
	
	

	public boolean isRonda_perfecta() {
		return ronda_perfecta;
	}


	public void setRonda_perfecta(boolean ronda_perfecta) {
		this.ronda_perfecta = ronda_perfecta;
	}
	
	public void ronda_perfecta() {
		this.puntos +=1;
	}


	public String mostrarResultados() {
		return nombre + "\t\tAciertos=" + aciertos + "\t Puntos=" + puntos;
	}
	
	
	
}
