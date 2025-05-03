package modelos;

public class Producto extends Item{
    private final double IVAProducto=0.05;

    public Producto(String nombre, double precio){
        super(nombre,precio);
    }

    public double getIVAProducto(){
        return this.IVAProducto;
    }

    public double calcularPrecioConIva(double precio){
        return precio+(precio*this.IVAProducto);
    }

    public double calcularIva(double precio){
        return precio*this.IVAProducto;
    }

    @Override
    public double calcularPrecioFinal(){
        return calcularPrecioConIva(this.getPrecio());
    }

    @Override
    public String toString(){
        return """
                ID: %d
                Producto: %s
                Precio: %.2f 
                IVA :%.2f (%.0f%%) 
                Final: $%.2f
                """.formatted(
                        this.getId(),
                        this.getNombre(),
                        this.getPrecio(),
                        calcularIva(this.getPrecio()),
                        this.IVAProducto*100,
                        calcularPrecioFinal()
                );
    }
}
