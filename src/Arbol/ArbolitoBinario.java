package Arbol;

public class ArbolitoBinario<E> implements ArbolBinario<E> {
	protected BTnode<E> root;
	protected int size;
	/* crea el Arbol Binario */
	public ArbolitoBinario(){
		root=null;
		size=0;}
	/*  * retorna si el arbol esta vacio.*/

	public boolean isEmpty(){return size==0;}
	
	/* devuelve la raiz.*/
	public Position<E> root() throws EmptyTreeException{
		if(root==null) throw new EmptyTreeException("Arbol vacio");
		return root;}
	/* devuelve un iterable con los hijos de un nodo */
	 public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException
	 	{ }
	
	
	 /* retorna el hijo derecho de un nodo*/
	 public Position<E> right(Position <E> a) 
			 throws InvalidPositionException, BoundaryViolationException{
		 BTnode<E> aux=checkPosition(a);
		 Position<E> rightpos=aux.getRigth();
		 if(rightpos==null) throw new BoundaryViolationException("No hijo derecho");
		 return rightpos;}
	
	 /*retorna si tiene nodo derecho*/
	public boolean hasRight(Position<E> a) throws InvalidPositionException{
		 BTnode<E> aux=checkPosition(a);
		 Position<E> rightpos=aux.getRigth();
		 return (rightpos!=null);}
	
	public boolean isExternal(Position<E> v) throws InvalidPositionException{
		BTnode<E> nodo = checkPosition( v );
	    return (nodo.getLeft()==null && nodo.getRigth()==null);
	}
	
	
	/* remueve un nodo con cero o mas hijos*/
	public E remove(Position<E> v) throws InvalidPositionException, InvalidOperationException{
		BTnode<E> nodo=checkPosition(v);
		BTnode<E> leftpos=nodo.getLeft();
		BTnode<E> rigthpos=nodo.getRigth();
		if(leftpos!=null && rigthpos!=null) throw new InvalidOperationException("no se puede remover nod con dos hijos");
		BTnode<E> ww;
		if(leftpos!=null) ww=leftpos;
		 else if(rigthpos!=null) ww=rigthpos;
		   else ww=null;
		if(nodo==root){
			if(ww!=null)
				ww.setParent(null);
				root=ww;}
		else {
			BTnode<E> uu=nodo.getParent();
			if(nodo==uu.getLeft()) uu.setLeft(ww);
				else uu.setRigth(ww);
			if(ww!=null) ww.setParent(uu);
		}
		size--;
		return v.element();
	}
	  
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> l = new MiLista<Position<E>>();
		if( !isEmpty() ) pre( l, raiz );
		return l;		
	 
	
	public int size() {
		return size;
	}
	
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod.getLeft()==null) {
			throw new BoundaryViolationException("El nodo no tiene hijo izquierdo.");
		}
		else {
			return nod.getLeft();
		}
	}
	
	public BTnode<E> checkPosition(Position<E> v) throws InvalidPositionException {
		if (v==null) {
			throw new InvalidPositionException("El nodo pasado por parametro es nulo.");
		}
		
		try {
			return (BTnode<E>) v;
		}
		catch (ClassCastException e) {
			throw new InvalidPositionException("El nodo pasado por parametro no es un nodo arbol.");
		}
	}
	
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod.getLeft()==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		BTnode<E> nuevonod = new BTnode<E>(r, null, null, null);
		
		if (nod.getLeft()!=null) {
			nod.setLeft(nuevonod);
		}
		else {
			throw new InvalidOperationException("El nodo ya tiene hijo izquierdo.");
		}
		
		size++;
		return nuevonod;
	}
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod==root) {
			throw new BoundaryViolationException("El nodo pasado por parametro es la raiz.");
		}
		else {
			return nod.getParent();
		}
	}
	
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		return nod==root;
	}
	
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		return nod.getLeft()!=null || nod.getRigth()!=null;
	}
	
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		E antiguo = nod.element();
		nod.setElement(e);
		
		return antiguo;
	}
	
	public void attach(Position<E> v, ArbolBinario<E> T1, ArbolBinario<E> T2) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		if (!(nod.getLeft()==null && nod.getRigth()==null)) {
			throw new InvalidPositionException("El nodo pasado por parametro no es hoja.");
		}
		
		try {
			BTnode<E> root1=checkPosition(T1.root());
			BTnode<E> root2=checkPosition(T2.root());
			nod.setLeft(root1);
			nod.setRigth(root2);
		}
		catch (EmptyTreeException e) {
			throw new InvalidPositionException("El arbol pasado por parametro esta vacio.");
		}
	}
	
	
	
	/*
	
	/*
	
	 
	3)children();
	7)createRoot();
	8)addrigth():

	*/
	
}
