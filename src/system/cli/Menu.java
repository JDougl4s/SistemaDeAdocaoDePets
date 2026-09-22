package system.cli;

import system.domain.TipoFormulario;
import system.exceptions.*;
import system.service.FileManager;
import system.service.PetService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

    public static void iniciarMenu() {
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
                //Limpa " " no começo e fim de String e transforma String em Integer
                opcao = Integer.parseInt(sc.nextLine().trim());

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

            switch (opcao) {
                case 1:
                    FileManager formularioPerguntas = new FileManager(TipoFormulario.PRINCIPAL);
                    ArrayList<Object> respostas = new ArrayList<>();

                    for (int i = 0; i < 8; i++) {
                        System.out.println(i+1+"- "+formularioPerguntas.exibirPerguntas());

                        if (i == 4){
                            FileManager enderecoPerguntas = new FileManager(TipoFormulario.ENDERECO);
                            ArrayList<String> enderecos = new ArrayList<>();
                            for (int j = 0; j < 4; j++) {
                                System.out.println(enderecoPerguntas.exibirPerguntas());
                                enderecos.add(sc.nextLine().trim().replaceAll("\\s+", " "));
                            }
                            respostas.add(enderecos);
                            continue;
                        }
                        //Limpa " " no começo e fim de String e troca espaços duplicados por " "
                        respostas.add(sc.nextLine().trim().replaceAll("\\s+", " "));
                    }
                    PetService petService = new PetService();

                    try {
                        petService.processarDadosPet(respostas);
                    } catch (DadoInvalidoException | EntradaVaziaException e){
                        System.out.println(e.getMessage());
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
