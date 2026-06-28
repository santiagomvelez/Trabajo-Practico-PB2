package ar.edu.unlam.test.com;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.clases.com.Adoptante;
import ar.edu.unlam.clases.com.Animal;
import ar.edu.unlam.clases.com.AnimalNoDisponibleException;
import ar.edu.unlam.clases.com.AnimalNoSanoException;
import ar.edu.unlam.clases.com.Gato;
import ar.edu.unlam.clases.com.Perro;
import ar.edu.unlam.clases.com.Refugio;
import ar.edu.unlam.enums.com.Tamanio;

public class RefugioTest {

	
	// TEST 1
	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAnimal() {
		
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		
		// instancio la clase Perro que es una hija de clase Animal
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
				
		// Verificaion de registrar animal
		Boolean registrarAnimal = refugio.registrarAnimal(perro);
		
		// Validacion que debe devolver TRUE
		//Valido que se agregue a la colección
		assertTrue(registrarAnimal);
		assertEquals(1, refugio.getAnimales().size());
	}
	
	// TEST 2
	@Test 
	public void dadoQueExisteUnRefugioNoSePuedenRegistrarDosAnimalesConElMismoCodigo() {
		
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		
		/* instancio la clase Perro que es una hija de clase Animal
		 *  Lo hago dos veces con el mismo id para verificarlo que no se pueda registrar
		 */
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
		Animal perro2 = new Perro(1,"tony", "Labrador",3, true, Tamanio.MEDIANO);
		
		// Lo registro las dos veces una normal y que la otra devuelva el Boolean para hacer la valdidacion
		refugio.registrarAnimal(perro);
		boolean registrarAnimal2 = refugio.registrarAnimal(perro2);
		
		
		// Validacion valores esperados que devuelva Falso para registrar y que traigan el codigo y es el mismo y que se guarde solo uno
		assertFalse(registrarAnimal2);
		assertEquals(perro.getCodigo(), perro2.getCodigo(), 0.01);
		assertEquals(1, refugio.getAnimales().size());
	}
	
	// TEST 3
	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAdoptante() {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
	
		// Instancio el objeto y creo un adoptante
		Adoptante adoptante=new Adoptante(46952188, "Nazarena", "Molina", 30);
		
		//Registro al adoptante para validar que se guarda correctamente
		Boolean resultado=refugio.registrarAdoptante(adoptante);
		
		//Valido que se registre y que se guarde en la colección de los adoptantes del refugio
		assertTrue(resultado);
		assertEquals(1, refugio.getAdoptantes().size());
	}

	// TEST 4
	@Test
	public void dadoQueExisteUnRefugioSePuedeProcesarUnaAdopcion() 
			throws AnimalNoSanoException, AnimalNoDisponibleException {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		
		// Instancio el objeto y creo un adoptante
		Adoptante adoptante=new Adoptante(46952188, "Nazarena", "Molina", 30);
		
		// instancio la clase Perro que es una hija de clase Animal
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);

		//Registro adoptante
		refugio.registrarAdoptante(adoptante);
		
		// Registro animal
	    refugio.registrarAnimal(perro);
	    
	    // Registro adopcion
	    Boolean resultado=refugio.procesarAdopcion(1, adoptante, perro);
	    
	    // Valido que la adopcion se procese correctamente y se guarde en la colección de adopciones realizadas
	    assertTrue(resultado);
	    assertEquals(1, refugio.getAdopciones().size());
	}
	
	// TEST 5
	@Test(expected = AnimalNoSanoException.class)
	public void dadoQueUnAnimalNoEstaSanoNoPuedeSerAdoptado()
	        throws AnimalNoSanoException, AnimalNoDisponibleException {
		
		Refugio refugio = new Refugio(1, "Patitas");
		
		Adoptante adoptante = new Adoptante(46952188, "Nazarena", "Molina", 30);
		
		Animal perro = new Perro(1, "Tony", "Labrador", 3, false, Tamanio.MEDIANO);
	    perro.setSano(false);


	    refugio.procesarAdopcion(1, adoptante, perro);
	}
	
	//TEST 6
	@Test(expected = AnimalNoDisponibleException.class)
	public void dadoQueUnAnimalYaFueAdoptadoNoPuedeVolverASerAdoptado()
	        throws AnimalNoSanoException, AnimalNoDisponibleException {

		Refugio refugio = new Refugio(1, "Patitas");

	    Adoptante adoptante = new Adoptante(46952188, "Nazarena", "Molina", 30);

	    Animal perro = new Perro(1,"Tony", "Labrador", 3, true, Tamanio.MEDIANO);
	    perro.setSano(true);
	    perro.setAdoptado(true);

	    refugio.procesarAdopcion(1, adoptante, perro);
	}
	
	
	
	
	// TEST 10
	@Test
	public void  dadoQueExisteUnAnimalRegistradoSeLoPuedeBuscarPorCodigo() {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas");
		Integer codigoAnimal=1;
		
		// Instancio la clase Gato que es una hija de clase Animal
		Animal gato = new Gato(codigoAnimal, "Golden", "Siamés", 3, true);
		
		// Registro animal
		refugio.registrarAnimal(gato);
		
		//Busco el animal por el código
		Animal animalEncontrado=refugio.buscarAnimalPorCodigo(codigoAnimal);
		
		//Valido que el animal que me devuelve sea igual al animal encontrado
		assertEquals(animalEncontrado, gato);
	}
	
	
	

}
