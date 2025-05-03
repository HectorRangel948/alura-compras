import modelos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int seleccion =0;
        boolean salir=false;

        Usuario miUsuario = new Usuario("Héctor", "Rangel", 50000.00);

        Producto iphone = new Producto("Smartphone Iphone", 7999.90);
        Producto camara = new Producto("Cámara Canon",5829.95);
        Producto laptop = new Producto("Laptop Lenovo", 9550.20);
        Servicio reparacion = new Servicio("Reparación de Celular", 1295.25);
        Servicio subscripcion = new Servicio("Membresía", 500);
        Servicio envioADomicilio = new Servicio("Envío a domicilio", 80);

        Inventario inventario = new Inventario(iphone);
        inventario.agregarItem(camara);
        inventario.agregarItem(laptop);
        inventario.agregarItem(reparacion);
        inventario.agregarItem(subscripcion);
        inventario.agregarItem(envioADomicilio);

        CarritoCompras miCarrito = new CarritoCompras(inventario);

        while(!salir){
            System.out.println("\nSaldo: $%.2f".formatted(miUsuario.getSaldo()));
            System.out.println("\nID: 0 - Salir");
            System.out.println(inventario.enlistarItems());
            System.out.println("ID: 9 - Pagar");

            System.out.println("\nArtículos en carrito: "+miCarrito.articulosEnCarrito());
            System.out.println("\nSelecciona el artículo que deseas agregar al carrito: ");
            try{
                seleccion= console.nextInt();
            }catch(Exception e){
                System.out.println(e);
            }
            if(seleccion==9){
                miCarrito.hacerCompra(miUsuario, miCarrito.obtenerTotal());
                System.out.println("Saldo: $%.2f".formatted(miUsuario.getSaldo()));
                salir=true;
            }else if(seleccion==0){
                salir=true;
            }
            else{
                miCarrito.agregarAlCarrito(seleccion);
            }
        }
    }
}
