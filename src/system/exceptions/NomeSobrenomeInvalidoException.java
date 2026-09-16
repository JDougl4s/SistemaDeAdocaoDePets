package system.exceptions;

public class NomeSobrenomeInvalidoException extends DadoInvalidoException {
    public NomeSobrenomeInvalidoException() {
        super("Nome ou Sobrenome invalidos.");
    }

    public NomeSobrenomeInvalidoException(String message) {
        super(message);
    }
}
