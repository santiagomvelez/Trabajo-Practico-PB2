package ar.edu.unlam.clases.com;

import ar.edu.ulam.interfaces.com.Adoptable;

public class Gato extends Animal implements Adoptable{

	
	public Gato(Integer codigo, String nombre, String raza, Integer edadEnMeses) {
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
