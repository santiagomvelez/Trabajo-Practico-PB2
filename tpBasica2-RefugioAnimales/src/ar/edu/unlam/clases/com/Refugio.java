package ar.edu.unlam.clases.com;

import java.util.ArrayList;
import java.util.HashMap;


public class Refugio {
	
	private Integer id;
	private String nombre;
	private HashMap<Integer, Animal> animales;
	private HashMap<Integer, Adoptante> adoptantes;
	private ArrayList<Adopcion> adopciones;
	
	
	public Refugio(Integer id, String nombre) {
		this.id= id;
		this.nombre = nombre;
		this.animales = new HashMap<>();
		this.adoptantes=new HashMap<>();
		this.adopciones=new ArrayList<>();
	}



	public Boolean registrarAnimal(Animal animal) {
		// si no cargamos ningun dato en animal devuelve falso
		if(animal == null) {
			return false;
		}
		// si el codigo que esta registrado es 1 y el nuevo que queremos registrar es 1 devuelve falso
		if (this.animales.containsKey(animal.getCodigo())) {
			return false;
		}
		
		// si ninguno de los dos casos anteriores no pasa se registra al animal y devuelve verdadero
		this.animales.put(animal.getCodigo(), animal);
		return true;
	}

	public Boolean registrarAdoptante(Adoptante adoptante) {

		//registrar el adoptante en hashmap agregandole la clave y el valor
	    if (adoptante != null) {
	        this.adoptantes.put(adoptante.getDni(), adoptante);
	        return true;
	    }

	    return false;
	}

	public Boolean procesarAdopcion(Integer idAdopcion, Adoptante adoptante, Animal animal)
	        throws AnimalNoSanoException, AnimalNoDisponibleException {

	    if (adoptante != null && animal != null) {

	        if (!animal.getSano()) {
	            throw new AnimalNoSanoException();
	        }

	        if (animal.getAdoptado()) {
	            throw new AnimalNoDisponibleException();
	        }

	        Adopcion adopcion = new Adopcion(idAdopcion, adoptante, animal);
	        this.adopciones.add(adopcion);

	        animal.setAdoptado(true);

	        return true;
	    }

	    return false;
	}
	

	public Animal buscarAnimalPorCodigo(Integer codigo) {
		//Recorro todos los animales de mi HashMap
		for(Animal animal: animales.values()) {
			//Comparo el código del animal con el código buscado
			if(animal.getCodigo().equals(codigo)){
				//Si lo encuentra devuelve el animal y sino null
				return animal;
			}
		}
		return null;
	}
	
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public HashMap<Integer, Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(HashMap<Integer, Animal> animales) {
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
