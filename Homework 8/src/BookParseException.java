
public class BookParseException extends Exception {
    /**
     * Constructs a new BookNotFoundException with a specified
     * message
     *
     * @param message the message provided. The message is saved for later retrieval by
     *                the getMessage() method.
     */
    public BookParseException(String message) {
        super(message);
    }
}
