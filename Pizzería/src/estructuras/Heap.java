/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author felip
 */
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements IHeap<T> {

    private ArrayList<T> elementos;
    private boolean esMaxHeap;

    public Heap(boolean esMaxHeap) {
        this.elementos = new ArrayList<>();
        this.esMaxHeap = esMaxHeap;
    }
    
    public boolean EsMaxHeap() {
        return esMaxHeap;
    }

    @Override
    public void add(T elemento) {
        elementos.add(elemento);
        siftUp();
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return elementos.get(0);
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;

        T resultado = elementos.get(0);
        int ultimoIndice = elementos.size() - 1;

        elementos.set(0, elementos.get(ultimoIndice));
        elementos.remove(ultimoIndice);

        siftDown();
        return resultado;
    }

    @Override
    public int size() {
        return elementos.size();
    }

    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    @Override
    public void siftUp() {
        int i = elementos.size() - 1;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (comparar(elementos.get(i), elementos.get(padre))) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    @Override
    public void siftDown() {
        int i = 0;
        int size = elementos.size();

        while (i < size) {
            int hijoIzq = 2 * i + 1;
            int hijoDer = 2 * i + 2;
            int hijoPrioridad = i;

            if (hijoIzq < size && comparar(elementos.get(hijoIzq), elementos.get(hijoPrioridad))) {
                hijoPrioridad = hijoIzq;
            }

            if (hijoDer < size && comparar(elementos.get(hijoDer), elementos.get(hijoPrioridad))) {
                hijoPrioridad = hijoDer;
            }

            if (hijoPrioridad != i) {
                intercambiar(i, hijoPrioridad);
                i = hijoPrioridad;
            } else {
                break;
            }
        }
    }

    private boolean comparar(T a, T b) {
        int cmp = a.compareTo(b);
        return esMaxHeap ? cmp < 0 : cmp > 0;
    }

    private void intercambiar(int i, int j) {
        T tmp = elementos.get(i);
        elementos.set(i, elementos.get(j));
        elementos.set(j, tmp);
    }

    public ArrayList<T> obtenerElementos() {
        return new ArrayList<>(elementos);
    }

    
    
    
}
