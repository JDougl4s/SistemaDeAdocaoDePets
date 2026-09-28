package system.exceptions;

public class PesoInvalidoException extends DadoInvalidoException {
    public PesoInvalidoException() {
        super("Peso do pet invalido.");
    }

    public PesoInvalidoException(String message) {
        super(message);
    }
}
