package TDAarbolBinario;
import java.lang.Iterable;
import java.util.Iterator;
public interface GTTree<E> extends Iterable<E> 
	{
		
		 /**
		 * Consulta la cantidad de nodos en el \u00e1rbol.
		 * @return Cantidad de nodos en el \u00e1rbol.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public int size();
		
		
		 /**
		 * Consulta si el \u00e1rbol est\u00e1 vac\u00edo.
		 * @return Verdadero si el \u00e1rbol est\u00e1 vac\u00edo, falso en caso contrario.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public boolean isEmpty();
		
		
		 /**
		 * Devuelve un iterador de los elementos almacenados en el \u00e1rbol en preorden.
		 * @return Iterador de los elementos almacenados en el \u00e1rbol.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public Iterator<E> iterator();
		
		/**
		 * Devuelve una colecci\u00f3n iterable de las posiciones de los nodos del \u00e1rbol.
		 * @return Colecci\u00f3n iterable de las posiciones de los nodos del \u00e1rbol.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public Iterable<Position<E>> positions() throws InvalidPositionException,BoundaryViolationException,EmptyTreeException;
		
		/**
		 * Reemplaza el elemento almacenado en la posici\u00f3n dada por el elemento pasado por par\u00e1metro. Devuelve el elemento reemplazado.
		 * @param v Posici\u00f3n de un nodo.
		 * @param e Elemento a reemplazar en la posici\u00f3n pasada por par\u00e1metro.
		 * @return Elemento reemplazado.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public E replace(Position<E> v, E e) throws InvalidPositionException;
		 
		/**
		 * Devuelve la posici\u00f3n de la ra\u00edz del \u00e1rbol.
		 * @return Posici\u00f3n de la ra\u00edz del \u00e1rbol.
		 * @throws EmptyTreeException si el \u00e1rbol est\u00e1 vac\u00edo.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public Position<E> root() throws EmptyTreeException;
		
		/**
		 * Devuelve la posici\u00f3n del nodo padre del nodo correspondiente a una posici\u00f3n dada.
		 * @param v Posici\u00f3n de un nodo.
		 * @return Posici\u00f3n del nodo padre del nodo correspondiente a la posici\u00f3n dada.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @throws B oundaryViolationException si la posici\u00f3n pasada por par\u00e1metro corresponde a la ra\u00edz del \u00e1rbol.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
		
		/**
		 * Devuelve una colecci\u00f3n iterable de los hijos del nodo correspondiente a una posici\u00f3n dada.
		 * @param v Posici\u00f3n de un nodo.
		 * @return Colecci\u00f3n iterable de los hijos del nodo correspondiente a la posici\u00f3n pasada por par\u00e1metro.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
		 
		/**
		 * Consulta si una posici\u00f3n corresponde a un nodo interno.
		 * @param v Posici\u00f3n de un nodo.
		 * @return Verdadero si la posici\u00f3n pasada por par\u00e1metro corresponde a un nodo interno, falso en caso contrario.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public boolean isInternal(Position<E> v) throws InvalidPositionException;
		
		/**
		 * Consulta si una posici\u00f3n dada corresponde a un nodo externo.
		 * @param v Posici\u00f3n de un nodo.
		 * @return Verdadero si la posici\u00f3n pasada por par\u00e1metro corresponde a un nodo externo, falso en caso contrario.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public boolean isExternal(Position<E> v) throws InvalidPositionException;
		
		/**
		 * Consulta si una posici\u00f3n dada corresponde a la ra\u00edz del \u00e1rbol.
		 * @param v Posici\u00f3n de un nodo.
		 * @return Verdadero, si la posici\u00f3n pasada por par\u00e1metro corresponde a la ra\u00edz del \u00e1rbol,falso en caso contrario.
		 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
		 * @author - Liberati Gino y Schroeder Franco
		 */
		public boolean isRoot(Position<E> v) throws InvalidPositionException;
}
