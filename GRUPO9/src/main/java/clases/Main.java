package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String Resultados = "src\\main\\java\\Archivos\\Resultados.txt";
		String Pronosticos = "src\\main\\java\\Archivos\\Pronostico.txt";
		String espacio = "************************************************";

		
		List<Ronda>rondas = rondas(Resultados);  
		List<Participante>participantes = participantes(Pronosticos);  
		print(rondas,espacio,participantes);
	}
	
	
	private static void print(List<Ronda>rondas,String espacio,List<Participante>participantes) {
		int i =1;
	
		for(Ronda ronda : rondas) {
			System.out.println("Ronda numero: " + ronda.getNumRonda());
			Iterator<Partido> iterator = ronda.getPartidos().iterator();
			while (iterator.hasNext()) {
				Partido partido = iterator.next();
				System.out.println("Datos del partido " + i + partido.toString());
				System.out.println("Ganador del partido " + i + " = " + partido.equipoGanador() + "\n");
				System.out.println(espacio);
				i++;
			}
		}
		
		for(Participante participante : participantes) {
			i=1;
			System.out.println("Participante: " + participante.getNombre());
			Iterator<Pronostico> iterator = participante.getPronosticos().iterator();
			while(iterator.hasNext()) {
		    Pronostico pronostico = iterator.next();
			System.out.println("Prediccion del ganador del partido " + i + " = " + pronostico.getRersultado());
			System.out.println(espacio);
			i++;
			}
		}
		
	}
	
	private static List<Ronda> rondas(String Resultados) {//El problema en esta funcion era que creaba la ronda al encontrarse con una linea vacia y en nuestro archivo no pasaba, asi que para solucionarlo cree la ronda al leer el renglon donde arranca la ronda.
		List<Ronda> rondas = new ArrayList<Ronda>();
		//List<Partido> partidos = new ArrayList<Partido>();
		int indiceRonda = -1;
		int numRonda = 0;
		
		try {
			for(String linea : Files.readAllLines(Paths.get(Resultados))) {
				if (linea.split(",")[0].equalsIgnoreCase("Ronda")) {
					numRonda = Integer.parseInt(linea.split(",")[1]);
					List<Partido> partidos1 = new ArrayList<Partido>();
					rondas.add(new Ronda(numRonda, partidos1));
					indiceRonda++;
				}
				/*else if (linea.isEmpty()){
					List<Partido> partidos1 = new ArrayList<Partido>(partidos);
					partidos.clear();
					rondas.add(new Ronda(numRonda, partidos1));
					
				}*/
				else if(!linea.isEmpty()) {
					String equipo1 = linea.split(",")[0];
					int goles1 = Integer.parseInt(linea.split(",")[1]);
					String equipo2 = linea.split(",")[3];
					int goles2 = Integer.parseInt(linea.split(",")[2]);
					Partido partido = new Partido(equipo1, equipo2, goles1, goles2);
					rondas.get(indiceRonda).agregarPartido(partido);
				}
				
			}
			
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return rondas;
	}
	
	private static List<Participante> participantes(String Pronosticos) {
		List<Participante> participantes = new ArrayList<Participante>();
		//*List<Pronostico> pronosticos = new ArrayList<Pronostico>();
		int indiceParticipante = -1;
		String nombre = "";
		
		try {
			for(String linea : Files.readAllLines(Paths.get(Pronosticos))) {
				if (linea.split(",")[0].equalsIgnoreCase("Participante")) {
					nombre = linea.split(",")[1];
					List<Pronostico> pronosticos1 = new ArrayList<Pronostico>();
					participantes.add(new Participante(nombre, pronosticos1));
					indiceParticipante++;
					
					
					
				}
				
				/*else if (linea.isEmpty()){
					List<Pronostico> pronostico1 = new ArrayList<Pronostico>(pronosticos);
					pronosticos.clear();
					participantes.add(new Participante(nombre, pronostico1));
					
				}*/
				else if(!linea.isEmpty()) {
					String equipo1 = linea.split(",")[0];
					String equipo2 = linea.split(",")[1];
					String resultado = linea.split(",")[2];
					Pronostico pronostico = new Pronostico(equipo1, equipo2, resultado);
					participantes.get(indiceParticipante).agregarPronostico(pronostico);
					
				}
				
			}
			
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return participantes;
	}

		
		/*
		Ronda ronda = new Ronda();

		try {
			int i = 1;
			for (String linea : Files.readAllLines(Paths.get(Resultados))) {
				String equipo1 = linea.split(",")[0];
				int goles1 = Integer.parseInt(linea.split(",")[1]);
				String equipo2 = linea.split(",")[3];
				int goles2 = Integer.parseInt(linea.split(",")[2]);
				Partido partido = new Partido(equipo1, equipo2, goles1, goles2);
				// partidos[i - 1] = new Partido(equipo1, equipo2, goles1, goles2);
				ronda.partidos[i - 1] = partido;
				System.out.println("Datos del partido " + i + ronda.partidos[i - 1].toString());
				System.out.println("Ganador del partido " + i + " = " + ronda.partidos[i - 1].equipoGanador() + "\n");
				System.out.println(espacio);
				i++;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			int i = 1;
			for (String linea : Files.readAllLines(Paths.get(Pronosticos))) {
				String equipo1 = linea.split(",")[0];
				String equipo2 = linea.split(",")[1];
				String resultado = linea.split(",")[2];
				Pronostico pronostico = new Pronostico(equipo1, equipo2, resultado);
				// pronosticos[i - 1] = new Pronostico(equipo1, equipo2, resultado);
				ronda.pronosticos[i - 1] = pronostico;
				System.out.println("Prediccion del ganador del partido " + i + " = " + ronda.pronosticos[i-1].getRersultado());
				System.out.println(espacio);
				i++;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nEl puntaje obtenido en esta ronda es: " + ronda.calcularPuntaje() + ".");
		
	}*/
	
	

}