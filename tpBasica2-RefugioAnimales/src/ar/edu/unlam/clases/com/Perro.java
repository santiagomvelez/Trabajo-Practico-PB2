package ar.edu.unlam.clases.com;

import ar.edu.ulam.interfaces.com.Adoptable;
import ar.edu.unlam.enums.com.Tamanio;

public class Perro extends Animal implements Adoptable {

	private Tamanio tamanio;
	
	
	public Perro(Integer codigo, String nombre, String raza, Integer edadEnMeses, Tamanio tamanio) {
		super(codigo, nombre, raza, edadEnMeses);
		
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
	
	

}
