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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcionAdopcion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

}
