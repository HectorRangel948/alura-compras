package modelos;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> inventario = new ArrayList<>();

    public Inventario(Item item){
        this.inventario.add(item);
    }

    public void agregarItem(Item item){
        inventario.add(item);
    }

    public Item encontrarItem(int itemID){
        Item respuesta = new Item(null, 0.00);
        for(int i=0; i<inventario.size(); i++){
            if(inventario.get(i).getId()==itemID)
            {
                respuesta = inventario.get(i);
                return respuesta;
            }
        }
        return respuesta;
    }

    public String enlistarItems(){
        String respuesta="";
        for(int i=0; i<inventario.size(); i++){
            Item item = inventario.get(i);
            respuesta+="ID: %d - %s - $%.2f \n".formatted(item.getId(),item.getNombre(),item.calcularPrecioFinal());
        }
        return respuesta;
    }

    public int tamanioInventario(){
        return inventario.size();
    }

    @Override
    public String toString(){
        String allItems="";
        for(int i = 0; i<inventario.size(); i++ ){
            allItems+=inventario.get(i).toString()+"\n";
        }

        return allItems;

    }

}
