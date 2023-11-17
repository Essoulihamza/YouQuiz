package ma.youcode.YouQuiz.exceptions;

public final class ResourceNotFoundException extends RuntimeException  {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
