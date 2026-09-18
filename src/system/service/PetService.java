package system.service;

import system.domain.Pet;
import system.domain.Sexo;
import system.domain.TipoPet;
import system.exceptions.*;

import java.util.ArrayList;

public class PetService {

    private Pet pet;

    public PetService() {
        this.pet = new Pet();
    }

    public void processarDadosPet(ArrayList<Object> dados) throws DadoInvalidoException, EntradaVaziaException{
        //validarNomeSobrenome(dados[0], dados[1]);
        //validarTipoPet(dados[2]);
        //validarSexo(dados[3]);

        //String endereco = dados[4];
        //String idade = dados[5];
        //String peso = dados[6];
        //String raca = dados[7];
    }

    public void validarNomeSobrenome(String nomeInput, String sobrenomeInput) {
        //Verifica se pelo menos um dos dois não está vazio
        if (!nomeInput.isBlank() || !sobrenomeInput.isBlank()) {
            //Validando nome e lança exceção especifica
            if (nomeInput.isBlank()) {
                throw new NomeInvalidoException();
            } else {
                if (!nomeInput.matches("^[\\p{L} ]+$")) {
                    throw new NomeInvalidoException("Nome contém caracteres especiais.");
                }
            }
            //Validando sobrenome e lança exceção especifica
            if (sobrenomeInput.isBlank()) {
                throw new SobrenomeInvalidoException();
            } else {
                if (!sobrenomeInput.matches("^[\\p{L} ]+$")) {
                    throw new SobrenomeInvalidoException("Sobrenome contém caracteres especiais.");
                }
            }
            //Se tudo for validado são atribuidos os valores
            this.pet.setNome(nomeInput);
            this.pet.setSobreNome(sobrenomeInput);
        } else { //Verifica se ambos estao vazios e lança exceção especifica
            throw new EntradaVaziaException("Nome ou Sobrenome não foram fornecidas.");
        }
    }

    public void validarTipoPet(String tipoPetInput) {
        //Verifica se tipoPet está vazio, se sim lança exceção especifica
        if (tipoPetInput.isBlank()) {
            throw new EntradaVaziaException("Tipo pet não foi fornecido.");
        }
        // Verifica se tipoPet não é igual a Gato && Cachorro, se for true lança exceção
        if (!tipoPetInput.equalsIgnoreCase(TipoPet.GATO.getNome()) &&
                !tipoPetInput.equalsIgnoreCase(TipoPet.CACHORRO.getNome())) {
            throw new TipoPetInvalidoException();
        } else {
            //Verifica se tipoPet é igual a Gato, se for atribui o valor gato.
            if (tipoPetInput.equalsIgnoreCase(TipoPet.GATO.getNome())) {
                this.pet.setTipoPet(TipoPet.GATO);
            } else {  //Se não for igual a gato, atribui o valor cachorro.
                this.pet.setTipoPet(TipoPet.CACHORRO);

            }
        }
    }

    public void validarSexo(String sexoInput){

        //Verifica se a entrada está vazia, se sim lança exceção
        if (sexoInput.isBlank()){
            throw new EntradaVaziaException("Sexo do pet não foi fornecido.");
        }
        //Verifica se a entrada NÃO É Femea && Macho, se for true lança exceção
        if (!StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.FEMININO.getSexo())) &&
                !StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.MASCULINO.getSexo()))){
            throw new SexoInvalidoException();
        }else{
            //Verifica se a entrada é igual a Fêmea, se for atribui o valor Fêmea.
            if (StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.FEMININO.getSexo()))){
                this.pet.setSexo(Sexo.FEMININO);
            }else{ //Se não for igual a Fêmea, atribui o valor Macho.
                this.pet.setSexo(Sexo.MASCULINO);
            }
        }
    }


}
