package TDAListaDoble;
import java.lang.Exception;

public class EmptyListException extends Exception {
	public EmptyListException() {
		super("La lista esta vacia.");
	}
}
