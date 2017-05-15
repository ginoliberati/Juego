package Arbol;

public class BTnode<E> implements Position<E> {
	private E element;
	private BTnode<E> left,rigth, parent;
	
	public BTnode(E element, BTnode<E> parent, BTnode<E> left, BTnode<E> rigth){
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRigth(rigth);
	}
	public E element(){return element;}
	public void setElement(E o){element=o;}
	public Position<E> getLeft(){return left;}
	public void setLeft(BTnode<E> a){left=a;}
	public Position<E> getRigth(){return rigth;}
	public void setRigth(BTnode<E> a){rigth=a;}
	public Position<E> getParent(){return parent;}
	public void setParent(BTnode<E> a){parent=a;}
}
