package tde.exercicios;

import java.util.Scanner;

public class ExercicioTDE2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetNum = {5, 8, 12, 7, 19, 3, 22, 15, 9, 30};

        System.out.print("Digite um número : ");
        int encontrar = scanner.nextInt();

        boolean encontrado = false;
        for (int count = 0; count < vetNum.length; count++) {
            if (vetNum[count] == encontrar) {
                System.out.println("Encontrado na posição: " + count);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Número não encontrado.");
        }

        scanner.close();
    }
}
