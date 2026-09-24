package system.exceptions;

public class IdadeInvalidaException extends DadoInvalidoException {
    public IdadeInvalidaException() {
        super("Idade do pet invalida.");
    }

    public IdadeInvalidaException(String message) {
        super(message);
    }
}
