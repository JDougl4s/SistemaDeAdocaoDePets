package system.exceptions;

public class EntradaVaziaException extends RuntimeException {
    public EntradaVaziaException() {
        super("Nenhuma entrada fornecida.");
    }

    public EntradaVaziaException(String message) {
        super(message);
    }
}
