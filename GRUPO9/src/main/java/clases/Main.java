package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String Resultados = "src\\main\\java\\Archivos\\Resultados.txt";
		String Pronosticos = "src\\main\\java\\Archivos\\Pronostico.txt";
		String espacio = "********************************************************************";
		String espacioRonda = "--------------------------------------------------------------------";

		List<Ronda> rondas = rondas(Resultados);
		List<Participante> participantes = participantes(Pronosticos);
		partida(rondas, espacio, espacioRonda, participantes);

	}

	// Funcion para simular la partida.
	public static void partida(List<Ronda> rondas, String espacio, String espacioRonda,
			List<Participante> participantes) {
		int nroPartido = -1;
		for (int i = 0; i < rondas.size(); i++) {
			System.out.println("\t\tRonda numero: " + rondas.get(i).getNumRonda());
			for (int j = 0; j < rondas.get(i).getPartidos().size(); j++) {
				nroPartido++;
				System.out.println("Datos del partido " + (j + 1) + rondas.get(i).getPartidos().get(j));
				System.out.println(
						"Ganador del partido " + (j + 1) + ": " + rondas.get(i).getPartidos().get(j).equipoGanador());
				System.out.println(espacioRonda);
				System.out.println("Pronostico de los jugadores");
				for (int k = 0; k < participantes.size(); k++) {
					System.out.println("Pronostico de " + participantes.get(k).getNombre() + ":");
					System.out.println(participantes.get(k).getPronosticos().get(nroPartido).toString());
					if (participantes.get(k).getPronosticos().get(nroPartido).getRersultado()
							.equalsIgnoreCase(rondas.get(i).getPartidos().get(j).equipoGanador())) {
						participantes.get(k).acierto();
					}
					System.out.println(espacioRonda);
				}
				
				System.out.println("Resultados parciales:");
				for (int k = 0; k < participantes.size(); k++) {
					System.out.println(participantes.get(k).mostrarResultados());
					System.out.println(espacioRonda);

				}
				System.out.println(espacio);

			}
			System.out.println("\n\n");
		}
		System.out.println("Resultados Finales:");
		for (int i = 0; i < participantes.size(); i++) {
			System.out.println(participantes.get(i).mostrarResultados()+"\n");
		}
	}

	
	private static List<Ronda> rondas(String Resultados) {
		List<Ronda> rondas = new ArrayList<Ronda>();
		int indiceRonda = -1;
		int numRonda = 0;

		try {
			for (String linea : Files.readAllLines(Paths.get(Resultados))) {
				if (linea.split(",")[0].equalsIgnoreCase("Ronda")) {
					numRonda = Integer.parseInt(linea.split(",")[1]);
					List<Partido> partidos = new ArrayList<Partido>();
					rondas.add(new Ronda(numRonda, partidos));
					indiceRonda++;
				}
				else if (!linea.isEmpty()) {
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
		int indiceParticipante = -1;
		String nombre = "";

		try {
			for (String linea : Files.readAllLines(Paths.get(Pronosticos))) {
				if (linea.split(",")[0].equalsIgnoreCase("Participante")) {
					nombre = linea.split(",")[1];
					List<Pronostico> pronosticos1 = new ArrayList<Pronostico>();
					participantes.add(new Participante(nombre, pronosticos1));
					indiceParticipante++;

				}
				else if (!linea.isEmpty()) {
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
}