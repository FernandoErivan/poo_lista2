package ZOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Zoologico zoologico = new Zoologico();

        int opcao = 0;

        while (opcao != 6) {

            System.out.println("\n===== ZOOLÓGICO =====");
            System.out.println("1. Adicionar animal");
            System.out.println("2. Listar todos os animais");
            System.out.println("3. Remover animal");
            System.out.println("4. Emitir som de um animal");
            System.out.println("5. Testar habilidade de um animal");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                System.out.println("\n--- Adicionar Animal ---");
                System.out.println("1. Gato");
                System.out.println("2. Cachorro");
                System.out.println("3. Passaro");
                System.out.print("Escolha o tipo: ");

                int tipo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("ID: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                if (zoologico.buscarAnimal(id) != null) {

                    System.out.println(
                        "Erro: já existe um animal com esse ID."
                    );

                } else {

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();

                    System.out.print("Peso: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();

                    Animal animal = null;

                    if (tipo == 1) {

                        animal = new Gato(id, nome, idade, peso);

                    } else if (tipo == 2) {

                        animal = new Cachorro(id, nome, idade, peso);

                    } else if (tipo == 3) {

                        animal = new Passaro(id, nome, idade, peso);

                    } else {

                        System.out.println("Tipo de animal inválido.");
                    }

                    if (animal != null) {

                        if (zoologico.adicionarAnimal(animal)) {
                            System.out.println(
                                "Animal adicionado com sucesso!"
                            );
                        } else {
                            System.out.println(
                                "Não foi possível adicionar o animal."
                            );
                        }
                    }
                }

            } else if (opcao == 2) {

                System.out.println("\n--- Lista de Animais ---");

                if (zoologico.listarAnimal().isEmpty()) {

                    System.out.println("Nenhum animal cadastrado.");

                } else {

                    for (Animal animal : zoologico.listarAnimal()) {

                        System.out.println("-------------------------");
                        System.out.println("ID: " + animal.getId());
                        System.out.println("Nome: " + animal.getNome());
                        System.out.println("Idade: " + animal.getIdade());
                        System.out.println("Peso: " + animal.getPeso());
                        System.out.println(
                            "Som: " + animal.emitirSom()
                        );
                        System.out.println(
                            "Habilidades: " +
                            animal.getHabilidades()
                        );
                    }
                }

            } else if (opcao == 3) {

                System.out.println("\n--- Remover Animal ---");

                System.out.print("Digite o ID do animal: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                boolean removido = zoologico.removerAnimal(id);

                if (removido) {

                    System.out.println("Animal removido: true");

                } else {

                    System.out.println("Animal removido: false");
                    System.out.println(
                        "Nenhum animal encontrado com esse ID."
                    );
                }

            } else if (opcao == 4) {

                System.out.println("\n--- Emitir Som ---");

                System.out.print("Digite o ID do animal: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                Animal animal = zoologico.buscarAnimal(id);

                if (animal != null) {

                    System.out.println(
                        animal.getNome() +
                        " diz " +
                        animal.emitirSom()
                    );

                } else {

                    System.out.println("Animal não encontrado.");
                }

            } else if (opcao == 5) {

                System.out.println("\n--- Testar Habilidade ---");

                System.out.print("Digite o ID do animal: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                Animal animal = zoologico.buscarAnimal(id);

                if (animal != null) {

                    System.out.print("Digite a habilidade: ");
                    String habilidade = scanner.nextLine();

                    System.out.println(
                        animal.realizarHabilidades(habilidade)
                    );

                } else {

                    System.out.println("Animal não encontrado.");
                }

            } else if (opcao == 6) {

                System.out.println("\nEncerrando o sistema...");

            // OPÇÃO INVÁLIDA
            } else {

                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
