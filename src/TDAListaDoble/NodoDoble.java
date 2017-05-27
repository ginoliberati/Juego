package TDAListaDoble;

import TDAarbolBinario.Position;

public class NodoDoble<E> implements Position<E> {
	E elem;
	NodoDoble<E> next;
	NodoDoble<E> prev;
	
	public NodoDoble(E e) {
		elem=e;
		next=null;
		prev=null;
	}
	
	public E element() {
		return elem;
	}
	
	public void setElement(E e) {
		elem=e;
	}
	
	public void setNext(NodoDoble<E> nod) {
		next=nod;
	}
	
	public void setPrev(NodoDoble<E> nod) {
		prev=nod;
	}
	
	public NodoDoble<E> getNext() {
		return next;
	}
	
	public NodoDoble<E> getPrev() {
		return prev;
	}
}
