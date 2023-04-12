package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		String Resultados = "src\\Archivos\\Resultados.txt";
		String Pronosticos = "src\\Archivos\\Pronostico.txt";
		String espacio = "************************************************";
		/*
		 * Partido partidos[] = new Partido[2]; Pronostico pronosticos[] = new
		 * Pronostico[2];
		 */

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
		
	}
}