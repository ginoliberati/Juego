package PilaEnlaza;
public class Nodo<T> {
	
	private T elem;
	private Nodo<T> compa;
	
	public Nodo(T e) {
		elem=e;
		compa=null;
	}
	
	public T getElem() {
		return elem;
	}
	
	public void setCompa(Nodo<T> nod) {
		compa=nod;
	}
	
	public Nodo getCompa() {
		return compa;
	}
}
