package ar.edu.unlam.clases.com;

public class Adoptante {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer edad;
	
	public Adoptante(Integer dni, String nombre, String apellido, Integer edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	
	
}
