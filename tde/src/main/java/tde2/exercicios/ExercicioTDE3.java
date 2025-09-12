package tde.exercicios;

import java.util.Scanner;

public class ExercicioTDE3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vetNomes = {"Fábio", "Guga", "Thiago Silva", "Freytes", "Rene", "Martinelli","Hercules","Nonato","Cannobio","Everaldo"};

        System.out.print("Digite um nome para remover o jogador: ");
        String excluirJogador = scanner.nextLine();

        boolean encontrado = false;
        for (int count = 0; count < vetNomes.length; count++) {
            if (vetNomes[count].equalsIgnoreCase(excluirJogador)) {
                vetNomes[count] = "---";
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Nome removido com sucesso!");
        } else {
            System.out.println("Nome não encontrado.");
        }

        System.out.println("Atualizado:");
        for (String nome : vetNomes) {
            System.out.print(nome + " ");
        }

        scanner.close();
    }
}
