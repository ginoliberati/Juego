package Arbol;

public class ArbolitoBinario<E> implements ArbolBinario<E> {
	protected BTnode<E> root;
	protected int size;
	/* crea el Arbol Binario */
	public ArbolitoBinario(){
		root=null;
		size=0;}
	/*  * retorna si el arbol esta vacio.*/

	public boolean IsEmpty(){return size==0;}
	
	/* devuelve la raiz.*/
	public Position<E> root() throws EmptyTreeException{
		if(root==null) throw new EmptyTreeException("Arbol vacio");
		return root;}
	/* devuelve un iterable con los hijos de un nodo */
	 public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException
	 	{ }
	/* retorna si el nodo es interior */
	 public boolean isExternal(Position<E> v) throws InvalidPositionException{
	  BTnode<E> nodo = checkPosition( v );
	 return nodo.getHijos().isEmpty();
	 }
	
	 /* retorna el hijo derecho de un nodo*/
	 public Position<E> right(Position <E> a) 
			 throws InvalidPositionException, BoundaryInvalidPosition{
		 BTnode<E> aux=checkPosition(a);
		 Position<E> rightpos=aux.getRigth();
		 if(rigthpos==null) throw new BoundaryViolationException("No hijo derecho");
		 return rigthpos;}
	
	 /*retorna si tiene nodo derecho*/
	public boolean hasRight(Position<E> a) throws InvalidPositionException{
		 BTnodo<E> aux=checkPosition(a);
		 Position<E> rightpos=auz.getRigth();
		 return (rigthpos!=null);}
	
	/* remueve un nodo con cero o mas hijos*/
	public E remove(Position<E> v) throws InvalidPositionException{
		BTnode<E> nodo=checkPosition(v);
		BTnode<E> leftpos=nodo.getLeft();
		BTnode<E> rigthpos=nodo.getRigth();
		if(leftpos!=null && rigthpos!=null) throw InvalidPositionException("no se puede remover nod con dos hijos");
		BTnode<E> ww;
		if()
		
		
		
	}
	
	
	
	
	
	
	
	/*
	
	/*
	 * 2)root();
	 
	3)children();
	4)sExternal();
	5)rigth();
	6)hasRigth();
	7)createRoot();
	8)addrigth():
	9)remove( 
	*/
	
}
