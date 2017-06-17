package TDAListaDoble;
import java.util.Iterator;

import TDAarbolBinario.BoundaryViolationException;
import TDAarbolBinario.InvalidPositionException;
import TDAarbolBinario.Position;
public class ListaDoble<E> implements PositionList<E> {
	NodoDoble<E> header;
	NodoDoble<E> trailer;
	int size;
	
	/**Crea una lista doble sin elementos
	 * @author - Liberati Gino y Schroeder Franco
	 */
	public ListaDoble() {
		header = new NodoDoble<E>(null);
		trailer = new NodoDoble<E>(null);
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public Position<E> first() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		
		return header.getNext();
	}
	
	public Position<E> last() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		
		return trailer.getPrev();
	}
	
	public void addFirst(E e) {
		NodoDoble<E> aux = new NodoDoble<E>(e);
		NodoDoble<E> aux2 = header.getNext();
		
		aux.setNext(aux2);
		aux2.setPrev(aux);
		header.setNext(aux);
		aux.setPrev(header);
		
		size++;
	}
	
	public void addLast(E e) {
		NodoDoble<E> aux = new NodoDoble<E>(e);
		NodoDoble<E> aux2 = trailer.getPrev();
		
		aux2.setNext(aux);
		aux.setPrev(aux2);
		aux.setNext(trailer);
		trailer.setPrev(aux);
		
		size++;
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		NodoDoble<E> nod = checkPosition(p);
		nod = nod.getNext();
		
		if (nod==trailer) {
			throw new BoundaryViolationException("p es la ultima posicion de la lista.");
		}
		
		return nod;
	}
	
	private NodoDoble<E> checkPosition(Position<E> p) throws InvalidPositionException {
		try {
			if (p==null) {
				throw new InvalidPositionException("La posicion es nula.");
			}
			if (p==header) {
				throw new InvalidPositionException("La posicion es invalida.");
			}
			if (p==trailer) {
				throw new InvalidPositionException("La posicion es invalida.");
			}
			
			return (NodoDoble<E>) p;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("La posicion es invalida.");
		}
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		NodoDoble<E> nod = checkPosition(p);
		nod = nod.getPrev();
		
		if (nod==header) {
			throw new BoundaryViolationException("p es la primera posicion de la lista.");
		}
		
		return nod;
	}
	
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> aux = checkPosition(p);
		NodoDoble<E> aux2 = aux.getNext();
		NodoDoble<E> nod = new NodoDoble<E>(e);
		
		aux.setNext(nod);
		nod.setPrev(aux);
		nod.setNext(aux2);
		aux2.setPrev(nod);
		
		size++;
	}
	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> aux = checkPosition(p);
		NodoDoble<E> aux2 = aux.getPrev();
		NodoDoble<E> nod = new NodoDoble<E>(e);
		
		nod.setNext(aux);
		aux.setPrev(nod);
		aux2.setNext(nod);
		nod.setPrev(aux2);
		
		size++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty()) {
			throw new InvalidPositionException("La lista esta vacia.");
		}
		
		NodoDoble<E> nod = checkPosition(p);
		NodoDoble<E> aux = nod.getNext();
		NodoDoble<E> aux2 = nod.getPrev();
		E elem = nod.element();
		
		aux2.setNext(aux);
		aux.setPrev(aux2);
		nod.setNext(null);
		nod.setPrev(null);
		
		size--;
		
		return elem;
	}
	
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if (isEmpty()) {
			throw new InvalidPositionException("La lista esta vacia.");
		}
		
		NodoDoble<E> nod = checkPosition(p);
		E elem = nod.element();
		
		nod.setElement(e);
		
		return elem;
	}
	
	/**Retorna un iterador con los elementos de la lista
	 * @return iterador - Iterator<E>
	 */
	public Iterator<E> iterator() {
		return new ElementIterator(this);
	}
	
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new ListaDoble<Position<E>>();
		
		if (!isEmpty()) {
			Position<E> p=null;
			try {
				p = first();
			} catch(EmptyListException e) {
				System.out.println("Error");
			}
			
			while (true) {
				lista.addLast(p);
				try {
					if (p==last()) {
						break;
					}
				} catch (EmptyListException z) {
					System.out.println("Error");
				}
				try {
					p=this.next(p);
				} catch(InvalidPositionException | BoundaryViolationException i) {
					System.out.println("Error");
				}
			}
		}
		
		return lista;
	}
}