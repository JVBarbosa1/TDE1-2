package tde.exercicios;

public class ExercicioTDE4 {
    public static void main(String[] args) {
        int[] vetNum = {2, 3, 2, 5, 3, 7, 2, 5, 7, 7};

        for (int count = 0; count < vetNum.length; count++) {
            int countRepetido = 1;
            boolean repetido = false;

            for (int j = 0; j < count; j++) {
                if (vetNum[count] == vetNum[j]) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                for (int k = count + 1; k < vetNum.length; k++) {
                    if (vetNum[count] == vetNum[k]) {
                        countRepetido++;
                    }
                }
                System.out.println(vetNum[count] + " aparece " + countRepetido + " vezes");
            }
        }
    }
}
