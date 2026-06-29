package ar.edu.unlam.clases.com;

import ar.edu.ulam.interfaces.com.Adoptable;
import ar.edu.unlam.enums.com.Tamanio;

public class Perro extends Animal implements Adoptable {

	private Tamanio tamanio;

	public Perro(Integer codigo, String nombre, String raza, Integer edadEnMeses, Boolean sano, Tamanio tamanio) {
		super(codigo, nombre, raza, edadEnMeses, sano);
		this.tamanio = tamanio;

	}

	@Override
	public Boolean cumpleRequisitosAdopcion() {
		return this.getSano() && this.getEdadEnMeses() > 2;
	}

	@Override
	public String getDescripcionAdopcion() {
		return "Perro - Nombre: " + getNombre() 
        + ", Raza: " + getRaza() 
        + ", Edad: " + getEdadEnMeses() + " meses"
        + ", Tamaño: " + tamanio;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

}
