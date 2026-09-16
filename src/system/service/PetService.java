package system.service;

import system.domain.Pet;
import system.domain.TipoPet;
import system.exceptions.*;

public class PetService {

    private Pet pet;

    public PetService() {
        this.pet = new Pet();
    }

    public void processarDadosPet(String[] dados) throws NomeSobrenomeInvalidoException, TipoPetInvalidoException , EntradaVaziaException{
        validarNomeSobrenome(dados[0], dados[1]);
        validarTipoPet(dados[2]);

        String sexo = dados[3];
        String endereco = dados[4];
        String idade = dados[5];
        String peso = dados[6];
        String raca = dados[7];
    }

    public void validarNomeSobrenome(String nome, String sobrenome) {
        //Verifica se pelo menos um dos dois não está vazio
        if (!nome.isBlank() || !sobrenome.isBlank()) {
            //Validando nome e lança exceção especifica
            if (nome.isBlank()) {
                throw new NomeInvalidoException();
            } else {
                if (!nome.matches("^[\\p{L} ]+$")) {
                    throw new NomeInvalidoException("Nome contém caracteres especiais.");
                }
            }
            //Validando sobrenome e lança exceção especifica
            if (sobrenome.isBlank()) {
                throw new SobrenomeInvalidoException();
            } else {
                if (!sobrenome.matches("^[\\p{L} ]+$")) {
                    throw new SobrenomeInvalidoException("Sobrenome contém caracteres especiais.");
                }
            }
            //Se tudo for validado são atribuidos os valores
            this.pet.setNome(nome);
            this.pet.setSobreNome(sobrenome);
        } else { //Verifica se ambos estao vazios e lança exceção especifica
            throw new EntradaVaziaException("Nome ou Sobrenome não foram fornecidas.");
        }
    }

    public void validarTipoPet(String tipoPet) {
        //Verifica se tipoPet está vazio, se sim lança exceção especifica
        if (tipoPet.isBlank()) {
            throw new EntradaVaziaException("Tipo pet não foi fornecido.");
        }
        // Verifica se tipoPet não é igual a Gato && Cachorro, se for true lança exceção
        if (!tipoPet.equalsIgnoreCase(TipoPet.GATO.getNome()) &&
                !tipoPet.equalsIgnoreCase(TipoPet.CACHORRO.getNome())) {
            throw new TipoPetInvalidoException();
        } else {
            //Verifica se tipoPet é igual a Gato, se não é igual a Cachorro, ai os valores são atribuidos.
            if (tipoPet.equalsIgnoreCase(TipoPet.GATO.getNome())) {
                this.pet.setTipoPet(TipoPet.GATO);
            } else {
                this.pet.setTipoPet(TipoPet.CACHORRO);
            }
        }
    }

}
