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
	 public boolean 
	
	 /* retorna el hijo derecho de un nodo*/
	 public Position<E> right(Position <E> a) 
			 throws InvalidPositionException, BoundaryInvalidPosition{
		 BTnodo<E> aux=checkposition(a);
		 Position<E> rightpos=auz.getRigth();
		 if(rigthpos==null) throw new BoundaryViolationException("No hijo derecho");
		 return rigthpos;}
	
	 /*retorna si tiene nodo derecho*/
	public boolean hasRight(Position<E> a) throws InvalidPositionException{
		 BTnodo<E> aux=checkposition(a);
		 Position<E> rightpos=auz.getRigth();
		 return (rigthpos!=null);}
	
	
	
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
