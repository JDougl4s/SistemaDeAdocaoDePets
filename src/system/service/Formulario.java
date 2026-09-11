package system.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Formulario {

    private BufferedReader bufferedReader;

    public Formulario(){
        try (FileReader fl = new FileReader(
                "C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\formulario.txt")){
            this.bufferedReader = new BufferedReader(fl);
        }catch (IOException e) {
            System.out.println("Error: Arquivo não encontrado");
        }
    }

    public String exibirPerguntas() {
        try {
            return bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("Erro genérico de Leitura/Escrita");
        }
        return null;
    }
}
