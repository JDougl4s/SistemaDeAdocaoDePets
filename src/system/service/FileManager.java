package system.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private BufferedReader bufferedReader;

    public FileManager() {
        try {
            FileReader fl = new FileReader(
                    "C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\files\\formularioPerguntas.txt"
            );
            bufferedReader = new BufferedReader(fl);

        } catch (IOException e) {
            System.out.println("Error: Arquivo não encontrado");
        }
    }

    public FileManager(int indice) {
        if (indice == 4){
            try {
                FileReader fl = new FileReader(
                        "C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\files\\enderecoPerguntas.txt"
                );
                bufferedReader = new BufferedReader(fl);

            } catch (IOException e) {
                System.out.println("Error: Arquivo não encontrado");
            }
        }else{
            System.out.println("nao executado");
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

}

