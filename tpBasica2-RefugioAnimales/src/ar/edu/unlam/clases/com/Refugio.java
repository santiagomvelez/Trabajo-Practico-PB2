package ar.edu.unlam.clases.com;

import java.util.ArrayList;
import java.util.HashMap;


public class Refugio {
	
	private Integer id;
	private String nombre;
	private HashMap<Integer, Animal> animales;
	private ArrayList<Adoptante>adoptantes;
	private ArrayList<Adopcion>adopciones;
	
	
	public Refugio(Integer id, String nombre) {
		this.id= id;
		this.nombre = nombre;
		this.animales = new HashMap<>();
		this.adoptantes=new ArrayList<Adoptante>();
		this.adopciones=new ArrayList<Adopcion>();
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
		//Si el adoptante que le paso por parámetros NO es nulll, lo registra y agrega a la colección del refugio
		if(adoptante!=null) {
			this.adoptantes.add(adoptante);
			return true;
		}
		return false;
	}

	public Boolean procesarAdopcion(Integer idAdopcion, Adoptante adoptante, Animal perro) {
		//Si los dos objetyos que se ingresan no son null
		if(adoptante!=null && perro!=null) {
		//Creo una adopcion con sus respectivos parámetros y la agrego a mi lista de adopciones.	
			Adopcion adopcion=new Adopcion(idAdopcion, adoptante, perro);
			this.adopciones.add(adopcion);
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
	

	public ArrayList<Adoptante> getAdoptantes() {
		return adoptantes;
	}

	public void setAdoptantes(ArrayList<Adoptante> adoptantes) {
		this.adoptantes = adoptantes;
	}
	
	public ArrayList<Adopcion> getAdopciones() {
		return adopciones;
	}

	public void setAdopciones(ArrayList<Adopcion> adopciones) {
		this.adopciones = adopciones;
	}
	
	
	
	
	
	
	
}
