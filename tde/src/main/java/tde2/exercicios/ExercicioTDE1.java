package tde.exercicios;

public class ExercicioTDE1 {

    public static void main(String[] args) {

        int[] vetNum = {2, 5, 8, 9, 10, 13, 14, 21, 22, 33,
                         44, 55, 60, 71, 82, 91, 100, 111, 120, 131};

        int pares = 0, impares = 0;

        for (int num : vetNum) {

            if (num % 2 == 0) {

                pares++;

            } else {

                impares++;

            }

        }

        System.out.println("Pares: " + pares);

        System.out.println("Ímpares: " + impares);

    }

}
