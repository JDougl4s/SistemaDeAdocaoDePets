package system.exceptions;

public class DadoInvalidoException extends RuntimeException {
    public DadoInvalidoException() {
        super("Dados invalidos.");
    }

    public DadoInvalidoException(String message) {
        super(message);
    }
}
