package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.*;

public class TestPartida {
	List<Ronda> rondas;
	List<Participante> participantes;
	List<Partido> partidos;
	List<Pronostico> pronosticos;
	String espacio = "********************************************************************";
	String espacioRonda = "--------------------------------------------------------------------";
	
	
@BeforeEach
public void setUp() {
}

@Test
void test() {
	
	int numero = 1;
	//Cargo Rondas y Partidos
	List<Ronda> rondas = new ArrayList<Ronda>();
	List<Participante> participantes = new ArrayList<Participante>();
	List<Partido> partidos1 = new ArrayList<Partido>();
	List<Partido> partidos2 = new ArrayList<Partido>();
	List<Pronostico> pronosticos1 = new ArrayList<Pronostico>();	
	List<Pronostico> pronosticos2 = new ArrayList<Pronostico>();	
	
	
	partidos1.add(new Partido("Argentina", "Arabia Saudita", 1, 2));
	partidos1.add(new Partido("Polonia", "Mexico", 0, 0));
	rondas.add(new Ronda(1, partidos1));
	
	partidos2.add(new Partido("Dinamarca", "Tunez", 0, 0));
	partidos2.add(new Partido("Australia", "Francia", 3, 4));
	rondas.add(new Ronda(2, partidos2));
	//Cargo Pronosticos y Participantes
	pronosticos1.add(new Pronostico("Argentina", "Arabia Saudita", "Argentina"));
	pronosticos1.add(new Pronostico("Polonia", "Mexico", "Empate"));
	pronosticos1.add(new Pronostico("Dinamarca", "Tunez", "Tunez"));
	pronosticos1.add(new Pronostico("Australia", "Francia", "Francia"));
	participantes.add(new Participante("Nico", pronosticos1));
	participantes.get(0).setValor_puntos(numero);
	
	pronosticos2.add(new Pronostico("Argentina", "Arabia Saudita", "Arabia Saudita"));
	pronosticos2.add(new Pronostico("Polonia", "Mexico", "Empate"));
	pronosticos2.add(new Pronostico("Dinamarca", "Tunez", "Tunez"));
	pronosticos2.add(new Pronostico("Australia", "Francia", "Francia"));
	participantes.add(new Participante("Ema", pronosticos2));
	participantes.get(1).setValor_puntos(numero);
	
	
    Main.partida(rondas, espacio, espacioRonda, participantes);
    
    //Resultado Jugador 1
    int AciertosJ1 = participantes.get(0).getPuntos();
    int resultadoEsperadoJ1 = 2;
    Boolean result= (resultadoEsperadoJ1 == AciertosJ1);
    assertTrue(result);
    
    //Resultado Jugador 2
    int AciertosJ2 = participantes.get(1).getPuntos();
    int resultadoEsperadoJ2 = 4;
    result = (resultadoEsperadoJ2 == AciertosJ2);
    assertTrue(result);
}

}
