package ar.edu.unlam.clases.com;

import ar.edu.unlam.interfaces.com.Adoptable;

public class Gato extends Animal implements Adoptable {

	public Gato(Integer codigo, String nombre, String raza, Integer edadEnMeses, Boolean sano) {
		super(codigo, nombre, raza, edadEnMeses, sano);

	}

	@Override
	public Boolean cumpleRequisitosAdopcion() {
		 return this.getSano() && this.getEdadEnMeses() > 2;
	}

	@Override
	public String getDescripcionAdopcion() {
		return "Gato - Nombre: " + getNombre() 
        + ", Raza: " + getRaza() 
        + ", Edad: " + getEdadEnMeses() + " meses";
	}

}
