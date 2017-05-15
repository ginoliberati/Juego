package Arbol;
import java.lang.Exception;
public class InvalidOperationException extends Exception {
	public InvalidOperationException(String msg) {
		super(msg);
	}
}
