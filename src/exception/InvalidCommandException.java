package exception;

public class InvalidCommandException extends Throwable {
    public InvalidCommandException(String s) {
        super(s);
    }
}
