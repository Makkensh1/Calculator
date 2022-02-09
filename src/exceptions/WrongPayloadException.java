package exceptions;

public class WrongPayloadException extends Exception{

    public WrongPayloadException(String message) {
        super(message);
    }
}
