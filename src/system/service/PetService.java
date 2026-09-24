package system.service;

import system.domain.Pet;
import system.domain.Sexo;
import system.domain.TipoPet;
import system.exceptions.*;

import java.util.ArrayList;

public class PetService {
    static final String NAO_INFORMADO = "NÃO INFORMADO";
    private Pet pet;


    public PetService() {
        this.pet = new Pet();
    }

    public void processarDadosPet(ArrayList<Object> dadosInput) throws DadoInvalidoException, EntradaVaziaException {

        validarNomeSobrenome((String) dadosInput.get(0), (String) dadosInput.get(1));
        validarTipoPet((String) dadosInput.get(2));
        validarSexo((String) dadosInput.get(3));
        validarEndereco((ArrayList<String>) dadosInput.get(4));
        validarIdade((String) dadosInput.get(5));

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

    public void validarSexo(String sexoInput) {

        //Verifica se a entrada está vazia, se sim lança exceção
        if (sexoInput.isBlank()) {
            throw new EntradaVaziaException("Sexo do pet não foi fornecido.");
        }
        //Verifica se a entrada NÃO É Femea && Macho, se for true lança exceção
        if (!StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.FEMININO.getSexo())) &&
                !StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.MASCULINO.getSexo()))) {
            throw new SexoInvalidoException();
        } else {
            //Verifica se a entrada é igual a Fêmea, se for atribui o valor Fêmea.
            if (StringUtils.removeAccents(sexoInput).equalsIgnoreCase(StringUtils.removeAccents(Sexo.FEMININO.getSexo()))) {
                this.pet.setSexo(Sexo.FEMININO);
            } else { //Se não for igual a Fêmea, atribui o valor Macho.
                this.pet.setSexo(Sexo.MASCULINO);
            }
        }
    }

    public void validarEndereco(ArrayList<String> enderecoInput) {
        //Tratamento Rua
        if (enderecoInput.get(0).isBlank()) {
            pet.getEndereco().setRua(NAO_INFORMADO);
        } else {
            pet.getEndereco().setRua(enderecoInput.get(0));
        }
        //Tratamento Numero da Casa
        if (enderecoInput.get(1).isBlank()) {
            pet.getEndereco().setNumeroCasa(NAO_INFORMADO);
        } else {
            pet.getEndereco().setNumeroCasa(enderecoInput.get(1));
        }
        //Tratamento Bairro
        if (enderecoInput.get(2).isBlank()) {
            pet.getEndereco().setBairro(NAO_INFORMADO);
        } else {
            pet.getEndereco().setBairro(enderecoInput.get(2));
        }
        //Tratamento Cidade
        if (enderecoInput.get(3).isBlank()) {
            pet.getEndereco().setCidade(NAO_INFORMADO);
        } else {
            pet.getEndereco().setCidade(enderecoInput.get(3));
        }
        System.out.println(pet.getEndereco().getRua());
        System.out.println(pet.getEndereco().getNumeroCasa());
        System.out.println(pet.getEndereco().getBairro());
        System.out.println(pet.getEndereco().getCidade());

    }

    public void validarIdade(String idadeInput) {
        //Verifica se entrada está vazia
        if (idadeInput.isBlank()) {
            pet.setIdade(null);
            return;
        }

        if (!idadeInput.matches("^\\d+([.,]\\d+)?$")) {
            throw new IdadeInvalidaException("Idade do pet deve conter apenas números.");
        }else{
            Double idadeConvertida;
            if (idadeInput.contains(",")){
                idadeInput = idadeInput.replace(",",".");
                idadeConvertida = Double.parseDouble(idadeInput);
            }else{
                idadeConvertida = Double.parseDouble(idadeInput);
            }

            if (idadeConvertida > 20){
                throw new IdadeInvalidaException("Não aceitamos pet com mais de 20 anos.");
            }


        }
    }
}