package system.exceptions;

public class TipoPetInvalidoException extends DadoInvalidoException {
    public TipoPetInvalidoException() {
        super("O Tipo do pet está incorreto.");
    }

    public TipoPetInvalidoException(String message) {
        super(message);
    }
}
