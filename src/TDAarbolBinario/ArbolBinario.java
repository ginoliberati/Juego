package TDAarbolBinario;
import  java.io.Serializable;
public interface ArbolBinario<E> extends GTTree<E>,Serializable 
{
	
	
	 /**
	 * Devuelve la posici\u00f3n del hijo izquierdo de v.
	 * @param v Posici\u00f3n de un nodo.
	 * @return Posici\u00f3n del hijo izquierdo de v.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
	 * @throws BoundaryViolationException si v no tiene hijo izquierdo.
	 */
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	
	
	 /**
	 * Devuelve la posici\u00f3n del hijo derecho de v.
	 * @param v Posici\u00f3n de un nodo.
	 * @return Posici\u00f3n del hijo derecho de v.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.
	 * @throws BoundaryViolationException si v no tiene hijo derecho.
	 */
	public Position<E> right(Position<E> v)throws InvalidPositionException, BoundaryViolationException;

	
	 /**
	 * Testea si v tiene un hijo izquierdo.
	 * @param v Posici\u00f3n de un nodo.
	 * @return Verdadero si v tiene un hijo izquierdo y falso en caso contrario.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.	
	 */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException;
	
	
	
	 /**
	 * Testea si v tiene un hijo derecho.
	 * @param v Posici\u00f3n de un nodo.
	 * @return Verdadero si v tiene un hijo derecho y falso en caso contrario.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida.	
	 */
	public boolean hasRight(Position<E> v) throws InvalidPositionException;
	
	
	 /**
	 * Crea un nodo con r\u00f3tulo e como ra\u00edz del \u00e1rbol.
	 * @param E R\u00f3tulo que se asignar\u00e1 a la ra\u00edz del \u00e1rbol.
	 * @throws InvalidOperationException si el \u00e1rbol ya tiene un nodo ra\u00edz.
	 */
	public Position<E> createRoot(E r) throws InvalidOperationException;
	
	 /**
	 * Agrega un nodo con r\u00f3tulo r como hijo izquierdo de un nodo dado.
	 * @param r R\u00f3tulo del nuevo nodo.
	 * @param v Posici\u00f3n del nodo padre.
	 * @return La posici\u00f3n del nuevo nodo creado.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida o el \u00e1rbol est\u00e1 vac\u00edo.
	 * @throws InvalidOperationException si v ya tiene un hijo izquierdo.
	 */
	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException;
 
	 /**
	 * Agrega un nodo con r\u00f3tulo r como hijo derecho de un nodo dado.
	 * @param r R\u00f3tulo del nuevo nodo.
	 * @param v Posici\u00f3n del nodo padre.
	 * @return La posici\u00f3n del nuevo nodo creado.
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida o el \u00e1rbol est\u00e1 vac\u00edo.
	 * @throws InvalidOperationException si v ya tiene un hijo derecho.
	 */
	public Position<E> addRight(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException;
    
	 /**
	 * Elimina el nodo referenciado por una posici\u00f3n dada. Si el nodo tiene un \u00fanico hijo, el nodo eliminado ser\u00e1 reemplazado por su \u00fanico hijo.
	 * @param v Posici\u00f3n del nodo a eliminar.
	 * @return el r\u00f3tulo del nodo eliminado.
     * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida o el \u00e1rbol est\u00e1 vac\u00edo.
	 * @throws InvalidOperationException si el nodo a eliminar tiene mas de un hijo.
     */
	public E remove(Position<E> v) throws InvalidOperationException, InvalidPositionException;

	
	 /**
	 * Inserta a los \u00e1rboles T1 y T2 como sub\u00e1rboles hijos de la hoja v (izquierdo y derecho respectivamente).
	 * @param v Posici\u00f3n de una hoja del \u00e1rbol.
	 * @param T1 \u00e1rbol binario a insertar como hijo izquierdo de v.
	 * @param T2 \u00e1rbol binario a insertar como hijo derecho de v. 
	 * @throws InvalidPositionException si la posici\u00f3n pasada por par\u00e1metro es inv\u00e1lida o el \u00e1rbol est\u00e1 vac\u00edo, o v no corresponde a una hoja.
	 */
	//Pone a T1 y a T2 como sub\u00e1rboles de la hoja v, izquierdo y derecho respectivamente, si v no era hoja da InvalidPositionException.
	  
	public void attach(Position<E> r, ArbolBinario<E> T1, ArbolBinario<E> T2) throws InvalidPositionException;
	}

	