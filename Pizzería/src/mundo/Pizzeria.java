/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import estructuras.Heap;
/**
 *
 * @author felip
 */
import java.util.ArrayList;
import java.util.List;

public class Pizzeria {

    public static final String RECIBIR_PEDIDO = "RECIBIR";
    public static final String ATENDER_PEDIDO = "ATENDER";
    public static final String DESPACHAR_PEDIDO = "DESPACHAR";

    private Heap<Pedido> pedidosRecibidos;  // Max-Heap por precio
    private Heap<Pedido> colaDespachos;     // Min-Heap por cercanía

    public Pizzeria() {
        pedidosRecibidos = new Heap<>(true);
        colaDespachos = new Heap<>(false);
    }

    public void agregarPedido(String autor, double precio, int cercania) {
        Pedido pedidoPrecio = new Pedido(autor, (int) precio, cercania); // por precio

        pedidoPrecio.setCompararPorPrecio(pedidosRecibidos.EsMaxHeap());

        pedidosRecibidos.add(pedidoPrecio);

    }

    public Pedido atenderPedido() {
        Pedido pedidoAtendido = pedidosRecibidos.poll();
        pedidoAtendido.setCompararPorPrecio(colaDespachos.EsMaxHeap());
        colaDespachos.add(pedidoAtendido);
        return pedidoAtendido;
    }

    public Pedido despacharPedido() {
        return colaDespachos.poll();
    }

    public List<Pedido> pedidosRecibidosList() {
        if (pedidosRecibidos instanceof Heap) {
            return ((Heap<Pedido>) pedidosRecibidos).obtenerElementos();
        }
        return new ArrayList<>();
    }

    public List<Pedido> colaDespachosList() {
        if (colaDespachos instanceof Heap) {
            return ((Heap<Pedido>) colaDespachos).obtenerElementos();
        }
        return new ArrayList<>();
    }
}
