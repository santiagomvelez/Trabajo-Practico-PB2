package ar.edu.unlam.test.com;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.clases.com.Animal;
import ar.edu.unlam.clases.com.Perro;
import ar.edu.unlam.clases.com.Refugio;
import ar.edu.unlam.enums.com.Tamanio;

public class RefugioTest {

	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAnimal() {
		
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		
		// instancio la clase Perro que es una hija de clase Animal
		Animal perro = new Perro(1,"tony", "Labrador",3, Tamanio.MEDIANO);
				
		// Verificaion de registrar animal
		Boolean registrarAnimal = refugio.registrarAnimal(perro);
		
		// Validacion que debe devolver TRUE
		assertTrue(registrarAnimal);
	}
	
	
	@Test 
	public void dadoQueExisteUnRefugioNoSePuedenRegistrarDosAnimalesConElMismoCodigo() {
		
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		
		/* instancio la clase Perro que es una hija de clase Animal
		 *  Lo hago dos veces con el mismo id para verificarlo que no se pueda registrar
		 */
		Animal perro = new Perro(1,"tony", "Labrador",3, Tamanio.MEDIANO);
		Animal perro2 = new Perro(1,"tony", "Labrador",3, Tamanio.MEDIANO);
		
		// Lo registro las dos veces una normal y que la otra devuelva el Boolean para hacer la valdidacion
		refugio.registrarAnimal(perro);
		boolean registrarAnimal2 = refugio.registrarAnimal(perro2);
		
		
		// Validacion valores esperados que devuelva Falso para registrar y que traigan el codigo y es el mismo
		assertFalse(registrarAnimal2);
		assertEquals(perro.getCodigo(), perro2.getCodigo(), 0.01);
		
	}

}
