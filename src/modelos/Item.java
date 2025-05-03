package modelos;

public class Item {
    private int id;

    private static int contadorId;
    private String nombre;
    private double precio;


    public Item(String nombre, double precio){
        this.id= this.contadorId+=1;
        this.nombre=nombre;
        this.precio=precio;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public double calcularPrecioFinal(){
        return 0;
    }

}
