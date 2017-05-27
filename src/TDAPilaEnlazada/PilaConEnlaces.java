package TDAPilaEnlazada;

public class PilaConEnlaces<T> implements Stack<T> {
	
	private int size;
	private Nodo<T> head;
	
	/**Crea una nueva pila vacia
	 */
	public PilaConEnlaces() {
		size=0;
		head=null;
	}
	
	public void push(T t) {
		if (isEmpty()) {
			head= new Nodo<T>(t);
			size++;
		}
		else {
			Nodo<T> aux= new Nodo<T>(t);
			aux.setCompa(head);
			head=aux;
			size++;
		}
	}
	
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T res=head.getElem();
			head=head.getCompa();
			size--;
			return res;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public T top() throws EmptyStackException{
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return head.getElem();
		}
	}
}
