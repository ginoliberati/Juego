package TDAarbolBinario;
import java.io.*;
import java.util.*;
import java.util.Stack;
import java.util.logging.*;
import java.util.*;
import TDAListaDoble.*;
import TDAPilaEnlazada.*;
public class Logica implements Serializable {
	private ArbolitoBinario<String> A;
	private Position<String> cursor;
	private boolean gano;
	private PositionList<Position<String>> listaD;
	private int cantObjetos;
	/* *Crea un arbol binario A con raiz "una guitarra", y la asigna a 
	 * la posicion cursor*/
	public Logica() {
		try {
			A = new ArbolitoBinario<String>();
			A.createRoot("una guitarra");
			cursor=A.root();
			cantObjetos=1;}  
		 catch (EmptyTreeException | InvalidOperationException e) {
			System.out.println("Error: "+e.getMessage());}
		}
	 
	/* *Genera una pregunta dado el contenido de la posicion cursor*/
	public String getPregunta() {
		return "¿"+cursor.element()+"?";
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
			cantObjetos++;
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
		try (
			      OutputStream file = new FileOutputStream("/Users/GINO/Desktop/hola.ser");
			      OutputStream buffer = new BufferedOutputStream(file);
			      ObjectOutput output = new ObjectOutputStream(buffer);
			    ){
			     output.writeObject(A);
			     System.out.println("hola");
			    }  
			    catch(IOException ex){
			      fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
			    }
	}

	// esto es nuevo
	public int cantObjetos() {
		return cantObjetos;
	}
	
	public int cantPreguntas() {
		return cantObjetos-1;
	}
	
	private int Profundidad(Position<String> p) throws InvalidPositionException{
		if (A.isRoot(p)) {
			return 0;
		}
		else {
			BTnode<String> n = (BTnode<String>) p;
			return 1+Profundidad(n.getParent());
			}
	}

	public int Altura() {
		int h = 0;
		try {
			for(Position<String> v : A.positions())	
				if(A.isExternal(v)) h = Math.max(h, Profundidad(v));
		} catch( InvalidPositionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return h; 
	}
	public void recuperar(){
		ArbolitoBinario<String > recuperado;
		try(
			      InputStream file = new FileInputStream("/Users/GINO/Desktop/hola.ser");
			      InputStream buffer = new BufferedInputStream(file);
			      ObjectInput input = new ObjectInputStream (buffer);
			    ){
			      //deserialize the List
			 recuperado = (ArbolitoBinario<String>)input.readObject();
			      //display its data
			      for(String quark: recuperado){
			        System.out.println("Recovered Quark: " + quark);
			      }
			    }
			    catch(ClassNotFoundException ex){
			      fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
			      recuperado=null;
			    }
			    catch(IOException ex){
			      fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
			      recuperado=null;
			    }
		A=recuperado;
		
	}
	
	private static final Logger fLogger =
		    Logger.getLogger(Logica.class.getPackage().getName());

	private String informacion(Position<String> p) throws InvalidPositionException{
		String elemento= p.element();
		try {
			Position<String> padre;
			while(!A.isRoot(p)){
				padre = A.parent(p);
				if(A.left(padre)==p){
					if(A.isRoot(padre)){
						elemento+=" y no "+padre.element();
						
					}
					else {
						elemento+=" no "+padre.element();	
						
					}
				}
				else if(A.right(padre)==p) {
					if(A.isRoot(padre)){
						elemento+=" y "+padre.element();
						
					}
					else {
						elemento+=" "+padre.element();
						
					}
				}
				p=padre;
			}
			
		}
		catch (BoundaryViolationException e) {
			e.printStackTrace();
		}
		return elemento;
	}

	private void preOrdenInfo (Position<String> pos, PositionList<String> lista) {
		try{	if (A.isExternal(pos)) {
				lista.addLast(informacion(pos));}
	
			if (A.hasRight(pos) ) {
				preOrdenInfo(A.right(pos), lista);
			
			}
			if (A.hasLeft(pos) ) {
				preOrdenInfo(A.left(pos), lista);}
			}
		
		catch(BoundaryViolationException | InvalidPositionException e){System.out.println(e.getMessage());}
		
	}

	public void getInformacion (PositionList<String> lista)
			throws InvalidPositionException {
	try{	
			
			preOrdenInfo(A.root(), lista);
			}
		catch(EmptyTreeException e){System.out.println(e.getMessage());}
	}
	
	private void NodosInternos(Position<String> pos, PositionList<String> lista) {
		try{	if (A.isExternal(pos)) {}
	
			if (A.hasRight(pos) ) {
				NodosInternos(A.right(pos), lista);
				if(!A.isExternal(pos)){System.out.println("pene");
				lista.addLast(pos.element());}
				
			}
			if (A.hasLeft(pos) ) {
				NodosInternos(A.left(pos), lista);
				
			}
		}
		catch(BoundaryViolationException | InvalidPositionException e){System.out.println(e.getMessage());}
		
	}
			
	public TDAPilaEnlazada.Stack<String> MostrarNodos()
				throws InvalidPositionException, EmptyListException, EmptyTreeException {
		TDAPilaEnlazada.Stack<String> pila=new PilaConEnlaces<String>();
		PositionList<String> lista=new ListaDoble<String>();
		NodosInternos(A.root(),lista);
		while(!lista.isEmpty()){pila.push(lista.first().element());
								lista.remove(lista.first());}
		return pila;
	}
	
	private Position<String> buscar(String nombre) {
		Position<String> v=null;
		for (Position<String> e:A.positions()) {
			if (e.element()==nombre) {
				v=e;
			}
		}
		return v;
	}
	
	public void eliminarSubarbol(String nombre) {
		Position<String> pos=buscar(nombre);
		eliminar(pos);
	}
	
	private void eliminar(Position<String> pos) {
		try {
			if (!A.isExternal(pos)){
				if (A.hasLeft(pos)) {
					if (A.isExternal(A.left(pos))) {
						A.replace(pos, A.left(pos).element());
						A.remove(A.left(pos));
					} else {
						eliminar(A.left(pos));
						eliminar(pos);
					}
				}
				if (A.hasRight(pos)) {
					if (A.isExternal(A.right(pos))) {
						A.replace(pos, A.right(pos).element());
						A.remove(A.right(pos));
					} else {
						eliminar(A.left(pos));
						eliminar(pos);
					}
				}
			}
		} catch (InvalidPositionException | InvalidOperationException | BoundaryViolationException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
	
