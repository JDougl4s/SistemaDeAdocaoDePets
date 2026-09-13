package system.service;

import system.domain.Pet;
import system.exceptions.NomeInvalidoException;
import system.exceptions.NomeSobrenomeInvalidoException;
import system.exceptions.SobrenomeInvalidoException;

public class PetService {

    private Pet pet;

    public PetService() {
        this.pet = new Pet();
    }

    public void processarDadosPet(String[] dados) throws NomeSobrenomeInvalidoException {
        validarNomeSobrenome(dados[0], dados[1]);

        String tipoPet = dados[2];
        String sexo = dados[3];
        String endereco = dados[4];
        String idade = dados[5];
        String peso = dados[6];
        String raca = dados[7];
    }

    public void validarNomeSobrenome(String nome, String sobrenome) {
        //Verifica se ambos estao vazios e lança exceção generica
        if (!nome.isEmpty() || !sobrenome.isEmpty()) {
            //Validando nome e lança exceção especifica
            if (nome.isEmpty()) {
                throw new NomeInvalidoException();
            } else {
                if (!nome.matches("^[\\p{L} ]+$")) {
                    throw new NomeInvalidoException("Nome contém caracteres especiais");
                }
            }
            //Validando sobrenome e lança exceção especifica
            if (sobrenome.isEmpty()) {
                throw new SobrenomeInvalidoException();
            } else {
                if (!sobrenome.matches("^[\\p{L} ]+$")) {
                    throw new SobrenomeInvalidoException("Sobrenome contém caracteres especiais");
                }
            }

            this.pet.setNome(nome);
            System.out.println("TRUE");
            this.pet.setSobreNome(sobrenome);
            System.out.println("TRUE");
        }else{
            throw new NomeSobrenomeInvalidoException();
        }
    }
}
