/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author felip
 */
public class Pedido implements Comparable<Pedido> {

    private String autorPedido;
    private double precio;
    private int cercania;
    private boolean compararPorPrecio = true;

    public Pedido(String nombre, int precio, int cercania) {
        this.autorPedido = nombre;
        this.precio = precio;
        this.cercania = cercania;
    }
    
    public String getAutorPedido() {
        return autorPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCercania() {
        return cercania;
    }

    public void setCompararPorPrecio(boolean compararPorPrecio) {
        this.compararPorPrecio = compararPorPrecio;
    }

    @Override
     public int compareTo(Pedido o) {
        if (compararPorPrecio) {
            return Double.compare(o.precio, this.precio);
        } else {
            return Integer.compare(o.cercania, this.cercania);
        }
    }

    @Override
    public String toString() {
        return autorPedido + " $" + precio + " - cercanía " + cercania;
    }
}
