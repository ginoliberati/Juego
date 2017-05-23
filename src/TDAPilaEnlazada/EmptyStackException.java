package TDAPilaEnlazada;
import java.lang.Exception;

public class EmptyStackException extends Exception {
	
	public EmptyStackException() {
		super("La pila esta vacia.");
	}
}
