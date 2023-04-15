package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Partido;

public class testEquipoGanador {
	Partido partidoTest;
	
	@BeforeEach
	public void setUp(){
		partidoTest = new Partido();
	}
	
	@Test
	void testGanador() {
		partidoTest.setEquipo1("Argentina");
		partidoTest.setEquipo2("Arabia Saudita");
		partidoTest.setCantidadGolesE1(1);
		partidoTest.setCantidadGolesE2(2);
		String ganador = partidoTest.equipoGanador();
		String ganadorEsperado = "Arabia Saudita";
		Boolean result = (ganador.equalsIgnoreCase(ganadorEsperado));
		
		assertTrue(result);
	}
}
