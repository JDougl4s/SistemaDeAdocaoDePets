package system.domain;

public enum TipoPet {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    PASSARO("Passaro");

    private final String nome;

    TipoPet(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
