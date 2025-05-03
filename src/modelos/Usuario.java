package modelos;

public class Usuario {
    private int id;
    private static int contadorId=0;
    private String nombre;
    private String apellido;
    private double saldo;

    public Usuario(String nombre, String apellido, double saldo){
        this.id=contadorId++;
        this.nombre=nombre;
        this.apellido=apellido;
        this.saldo=saldo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public boolean hacerCompra(double precio){
        double nuevoSaldo= this.saldo -precio;
        if(nuevoSaldo>=0){
            setSaldo(nuevoSaldo);
            System.out.println("Compra aprobada");
            return true;

        }else{
            System.out.println("Saldo insuficiente");
        }
        return false;
    }

}
