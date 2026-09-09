package system.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Formulario {
    public static void exibirFormulario(){
        try (FileReader fileReader = new FileReader("C:\\Users\\newst\\Desktop\\maratona-java-virado-no-jiraya\\SistemasDeCadastros\\src\\system\\formulario.txt\\");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String linha;

            while((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
            }

        } catch (FileNotFoundException e){
            System.out.println("Error: Arquivo não encontrado");

        }catch (IOException e) {
            System.out.println("Erro genérico de Leitura/Escrita");
        }
    }
}
