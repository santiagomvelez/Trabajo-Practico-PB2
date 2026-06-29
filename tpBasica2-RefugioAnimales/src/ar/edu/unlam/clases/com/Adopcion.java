package ar.edu.unlam.clases.com;

public class Adopcion {

	private Integer idAdopcion;
	private Adoptante adoptante;
	private Animal animal;

	public Adopcion(Integer id, Adoptante adoptante, Animal animal) {
		this.idAdopcion = id;
		this.adoptante = adoptante;
		this.animal = animal;
	}

	public Integer getId() {
		return idAdopcion;
	}

	public void setId(Integer id) {
		this.idAdopcion = id;
	}

	public Adoptante getAdoptante() {
		return adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
