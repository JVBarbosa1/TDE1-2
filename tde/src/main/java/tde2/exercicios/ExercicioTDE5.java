package tde.exercicios;

public class ExercicioTDE5 {
    public static void main(String[] args) {
        int[] vetNum = {2,93,42,32,22,12,177};

        for (int count = 0; count < vetNum.length - 1; count++) {
            for (int j = 0; j < vetNum.length - 1 - count; j++) {
                if (vetNum[j] > vetNum[j + 1]) {
                    int temp = vetNum[j];
                    vetNum[j] = vetNum[j + 1];
                    vetNum[j + 1] = temp;
                }
            }
        }

        System.out.println("Array ordenado:");
        for (int num : vetNum) {
            System.out.print(num + " ");
        }
    }
}
