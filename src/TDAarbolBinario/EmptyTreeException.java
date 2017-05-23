package TDAarbolBinario;
import java.lang.Exception;
public class EmptyTreeException extends Exception {
	public EmptyTreeException() {
		super("El arbol esta vacio.");
	}
}
