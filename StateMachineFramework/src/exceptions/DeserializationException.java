package exceptions;

/**
 * A custom exception for errors occurring during the deserialization of an object.
 */
public class DeserializationException extends Exception {	
	private static final long serialVersionUID = 2L;
	
    public DeserializationException() {}

    public DeserializationException(String message) {
       super(message);
    }
}
