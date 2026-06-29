package ar.edu.unlam.clases.com;

public class AnimalNoDisponibleException extends Exception {

    public AnimalNoDisponibleException() {
        super("El animal ya fue adoptado.");
    }
}
