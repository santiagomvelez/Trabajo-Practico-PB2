package ar.edu.unlam.test.com;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.clases.com.Refugio;

public class RefugioTest {

	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAnimal() {
		
		Refugio refugio = new Refugio(1, "Patitas");
		
		Animal perro = new Perro()
				
		Boolean registrarAnimal = refugio.registrarAnimal(perro);
		
		
		
		
	}

}
