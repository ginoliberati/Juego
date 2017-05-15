package PilaEnlaza;

public interface Stack<T> {
	public void push(T t);
	public T pop() throws EmptyStackException;
	public boolean isEmpty();
	public T top() throws EmptyStackException;
	public int size();
}
