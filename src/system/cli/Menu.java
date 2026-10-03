package system.cli;

import system.domain.Pet;
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
        ArrayList<Pet> pets = new ArrayList<>();

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
            FileManager file = new FileManager();
            file.reconstrucaoPets();
            System.out.print("Escolha uma opção: ");
            String entrada = null;
            int opcao = 0;

            try {
                // Limpa " " no começo e fim de String e transforma String em Integer
                entrada = sc.nextLine().trim();
                opcao = Integer.parseInt(entrada);

                if (opcao <= 0 || opcao > 6) {
                    System.out.println("Opção inválida, escolha novamente.");
                }

            } catch (NumberFormatException e) {
                if (entrada == "") {
                    System.out.println("Digite uma das opções.");
                } else {
                    System.out.println("Só aceitamos digitos.");
                }
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
                        System.out.println(i + 1 + "- " + formularioPerguntas.exibirPerguntas());

                        if (i == 4) {
                            FileManager enderecoPerguntas = new FileManager(TipoFormulario.ENDERECO);
                            ArrayList<String> enderecos = new ArrayList<>();

                            for (int j = 0; j < 4; j++) {
                                System.out.println(enderecoPerguntas.exibirPerguntas());
                                enderecos.add(sc.nextLine().trim().replaceAll("\\s+", " "));

                            }

                            respostas.add(enderecos);
                            continue;
                        }

                        // Limpa " " no começo e fim de String e troca espaços duplicados por " "
                        respostas.add(sc.nextLine().trim().replaceAll("\\s+", " "));
                    }

                    PetService petService = new PetService();
                    FileManager teste = new FileManager();
                    try {
                        petService.processarDadosPet(respostas);
                        pets.add(petService.getPet());
                        teste.salvarRespostas(petService.getPet());
                        System.out.println("Pet cadastrado com sucesso!");
                    } catch (DadoInvalidoException | EntradaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Qual o tipo do animal:");
                    System.out.println("1 - Cachorro");
                    System.out.println("2 - Gato");

                    int opcaoTipo = 0;
                    int opcaoFirstCriterio = 0;
                    int opcaoSecondCriterio = 0;
                    try {
                        entrada = sc.nextLine().trim();
                        opcaoTipo = Integer.parseInt(entrada);

                        if (opcaoTipo < 1 || opcaoTipo > 2) {
                            System.out.println("Opção inválida, escolha novamente.");
                            break;
                        }

                        System.out.println("Qual o 1° criterio que deseja utiliza:");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Sobrenome");
                        System.out.println("3 - Sexo");
                        System.out.println("4 - Idade");
                        System.out.println("5 - Peso");
                        System.out.println("6 - Raça");
                        System.out.println("7 - Endereço");

                        entrada = sc.nextLine().trim();
                        opcaoFirstCriterio = Integer.parseInt(entrada);

                        if (opcaoFirstCriterio < 1 || opcaoFirstCriterio > 7) {
                            System.out.println("Opção inválida, escolha novamente.");
                            break;
                        }

                        System.out.println("Deseja ter um 2° criterio de pesquisa (0 - Sim | 1 - Não):");

                        entrada = sc.nextLine().trim();
                        int confirmaçao = Integer.parseInt(entrada);

                        if (confirmaçao == 0) {
                            System.out.println("Qual o 2° criterio que deseja utiliza:");
                            System.out.println("1 - Nome");
                            System.out.println("2 - Sobrenome");
                            System.out.println("3 - Sexo");
                            System.out.println("4 - Idade");
                            System.out.println("5 - Peso");
                            System.out.println("6 - Raça");
                            System.out.println("7 - Endereço");

                            entrada = sc.nextLine().trim();
                            opcaoSecondCriterio = Integer.parseInt(entrada);

                            System.out.println();

                            if (opcaoSecondCriterio < 1 || opcaoSecondCriterio > 7) {
                                System.out.println("Opção inválida, escolha novamente.");
                                break;
                            }
                        } else if (confirmaçao == 1) {
                            break;
                        } else {
                            System.out.println("Opção inválida, escolha novamente.");
                        }

                    } catch (NumberFormatException e) {
                        if (entrada.equals("")) {
                            System.out.println("Digite uma das opções.");
                        } else {
                            System.out.println("Só aceitamos digitos.");
                        }
                    }

                    System.out.println();
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