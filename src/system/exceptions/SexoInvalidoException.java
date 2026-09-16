package system.exceptions;

public class SexoInvalidoException extends DadoInvalidoException {
    public SexoInvalidoException() {
        super("Sexo do pet está incorreto.");
    }

    public SexoInvalidoException(String message) {
        super(message);
    }
}
