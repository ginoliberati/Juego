package TDAPilaEnlazada;

public interface Stack<T> {
	/**Almacena un nuevo elemento t en la pila
	 * @param t - T
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public void push(T t);
	/**Elimina el elemento el tope de la pila y lo retorna
	 * @return tope - T
	 * @throws EmptyStackException - Si la pila esta vacia
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public T pop() throws EmptyStackException;
	/**Retorna un booleano indicando si la pila esta vacia o no
	 * @return estaVacia - boolean
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public boolean isEmpty();
	/**Retorna el tope de la pila
	 * @return tope - T
	 * @throws EmptyStackException - Si la pila esta vacia
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public T top() throws EmptyStackException;
	/**Retorna un entero indicando la cantidad de elementos de la pila
	 * @return cantElem - int
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public int size();
}