package TDAarbolBinario;
import java.io.Serializable;
public class BTnode<E> implements Position<E>,Serializable {
	private E element;
	private BTnode<E> left,rigth, parent;
	private boolean revisado=false;
	
	/**Crea un nuevo BTnode con rotulo element, padre parent, hijo izquierdo
	 * left e hijo derecho right
	 * @param element - E
	 * @param parent - BTnode<E>
	 * @param left - BTnode<E>
	 * @param rigth - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public BTnode(E element, BTnode<E> parent, BTnode<E> left, BTnode<E> rigth){
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRigth(rigth);
	}
	
	/**Retorna el rotulo del BTnode
	 * @return elemento - E
	 * @author - Liberati Gino y Schroeder Franco*/
	public E element(){return element;}
	/**Cambia el valor del rotulo por o
	 * @param o - E
	 * @author - Liberati Gino y Schroeder Franco*/
	public void setElement(E o){element=o;}
	/**Retorna el hijo izquierdo del BTnode
	 * @return hijoIzquierdo - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public BTnode<E> getLeft(){return left;}
	/**Cambia el hijo izquierdo por a
	 * @param a - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public void setLeft(BTnode<E> a){left=a;}
	/**Retorna el hijo derecho del BTnode
	 * @return hijoDerecho - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public BTnode<E> getRigth(){return rigth;}
	/**Cambia el hijo derecho por a
	 * @param a - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public void setRigth(BTnode<E> a){rigth=a;}
	/**Retorna el padre del BTnode
	 * @return padre - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public BTnode<E> getParent(){return parent;}
	/**Cambia el padre por a
	 * @param a - BTnode<E>
	 * @author - Liberati Gino y Schroeder Franco*/
	public void setParent(BTnode<E> a){parent=a;}
	
}
