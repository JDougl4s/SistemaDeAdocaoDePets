package system.cli;

import system.service.Formulario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

    public static void iniciarMenu(){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("==================================");
            System.out.println("            ADOPT-PETs            ");
            System.out.println("==================================");
            System.out.println("1 - Cadastrar um novo pet");
            System.out.println("2 - Alterar os dados do pet cadastrado");
            System.out.println("3 - Deletar um pet cadastrado");
            System.out.println("4 - Listar todos os pets cadastrados");
            System.out.println("5 - Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6 - Sair");
            System.out.println("==================================");

            System.out.print("Escolha uma opção: ");
            int opcao = 0;
            try {
                opcao = Integer.parseInt(sc.nextLine());

                if (opcao <= 0 || opcao > 6) {
                    System.out.println("Opção inválida, escolha novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Só aceitamos digito.");
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("A espera foi interrompida");
            }

            switch (opcao){
                case 1:
                    Formulario formulario = new Formulario();
                    String perguntas;
                    for (int i = 0; i < 2; i++) {
                        perguntas = formulario.exibirPerguntas();
                        System.out.println(perguntas);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }

        }


    }
}
