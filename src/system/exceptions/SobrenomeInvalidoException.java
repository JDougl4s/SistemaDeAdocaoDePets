package system.exceptions;

public class SobrenomeInvalidoException extends NomeSobrenomeInvalidoException {
    public SobrenomeInvalidoException() {
        super("Sobrenome não foi informado.");
    }

    public SobrenomeInvalidoException(String message) {
        super(message);
    }
}
