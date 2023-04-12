package clases;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private String nombre;
	private List<Pronostico>pronosticos;
	private int puntos;
	
	
	public Participante() {
		super();
	}


	public Participante(String nombre, List<Pronostico> pronosticos) {
		super();
		this.nombre = nombre;
		this.pronosticos = pronosticos;
	}


	public Participante(String nombre, List<Pronostico> pronosticos, int puntos) {
		super();
		this.nombre = nombre;
		this.pronosticos = new ArrayList<Pronostico>();
		this.puntos = puntos;
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
	

	
}
