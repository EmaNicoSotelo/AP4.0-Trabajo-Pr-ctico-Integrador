package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

	public static void main(String[] args) {
		String Resultados = "src\\Archivos\\Resultados.txt";
		String Pronosticos = "src\\Archivos\\Pronostico.txt";

		try {
			int i =1;
			for(String linea : Files.readAllLines(Paths.get(Resultados))) {
				String equipo1 =linea.split(",")[0];
				int goles1 = Integer.parseInt(linea.split(",")[1]);
				String equipo2 =linea.split(",")[3];
				int goles2 = Integer.parseInt(linea.split(",")[2]);
				Partido partido = new Partido(equipo1,equipo2,goles1,goles2);
				System.out.println("resultado del partido "+ i + " = "+ partido.equipoGanador());
				i++;

			}
		}
		catch(IOException e){
			e.printStackTrace();
		}


		try {
			int i = 1;
			for(String linea : Files.readAllLines(Paths.get(Pronosticos))) {
				String equipo1 =linea.split(",")[0];
				String equipo2 =linea.split(",")[1];
				String resultado =linea.split(",")[2];
				Pronostico pronostico = new Pronostico(equipo1,equipo2,resultado);
				System.out.println("prediccion partido "+ i +" = " + pronostico.getRersultado());
				i++;

			}
		}
		catch(IOException e){
			e.printStackTrace();
		}


	}
}