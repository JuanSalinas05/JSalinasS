/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estructuras;

/**
 *
 * @author felip
 * @param <T>
 */
public interface IHeap<T> {

	/**
	 * Agrega un elemento al heap
	 */
	public void add(T elemento);
	
	/**
	 * Retorna pero no remueve el elemento máximo/mínimo del heap.
	 * @return T elemento 
	 */
	public T peek();
	
	/**
	 * Retorna el elemento máximo/mínimo luego de removerlo del heap.
	 * @return T El elemento máximo/mínimo del heap
	 */
	public T poll();
	
	/**
	 * Retorna el número de elementos en el heap
	 * @return size Número de elementos en el heap
	 */
	public int size();
	
	/**
	 * Retorna true si el heap no tiene elementos; false de lo contrario.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Mueve el último elemento arriba en el arbol, mientras que sea necesario.
	 * Es usado para restaurar la condición de heap luego de inserción.
	 */
	void siftUp();
	
	/**
	 * Mueve la raíz abajo en el arbol, mientras que sea necesario.
	 * Es usado para restaurar la condición de heap luego de la eliminación o reemplazo.
	 */
	void siftDown();

}
