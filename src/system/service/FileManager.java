package system.service;

import system.domain.Pet;
import system.domain.TipoFormulario;
import system.domain.TipoPet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    private BufferedReader bufferedReader;

    public FileManager() {

    }

    public FileManager(TipoFormulario tipoFormulario) {
        try {
            if (tipoFormulario == TipoFormulario.PRINCIPAL) {
                FileReader fl = new FileReader(
                        "C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\files\\formularioPerguntas.txt"
                );
                bufferedReader = new BufferedReader(fl);
            } else {
                FileReader fl = new FileReader(
                        "C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\files\\enderecoPerguntas.txt"
                );
                bufferedReader = new BufferedReader(fl);
            }

        } catch (IOException e) {
            System.out.println("Error: Arquivo não encontrado");
        }
    }

    public String exibirPerguntas() {
        try {
            return bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("Erro genérico de Leitura/Escrita");
            return null;
        }
    }

    public void salvarRespostas(Pet pet) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataFormatada = now.format(formatter);

        String nomeArquivo = dataFormatada + "-" + pet.getNome().toUpperCase();
        File file = new File("C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\petsCadastrados\\" + nomeArquivo + ".TXT");

        try (FileWriter fw = new FileWriter(file)) {

            fw.write("1 - " + pet.getNome() +" "+ pet.getSobreNome()+"\n");
            fw.write("2 - " + pet.getTipoPet().getNome() +"\n");
            fw.write("3 - " + pet.getSexo().getSexo()+"\n");
            fw.write("4 - " + pet.getEndereco().getRua()+", "+pet.getEndereco().getNumeroCasa()+
                    ", "+pet.getEndereco().getBairro()+ ", "+pet.getEndereco().getCidade()+"\n");
            fw.write("5 - " + pet.getIdade()+"\n");
            fw.write("6 - " + pet.getPeso()+"\n");
            fw.write("7 - " + pet.getRaca()+"\n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

