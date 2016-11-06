
package Negocio;

public class BarException extends Exception{
    
     public BarException(Throwable cause) {
        super(cause);
    }

    public BarException(String message, Throwable cause) {
        super(message, cause);
    }

    public BarException(String message) {
        super(message);
    }

    public BarException() {
    }
    
}
