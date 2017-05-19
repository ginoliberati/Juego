package Arbol;
import ListaDoble.*;

import java.io.Serializable;
import java.util.Iterator;
import java.util.*;
import java.util.logging.*;
public class ArbolitoBinario<E> implements ArbolBinario<E>,Serializable{
	protected BTnode<E> root;
	protected int size;
	/*Crea el Arbol Binario */
	public ArbolitoBinario(){
		root=null;
		size=0;}
	/*Retorna un booleano indicando si el arbol esta vacio.*/
	public boolean isEmpty(){return size==0;}
	
	/*Devuelve la raiz del arbol*/
	public Position<E> root() throws EmptyTreeException{
		if(root==null) throw new EmptyTreeException();
		return root;}
	
	/*Devuelve un iterable con los hijos de un nodo */
	 public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
		 PositionList<Position<E>> children= new ListaDoble<Position<E>>();
		try
		{ if(hasLeft(v)) children.addLast(left(v));
		 if(hasRight(v)) children.addLast(right(v));
		 	return children;}
		catch(BoundaryViolationException e){System.out.println(e.getMessage());return null;}
	 		}		
	
	 /*Retorna el hijo derecho del nodo a (si tiene)*/
	 public Position<E> right(Position <E> a) 
			 throws InvalidPositionException, BoundaryViolationException{
		 BTnode<E> aux=checkPosition(a);
		 Position<E> rightpos=aux.getRigth();
		 if(rightpos==null) throw new BoundaryViolationException("No hijo derecho");
		 return rightpos;}
	
	 /*Retorna un booleano indicando si el nodo a tiene hijo derecho*/
	public boolean hasRight(Position<E> a) throws InvalidPositionException{
		 BTnode<E> aux=checkPosition(a);
		 Position<E> rightpos=aux.getRigth();
		 return (rightpos!=null);}
	
	/*Retorna un booleano indicando si el nodo v es externo/hoja*/
	public boolean isExternal(Position<E> v) throws InvalidPositionException{
		BTnode<E> nodo = checkPosition( v );
	    return (nodo.getLeft()==null && nodo.getRigth()==null);}
	
	/*Remueve el nodo v si tiene cero o mas hijos*/
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
	/*Cambia el hijo derecho de un nodo, si el mismo esta vacio*/
	public Position<E> addRight(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		BTnode<E> nuevonod = new BTnode<E>(r, null, null, null);
		if (nod.getRigth()==null) {
			nod.setRigth(nuevonod);}
		else {
			throw new InvalidOperationException("El nodo ya tiene hijo derecho.");}
		size++;
		
		return nuevonod;}
	  
	
	/*Retorna un integer que indica la cantidad de nodos del arbol*/
	public int size() {
		return size;
	}
	/* retorna una coleccion iterable de un nodo del arbol*/
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> position= new ListaDoble<Position<E>>();
	 	try{ if(size!=0) preordenPosition(root(),position);
	 	return position;}
		catch(InvalidPositionException  | EmptyTreeException e){System.out.println(e.getMessage()); return null;}
	}
	/*crea la raiz del arbol si la misma no existe*/
	public Position<E> createRoot(E r) throws InvalidOperationException{
		if(size!=0) throw new InvalidOperationException("No puede crearse la raiz");
		BTnode<E> nodo=new BTnode(r,null,null,null);
		root=nodo;
		return nodo;
	}
	
	/* devuelve un iterador con los elementos de un nodo*/
	public Iterator<E> iterator() {
		Iterable<Position<E>> positions= positions();
		PositionList<E> elements= new ListaDoble<E>();
		for(Position<E> pos:positions)
			elements.addLast(pos.element());
		return elements.iterator();
		
		
	} 
	
	/*crea una lista almacenando los nodos en un subarbol de nodos*/
	protected void preordenPosition(Position<E> v,PositionList<Position<E>> pos)
						throws InvalidPositionException{
		pos.addLast(v);
	try{	if(hasLeft(v)) preordenPosition(left(v),pos);
		if(hasRight(v))preordenPosition(right(v),pos);}
	catch(BoundaryViolationException e){System.out.println(e.getMessage());}
	}
	
	/*Retorna el hijo izquierdo del nodo v (si tiene)*/
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod.getLeft()==null) {
			throw new BoundaryViolationException("El nodo no tiene hijo izquierdo.");
		}
		else {
			return nod.getLeft();
		}
	}
	
	/*Chequea si la posicion v corresponde a un nodo del arbol, si es asi, lo retorna*/
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
	
	/*Retorna un booleano indicando si el nodo v tiene hijo izquierdo*/
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod.getLeft()==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*Crea un nodo con elemento r y lo asigna como hijo izzquierdo de v*/
	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		BTnode<E> nuevonod = new BTnode<E>(r, null, null, null);
		
		if (nod.getLeft()==null) {
			nod.setLeft(nuevonod);
		}
		else {
			throw new InvalidOperationException("El nodo ya tiene hijo izquierdo.");
		}
		
		size++;
		return nuevonod;
	}
	
	/*Retorna el nodo padre de v*/
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTnode<E> nod = checkPosition(v);
		
		if (nod==root) {
			throw new BoundaryViolationException("El nodo pasado por parametro es la raiz.");
		}
		else {
			return nod.getParent();
		}
	}
	
	/*Retorna un booleano indicando si el nodo v es raiz*/
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		return nod==root;
	}
	
	/*Retorna un booleano indicando si el nodo v es interno*/
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		return nod.getLeft()!=null || nod.getRigth()!=null;
	}
	
	/*Reemplaza el elemento del nodo v por e, retorna el anterior elemento*/
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTnode<E> nod = checkPosition(v);
		
		E antiguo = nod.element();
		nod.setElement(e);
		
		return antiguo;
	}
	
	/*Agrega el arbol binario T1 como hijo izquierdo del nodo v, y el arbol binario T2 como hijo derecho de v*/
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
	7)createRoot();
	8)addrigth():

	*/
	
}
