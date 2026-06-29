package ar.edu.unlam.clases.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import ar.edu.unlam.interfaces.com.Adoptable;

public class Refugio {

	private Integer id;
	private String nombre;
	private Integer capacidadMaxima;
	private Map<Integer, Animal> animales;
	private HashMap<Integer, Adoptante> adoptantes;
	private ArrayList<Adopcion> adopciones;

	public Refugio(Integer id, String nombre, Integer capacidadMaxima) {
		this.id = id;
		this.nombre = nombre;
		this.capacidadMaxima = capacidadMaxima;
		this.animales = new HashMap<>();
		this.adoptantes = new HashMap<>();
		this.adopciones = new ArrayList<>();
	}

	public Boolean registrarAnimal(Animal animal) throws CapacidadRefugioExcedidaException {
		// si no cargamos ningun dato en animal devuelve falso
		if (animal == null) {
			return false;
		}
		// si el codigo que esta registrado es 1 y el nuevo que queremos registrar es 1
		// devuelve falso
		if (this.animales.containsKey(animal.getCodigo())) {
			return false;
		}

		if (this.animales.size() >= this.capacidadMaxima) {
			throw new CapacidadRefugioExcedidaException("El refugio está lleno, no se puede registrar un animal más");
		}

		// si ninguno de los dos casos anteriores no pasa se registra al animal y
		// devuelve verdadero
		this.animales.put(animal.getCodigo(), animal);
		return true;
	}

	public Boolean registrarAdoptante(Adoptante adoptante) {

		// registrar el adoptante en hashmap agregandole la clave y el valor
		if (adoptante != null) {
			this.adoptantes.put(adoptante.getDni(), adoptante);
			return true;
		}

		return false;
	}

	public Boolean procesarAdopcion(Integer idAdopcion, Adoptante adoptante, Animal animal)
			throws AnimalNoSanoException, AnimalNoDisponibleException, AdoptanteMenorDeEdadNopuedeAdoptarException {

		if (adoptante != null && animal != null) {

			// primero verifica si ya fue adoptado
			if (animal.getAdoptado()) {
				throw new AnimalNoDisponibleException();
			}

			// dsp verifica si cumple requisitos (sano y edad)
			if (animal instanceof Adoptable) {
				Adoptable adoptable = (Adoptable) animal;
				if (!adoptable.cumpleRequisitosAdopcion()) {
					throw new AnimalNoSanoException();
				}
			}

			// y por ultimo verifica la edad del adoptante
			if (adoptante.getEdad() < 18) {
				throw new AdoptanteMenorDeEdadNopuedeAdoptarException(
						"El adoptante es menor de edad y no puede adoptar");
			}

			Adopcion adopcion = new Adopcion(idAdopcion, adoptante, animal);
			this.adopciones.add(adopcion);

			animal.setAdoptado(true);

			return true;
		}

		return false;
	}
	
	public Animal buscarAnimalPorCodigo(Integer codigo) {
	    return this.animales.get(codigo);
	}

	public TreeSet<Animal> obtenerAnimalesOrdenadosPorCodigo() {
		TreeSet<Animal> animalesOrdenados = new TreeSet<>();
		animalesOrdenados.addAll(this.animales.values()); // agregue los animales del HashMap al TreeSet de
															// animalesOrdenados
		return animalesOrdenados;
	}

	public Adoptante buscarAdoptantePorDni(Integer dni) {
		return this.adoptantes.get(dni);
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Map<Integer, Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(Map<Integer, Animal> animales) {
		this.animales = animales;
	}

	public HashMap<Integer, Adoptante> getAdoptantes() {
		return adoptantes;
	}

	public void setAdoptantes(HashMap<Integer, Adoptante> adoptantes) {
		this.adoptantes = adoptantes;
	}

	public ArrayList<Adopcion> getAdopciones() {
		return adopciones;
	}

	public void setAdopciones(ArrayList<Adopcion> adopciones) {
		this.adopciones = adopciones;
	}

}
