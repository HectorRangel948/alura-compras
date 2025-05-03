package modelos;

import java.util.ArrayList;

public class CarritoCompras {

    private ArrayList<Item> carrito = new ArrayList<>();

    private Inventario inventario;

    public CarritoCompras(Inventario inventario){
        this.inventario = inventario;
    }

    public void agregarAlCarrito(int itemID){
        Item agregar= inventario.encontrarItem(itemID);
        if(agregar.getNombre()!=null){
            carrito.add(agregar);
        }else{
            System.out.println("No se encontró el artículo seleccionado");
        }
    }

    public void eliminarItem(int itemId){
        ArrayList<Item> nuevaLista = new ArrayList<>();
        carrito.forEach(ite -> {
            if(ite.getId()!=itemId){
                nuevaLista.add(ite);
            }
            else{
                System.out.println("Se eliminó el artículo ID:%d %s".formatted(ite.getId(), ite.getNombre()));
            }
        }
        );
        carrito=nuevaLista;
    }

    public double obtenerTotal(){
        double total=0.0;

        for(int i=0; i<carrito.size();i++){
            total+=carrito.get(i).calcularPrecioFinal();
        }

        return total;
    }

    public boolean hacerCompra(Usuario usuario, double totalCompra){
        if(usuario.hacerCompra(totalCompra)){
            System.out.println("Nuevo saldo: $%.2f".formatted(usuario.getSaldo()));
            return true;
        }
        return false;
    }

    public String articulosEnCarrito(){
        String productos="";
        for(int i=0; i<carrito.size();i++){
            productos+="\n%s - $%.2f".formatted(carrito.get(i).getNombre(), carrito.get(i).calcularPrecioFinal());
        }
        productos+="\nTotal: $%.2f".formatted(obtenerTotal());
        return productos;
    }

    @Override
    public String toString(){
        String productos="";
        for(int i=0; i<carrito.size();i++){
            productos+=carrito.get(i)+"\n";
        }

        return productos + "Total: " + obtenerTotal();
    }
}
