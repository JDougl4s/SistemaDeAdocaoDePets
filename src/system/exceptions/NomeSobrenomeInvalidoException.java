package system.exceptions;

public class NomeSobrenomeInvalidoException extends RuntimeException {
    public NomeSobrenomeInvalidoException() {
        super("Nome e sobrenome não foram informados.");
    }

    public NomeSobrenomeInvalidoException(String message) {
        super(message);
    }
}
