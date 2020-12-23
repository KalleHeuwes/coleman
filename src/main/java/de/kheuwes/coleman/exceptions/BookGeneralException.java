package de.kheuwes.coleman.exceptions;

public class BookGeneralException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookGeneralException() {
        super("Fehler BookGeneralException");
    }
	public BookGeneralException(String message, Throwable cause) {
        super(message, cause);
    }
}
