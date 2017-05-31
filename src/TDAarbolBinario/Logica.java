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
	/**
	 * Crea un arbol binario A con raiz "una guitarra", y la asigna a 
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
	 
	/**
	 * Genera una pregunta dado el contenido de la posicion cursor
	 * @return pregunta - String*/
	public String getPregunta() {
		return "\u00bf"+cursor.element()+"?";
	}
	
	/**
	 * Devuelve el rotulo de la posicion cursor
	 * @return rotulo - String*/
	public String getElement() {
		return cursor.element();
	}
	
	/**
	 * Mueve la posicion cursor hacia su hijo derecho.
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
	
	/**
	 * Mueve la posicion cursor hacia su hijo izquierdo.
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
	
	/**
	 * Agrega el nodo con rotulo elem como hijo derecho de cursor, y el nodo
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
	
	/**
	 * Retorna un booleano que indica si la computadora gano
	 * @return gano - boolean*/
	public boolean Gano() {
		return gano;
	}
	
	/**
	 * Retorna un booleano que indica si la computadora perdio
	 * @return perdio - boolean*/
	public boolean Perdio() {
		boolean b=false;
		try {
			b = !gano && A.isExternal(cursor);
		} catch(InvalidPositionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return b;
	}
	
	/**
	 * Vuelve el cursor a su posicion inicial: la raiz del arbol*/
	public void reset() {
		try {
			gano=false;
			cursor = A.root();
		} catch(EmptyTreeException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	/**
	 * Guarda el estado actual del arbol en un archivo arbol.ser en
	 * el directorio de ejecucion actual*/
	public void Guardar(){
	
		try (
			      OutputStream file = new FileOutputStream("arbol.ser");
			      OutputStream buffer = new BufferedOutputStream(file);
			      ObjectOutput output = new ObjectOutputStream(buffer);
			){
			     output.writeObject(A);
			    
			    }  
			    catch(IOException ex){
			      fLogger.log(Level.SEVERE, "Cannot perform output.", ex);
			    }
		
	}

	/**
	 * Retorna un entero representando la cantidad de objetos almacenados en el arbol
	 * @return cantObjetos - int*/
	public int cantObjetos() {
		return cantObjetos;
	}
	
	/**
	 * Retorna un entero representando la cantidad de preguntas almacenadas en el arbol
	 * @return cantPreguntas - int*/
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
	
	/**
	 * Retorna un entero representando la altura del arbol actual
	 * @return altura - int*/
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
	
	/**
	 * Recupera el estado interno del arbol guardado en arbol.ser en el directorio de
	 * ejecucion*/
	public void recuperar(){
		ArbolitoBinario<String > recuperado;
		
		try(
			      InputStream file = new FileInputStream("arbol.ser");
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
		cantObjetos=cantidadObjetos();
		
	}
	
	private static final Logger fLogger =
		    Logger.getLogger(Logica.class.getPackage().getName());
	
	/**
	 * Retorna un String con una descripcion de los objetos almacenados
	 * @return descripcion - String*/
	/*desde la posicion pasada por parametro, arma la oracion, sabiendo quien es el padre del nodo, y sabiendo si la posicion es hijo 
	izquierdo o derecho*/ 
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
						elemento+=", no "+padre.element();	
						
					}
				}
				else if(A.right(padre)==p) {
					if(A.isRoot(padre)){
						elemento+=" y "+padre.element();
						
					}
					else {
						elemento+=", "+padre.element();
						
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

	/*este recorrido en pre orden, agrega al final de la lista pasada como parametro, todos los nodo externos.
	 * el mismo es de manera recursiva.
	 */
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

	/**
	 * Modica la lista pasada por parametro agregando las oraciones de cada hoja.
	 * @param lista
	 * @throws InvalidPositionException
	 */
	/*llama a la recursion, y modifica la lista pasada por parametro.*/
	public void getInformacion (PositionList<String> lista)
			throws InvalidPositionException {
	try{	
			
			preOrdenInfo(A.root(), lista);
			}
		catch(EmptyTreeException e){System.out.println(e.getMessage());}
	}
	
	/* a traves de la recursion, recorre todo el arbol, y agrega a la lista los nodos internos.*/
	private void NodosInternos(Position<String> pos, PositionList<String> lista) {
		try{	if (A.isExternal(pos)) {}
	
			if (A.hasRight(pos) ) {
				NodosInternos(A.right(pos), lista);

				if(!A.isExternal(pos)&&!A.isRoot(pos)){lista.addLast(pos.element());}
				}
			if (A.hasLeft(pos) ) {
				NodosInternos(A.left(pos), lista);
				
			}
		}
		catch(BoundaryViolationException | InvalidPositionException e){System.out.println(e.getMessage());}
		
	}
			
	/**
	 * Retorna un pila con todos los nodos internos invertidos.
	 * @return Stack
	 * @throws InvalidPositionException
	 * @throws EmptyListException
	 * @throws EmptyTreeException
	 */
	
	/*devuele una pila con todos los nodos internos, para de esta manerla devolverla invertida*/
	public TDAPilaEnlazada.Stack<String> MostrarNodos()
				throws InvalidPositionException, EmptyListException, EmptyTreeException {
		TDAPilaEnlazada.Stack<String> pila=new PilaConEnlaces<String>();
		PositionList<String> lista=new ListaDoble<String>();
		NodosInternos(A.root(),lista);
		while(!lista.isEmpty()){pila.push(lista.first().element());
								lista.remove(lista.first());}
		return pila;
	}
	/**
	 * Devuelve una lista con todos los NodosInternos
	 * @return PositonList
	 * @throws EmptyTreeException
	 */
	/* devuelve una lista con todos lo nodos internos, llamando al metodo NodoInternos, con una lista y la raiz del arbol*/
	public PositionList<String> Internos() throws EmptyTreeException{
		PositionList<String> lista=new ListaDoble<String>();
		NodosInternos(A.root(),lista);
		return lista;
		}
	
	private Position<String> buscar(String nombre) {
		Iterator<Position<String>> it=A.positions().iterator();
		Position<String> pos=null; boolean encontro=false;
		
		while (it.hasNext() && !encontro) {
			pos=it.next();
			if (pos.element()==nombre) 
				encontro=true;
		}
		return pos;
	}
	
	/**
	 * Elimina el subarbol de raiz con rotulo nombre del arbol principal*/
	public void eliminarSubarbol(String nombre) {
		Position<String> pos=buscar(nombre);
		eliminar(pos);
		cantObjetos=cantidadObjetos();
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
						eliminar(A.right(pos));
						eliminar(pos);
					}
				}
			}
		} catch (InvalidPositionException | InvalidOperationException | BoundaryViolationException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	private int cantidadObjetos() {
		int cant=0;
		try {
			for (Position<String> pos:A.positions()) {
				if (A.isExternal(pos)) 
					cant++;
			}
		} catch(InvalidPositionException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return cant;
	}
}
	
