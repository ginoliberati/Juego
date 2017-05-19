package Arbol;
import java.io.*;
import java.util.*;
import java.util.logging.*;
public class Logica  {
	private ArbolBinario<String> A;
	private Position<String> cursor;
	private boolean gano;
	
	/* *Crea un arbol binario A con raiz "una guitarra", y la asigna a 
	 * la posicion cursor*/
	public Logica() {
		try {
			A = new ArbolitoBinario<String>();
			A.createRoot("una guitarra");
			cursor=A.root();
			}
		 catch (EmptyTreeException | InvalidOperationException e) {
			System.out.println("Error: "+e.getMessage());}}
	
	
	
	
	
	/* *Genera una pregunta dado el contenido de la posicion cursor*/
	public String getPregunta() {
		return "Es "+cursor.element()+"?";
	}
	
	public String getElement() {
		return cursor.element();
	}
	
	/* *Mueve la posicion cursor hacia su hijo derecho.
	 * Se llama si el usuario responde "Si" en el juego.*/
	public void Si() {
		try {
			if (A.isExternal(cursor)){
				gano=true;
			} 
			else {
				cursor=A.right(cursor);
			}
		} catch (InvalidPositionException | BoundaryViolationException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	/* *Mueve la posicion cursor hacia su hijo izquierdo.
	 * Se llama si el usuario responde "No" en el juego*/
	public void No() {
		try {
			if (!A.isExternal(cursor)) {
				cursor=A.left(cursor); 
			}
		} catch(InvalidPositionException | BoundaryViolationException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	/* *Agrega el nodo con rotulo elem como hijo derecho de cursor, y el nodo
	 * con el elemento de cursor como su hijo izquierdo. Reemplaza el elemento de 
	 * cursor por diferencia
	 * @param elem - String
	 * @param diferencia - String*/
	public void Agregar(String elem, String diferencia) {
		try {
			A.addRight(cursor, elem);
			A.addLeft(cursor, cursor.element());
			A.replace(cursor, diferencia);
		} catch (InvalidPositionException | InvalidOperationException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	/* *Retorna un booleano que indica si la computadora gano
	 * @returns gano - boolean*/
	public boolean Gano() {
		return gano;
	}
	
	/* *Retorna un booleano que indica si la computadora perdio*/
	public boolean Perdio() {
		boolean b=false;
		try {
			b = !gano && A.isExternal(cursor);
		} catch(InvalidPositionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return b;
	}
	
	/* *Vuelve el cursor a su posicion inicial: la raiz del arbol*/
	public void reset() {
		try {
			gano=false;
			cursor = A.root();
		} catch(EmptyTreeException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	public void Guardar(){
		try{
		      //use buffering
		      OutputStream file = new FileOutputStream("/Users/GINO/Desktop/andar.caca");
		      OutputStream buffer = new BufferedOutputStream(file);
		      ObjectOutput output = new ObjectOutputStream(buffer);
		      try{
		        output.writeObject(A);
		      }
		      finally{
		        output.close();
		      }
		    }  
		    catch(IOException ex){
		      fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
		    }
  }
	private static final Logger fLogger =
		    Logger.getLogger(Logica.class.getPackage().getName());
}