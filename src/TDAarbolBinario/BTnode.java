package TDAarbolBinario;
import java.io.Serializable;
public class BTnode<E> implements Position<E>,Serializable {
	private E element;
	private BTnode<E> left,rigth, parent;
	private boolean revisado=false;
	
	/**Crea un nuevo BTnode con rotulo element, padre parent, hijo izquierdo
	 * left e hijo derecho right*/
	public BTnode(E element, BTnode<E> parent, BTnode<E> left, BTnode<E> rigth){
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRigth(rigth);
	}
	
	/**Retorna el rotulo del BTnode
	 * @return elemento - E*/
	public E element(){return element;}
	/**Cambia el valor del rotulo por o
	 * @param nuevo elemento -E*/
	public void setElement(E o){element=o;}
	/**Retorna el hijo izquierdo del BTnode
	 * @return hijo izquierdo - BTnode<E>*/
	public BTnode<E> getLeft(){return left;}
	/**Cambia el hjijo izquierdo por a
	 * @param nuevo hijo - BTnode<E>*/
	public void setLeft(BTnode<E> a){left=a;}
	/**Retorna el hijo derecho del BTnode
	 * @return hijo derecho - BTnode<E>*/
	public BTnode<E> getRigth(){return rigth;}
	/**Cambia el hijo derecho por a
	 * @param nuevo hijo - BTnode<E>*/
	public void setRigth(BTnode<E> a){rigth=a;}
	/**Retorna el padre del BTnode
	 * @return padre - BTnode<E>*/
	public BTnode<E> getParent(){return parent;}
	/**Cambia el padre por a
	 * @param nuevo padre - BTnode<E>*/
	public void setParent(BTnode<E> a){parent=a;}
	
}
