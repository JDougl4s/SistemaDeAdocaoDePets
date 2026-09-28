package system.exceptions;

public class RacaInvalidaException extends DadoInvalidoException {
    public RacaInvalidaException() {
        super("Raça do pet invalida.");
    }

    public RacaInvalidaException(String message) {
        super(message);
    }
}
