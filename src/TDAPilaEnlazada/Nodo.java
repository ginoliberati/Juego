package TDAPilaEnlazada;
public class Nodo<T> {
	
	private T elem;
	private Nodo<T> compa;
	
	/**Crea un nuevo nodo con rotulo e
	 * @param e - T
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public Nodo(T e) {
		elem=e;
		compa=null;
	}
	
	/**Retorna el rotulo del Nodo
	 * @return elem - T
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public T getElem() {
		return elem;
	}
	
	/**Cambia el Nodo asociado por nod
	 * @param nod - Nodo<T>
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public void setCompa(Nodo<T> nod) {
		compa=nod;
	}
	
	/**Retorna el nodo asociado
	 * @return compa - Nodo<T>
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public Nodo getCompa() {
		return compa;
	}
}
