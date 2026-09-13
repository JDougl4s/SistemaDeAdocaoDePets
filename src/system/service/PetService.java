package system.service;

import system.domain.Pet;
import system.exceptions.NomeSobrenomeInvalidoException;

public class PetService {

    private Pet pet;

    public PetService() {
        this.pet = new Pet();
    }

    public void receberDadosPet(String[] dados) {
        String nome = dados[0];
        String sobreNome = dados[1];
        String tipoPet = dados[2];
        String sexo = dados[3];
        String endereco = dados[4];
        String idade = dados[5];
        String peso = dados[6];
        String raca = dados[7];
    }

    public void validarNomeSobrenome(String nomeSobrenome) {


    }
}
