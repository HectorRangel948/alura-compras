package modelos;

public class Servicio extends Item{
    private final double IVAServicio = 0.03;

    public Servicio(String nombre, double precio){
        super(nombre, precio);
    }

    public double getIVAServicio(){
        return this.IVAServicio;
    }

    public double calcularPrecioConIva(double precio){
        return precio+(precio*this.IVAServicio);
    }

    public double calcularIva(double precio){
        return precio*this.IVAServicio;
    }

    @Override
    public double calcularPrecioFinal(){
        return calcularPrecioConIva(this.getPrecio());
    }

    @Override
    public String toString(){
        return """
                ID: %d
                Servicio: %s
                Precio: %.2f 
                IVA :%.2f (%.0f%%) 
                Final: $%.2f
                """.formatted(
                        this.getId(),
                this.getNombre(),
                this.getPrecio(),
                calcularIva(this.getPrecio()),
                this.IVAServicio*100,
                calcularPrecioConIva(this.getPrecio())
        );
    }
}
