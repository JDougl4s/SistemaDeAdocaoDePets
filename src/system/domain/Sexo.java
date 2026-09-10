package system.domain;

public enum Sexo {
    FEMININO("Fêmea"),
    MASCULINO("Macho");

    private final String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
