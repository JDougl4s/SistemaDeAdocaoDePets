package system.exceptions;

public class NomeInvalidoException extends NomeSobrenomeInvalidoException {
    public NomeInvalidoException() {
        super("Nome não foi informado.");
    }

    public NomeInvalidoException(String message) {
        super(message);
    }
}
