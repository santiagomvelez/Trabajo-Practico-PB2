package ar.edu.unlam.test.com;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.ulam.interfaces.com.Adoptable;
import ar.edu.unlam.clases.com.Adoptante;
import ar.edu.unlam.clases.com.AdoptanteMenorDeEdadNopuedeAdoptarException;
import ar.edu.unlam.clases.com.Animal;
import ar.edu.unlam.clases.com.AnimalNoDisponibleException;
import ar.edu.unlam.clases.com.AnimalNoSanoException;
import ar.edu.unlam.clases.com.CapacidadRefugioExcedidaException;
import ar.edu.unlam.clases.com.Gato;
import ar.edu.unlam.clases.com.Perro;
import ar.edu.unlam.clases.com.Refugio;
import ar.edu.unlam.enums.com.Tamanio;

public class RefugioTest {

	// TEST 1
	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAnimal() throws CapacidadRefugioExcedidaException {

		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas", 20);

		// instancio la clase Perro que es una hija de clase Animal
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);

		// Verificaion de registrar animal
		Boolean registrarAnimal = refugio.registrarAnimal(perro);

		// Validacion que debe devolver TRUE
		// Valido que se agregue a la colección
		assertTrue(registrarAnimal);
		assertEquals(1, refugio.getAnimales().size());
	}

	// TEST 2
	@Test
	public void dadoQueExisteUnRefugioNoSePuedenRegistrarDosAnimalesConElMismoCodigo()
			throws CapacidadRefugioExcedidaException {

		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas", 20);

		/*
		 * instancio la clase Perro que es una hija de clase Animal Lo hago dos veces
		 * con el mismo id para verificarlo que no se pueda registrar
		 */
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
		Animal perro2 = new Perro(1, "tony", "Labrador", 3, true, Tamanio.MEDIANO);

		// Lo registro las dos veces una normal y que la otra devuelva el Boolean para
		// hacer la valdidacion
		refugio.registrarAnimal(perro);
		boolean registrarAnimal2 = refugio.registrarAnimal(perro2);

		// Validacion valores esperados que devuelva Falso para registrar y que traigan
		// el codigo y es el mismo y que se guarde solo uno
		assertFalse(registrarAnimal2);
		assertEquals(perro.getCodigo(), perro2.getCodigo(), 0.01);
		assertEquals(1, refugio.getAnimales().size());
	}

	// TEST 3
	@Test
	public void dadoQueExisteUnRefugioSePuedeRegistrarUnAdoptante() throws CapacidadRefugioExcedidaException {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas", 20);

		// Instancio el objeto y creo un adoptante
		Adoptante adoptante = new Adoptante(46952188, "Nazarena", "Molina", 30);

		// Registro al adoptante para validar que se guarda correctamente
		Boolean resultado = refugio.registrarAdoptante(adoptante);

		// Valido que se registre y que se guarde en la colección de los adoptantes del
		// refugio
		assertTrue(resultado);
		assertEquals(1, refugio.getAdoptantes().size());
	}

	// TEST 4
	@Test
	public void dadoQueExisteUnRefugioSePuedeProcesarUnaAdopcion()
			throws AnimalNoSanoException, AnimalNoDisponibleException, CapacidadRefugioExcedidaException,
			AdoptanteMenorDeEdadNopuedeAdoptarException {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas", 20);

		// Instancio el objeto y creo un adoptante
		Adoptante adoptante = new Adoptante(46952188, "Nazarena", "Molina", 30);

		// instancio la clase Perro que es una hija de clase Animal
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);

		// Registro adoptante
		refugio.registrarAdoptante(adoptante);

		// Registro animal
		refugio.registrarAnimal(perro);
		
		// Verifico con la interfaz si el animal cumple los requisitos
	    Adoptable adoptable = (Adoptable) perro;
	    assertTrue(adoptable.cumpleRequisitosAdopcion());

		// Registro adopcion
		Boolean resultado = refugio.procesarAdopcion(1, adoptante, perro);

		// Valido que la adopcion se procese correctamente y se guarde en la colección
		// de adopciones realizadas
		assertTrue(resultado);
		assertEquals(1, refugio.getAdopciones().size());
	}

	// TEST 5
	@Test(expected = AnimalNoSanoException.class)
	public void dadoQueUnAnimalNoEstaSanoNoPuedeSerAdoptado() throws AnimalNoSanoException, AnimalNoDisponibleException,
			CapacidadRefugioExcedidaException, AdoptanteMenorDeEdadNopuedeAdoptarException {

		Refugio refugio = new Refugio(1, "Patitas", 20);

		Adoptante adoptante = new Adoptante(12345678, "Mia", "Perez", 19);

		// sano=true pero solo 1 mes, no cumple requisitos por edad
		Animal perro = new Perro(1, "Tony", "Labrador", 1, false, Tamanio.MEDIANO);
		perro.setSano(false);

		refugio.procesarAdopcion(1, adoptante, perro);
	}

	// TEST 6
	@Test(expected = AnimalNoDisponibleException.class)
	public void dadoQueUnAnimalYaFueAdoptadoNoPuedeVolverASerAdoptado()
			throws AnimalNoSanoException, AnimalNoDisponibleException, CapacidadRefugioExcedidaException,
			AdoptanteMenorDeEdadNopuedeAdoptarException {

		Refugio refugio = new Refugio(1, "Patitas", 20);

		Adoptante adoptante = new Adoptante(12345678, "Mia", "Perez", 19);

		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
		perro.setSano(true);
		perro.setAdoptado(true);

		refugio.procesarAdopcion(1, adoptante, perro);
	}

	// TEST 7
	@Test(expected = CapacidadRefugioExcedidaException.class)
	public void dadoQueElRefugioEstaLlenoNoSePuedeRegistrarUnAnimalMas() throws CapacidadRefugioExcedidaException {

		Refugio refugio = new Refugio(1, "Patitas", 1);

		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
		Animal gato = new Gato(2, "Bola de nieve", "Mestizo", 12, true);

		refugio.registrarAnimal(perro);
		refugio.registrarAnimal(gato); // el gato no se registraria por que excede la capacidad del refugio
										// el test da verde ya que espera la excepcion
	}

	// TEST 8
	@Test
	public void dadoQueExistenVariosAnimalesSeObtienenOrdenadosPorCodigo() throws CapacidadRefugioExcedidaException {

		Refugio refugio = new Refugio(1, "Patitas", 10);

		// registro a propósito DESORDENADOS
		Animal gato = new Gato(3, "Bola de nieve", "Mestizo", 12, true);
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);
		Animal otroPerro = new Perro(2, "Rex", "Mestizo", 5, true, Tamanio.GRANDE);

		refugio.registrarAnimal(gato); // código 3
		refugio.registrarAnimal(perro); // código 1
		refugio.registrarAnimal(otroPerro); // código 2

		// TreeSet ordenado
		TreeSet<Animal> animalesOrdenados = refugio.obtenerAnimalesOrdenadosPorCodigo();

		// convierto a List para poder chequear por posición (0, 1, 2)
		List<Animal> listaOrdenada = new ArrayList<>(animalesOrdenados);

		assertEquals(perro.getCodigo(), listaOrdenada.get(0).getCodigo());
		assertEquals(otroPerro.getCodigo(), listaOrdenada.get(1).getCodigo());
		assertEquals(gato.getCodigo(), listaOrdenada.get(2).getCodigo());
	}

	// TEST 9

	@Test(expected = AdoptanteMenorDeEdadNopuedeAdoptarException.class)
	public void dadoQueElAdoptanteEsMenorDeEdadNoSePuedeAdoptar() throws CapacidadRefugioExcedidaException,
			AnimalNoSanoException, AnimalNoDisponibleException, AdoptanteMenorDeEdadNopuedeAdoptarException {
		// Instancio un refugio
		Refugio refugio = new Refugio(1, "Patitas", 10);

		// Instancio un animal
		Animal perro = new Perro(1, "Tony", "Labrador", 3, true, Tamanio.MEDIANO);

		// Instancio un adoptante menor de edad
		Adoptante adoptante = new Adoptante(45767632, "Santiago", "Velez", 16);

		// Se registra el animal y el adoptante siendo menor de edad
		refugio.registrarAnimal(perro);
		refugio.registrarAdoptante(adoptante);

		// lanza exception porque el adoptante es menor de edad
		refugio.procesarAdopcion(1, adoptante, perro);
	}

	// TEST 10
	@Test
	public void dadoQueExisteUnAnimalRegistradoSeLoPuedeBuscarPorCodigo() throws CapacidadRefugioExcedidaException {
		// Instancio el objeto y creo un refugio
		Refugio refugio = new Refugio(1, "Patitas", 20);
		Integer codigoAnimal = 1;

		// Instancio la clase Gato que es una hija de clase Animal
		Animal gato = new Gato(codigoAnimal, "Golden", "Siamés", 3, true);

		// Registro animal
		refugio.registrarAnimal(gato);

		// Busco el animal por el código
		Animal animalEncontrado = refugio.buscarAnimalPorCodigo(codigoAnimal);

		// Valido que el animal que me devuelve sea igual al animal encontrado
		assertEquals(animalEncontrado, gato);
	}

	// TEST 11
	@Test
	public void dadoQueExisteUnAdoptanteRegistradoSeLoPuedeBuscarPorDni() {

		Refugio refugio = new Refugio(1, "Patitas", 20);

		Adoptante adoptante = new Adoptante(12345678, "Mia", "Perez", 19);

		refugio.registrarAdoptante(adoptante);

		Adoptante buscado = refugio.buscarAdoptantePorDni(12345678);

		assertEquals(adoptante, buscado);
	}

	// TEST 12
	
	
}
