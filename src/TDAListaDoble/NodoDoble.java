package TDAListaDoble;

import TDAarbolBinario.Position;

public class NodoDoble<E> implements Position<E> {
	E elem;
	NodoDoble<E> next;
	NodoDoble<E> prev;
	
	/**Crea un NodoDoble con rotulo e y next y prev nulos
	 * @param e - E
	 */
	public NodoDoble(E e) {
		elem=e;
		next=null;
		prev=null;
	}
	
	/**Retorna el rotulo del NodoDoble
	 * @return elem - E
	 */
	public E element() {
		return elem;
	}
	
	/**Cambia el rotulo del NodoDoble por e
	 * @param e - E
	 */
	public void setElement(E e) {
		elem=e;
	}
	
	/**Cambia el siguiente del NodoDoble por nod
	 * @param nod - NodoDoble<E>
	 */
	public void setNext(NodoDoble<E> nod) {
		next=nod;
	}
	
	/**Cambia el anterior del NodoDoble por nod
	 * @param nod - NodoDoble<E>
	 */
	public void setPrev(NodoDoble<E> nod) {
		prev=nod;
	}
	
	/**Retorna el siguiente del NodoDoble
	 * @return next - NodoDoble<E>
	 */
	public NodoDoble<E> getNext() {
		return next;
	}
	
	/**Retorna el anterior del NodoDoble
	 * @return prev - NodoDoble<E>
	 */
	public NodoDoble<E> getPrev() {
		return prev;
	}
}