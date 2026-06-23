package ar.edu.unlam.clases.com;

import java.util.HashMap;


public class Refugio {
	
	private Integer id;
	private String nombre;
	private HashMap<Integer, Animal> animales;
	
	public Refugio(Integer id, String nombre) {
		this.id= id;
		this.nombre = nombre;
		this.animales = new HashMap<>();
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
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
}
