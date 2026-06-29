package ar.edu.unlam.clases.com;

public abstract class  Animal implements Comparable<Animal> {

    private Integer codigo;
    private String nombre;
    private String raza;
    private Integer edadEnMeses;
    private Boolean sano;
    private Boolean adoptado;


    public Animal(Integer codigo, String nombre, String raza, Integer edadEnMeses, Boolean sano) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.edadEnMeses = edadEnMeses;
        this.sano = sano;
        this.adoptado = false;
    }

    //lor ordena de manera ASC
    @Override
    public int compareTo(Animal otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }
    
    public Integer getEdadEnMeses() {
        return edadEnMeses;
    }


    public void setEdadEnMeses(Integer edadEnMeses) {
        this.edadEnMeses = edadEnMeses;
    }


    public Boolean getSano() {
        return sano;
    }


    public void setSano(Boolean sano) {
        this.sano = sano;
    }


    public Boolean getAdoptado() {
        return adoptado;
    }


    public void setAdoptado(Boolean adoptado) {
        this.adoptado = adoptado;
    }


    public Integer getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public String getRaza() {
        return raza;
    }

}
