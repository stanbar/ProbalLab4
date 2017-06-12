public class Main {

    static double[][] results = new double[4][3];

    public static void main(String[] args) {
        double[] px = {0.3, 0.5, 0.2};
        double[] U1 = {1.0, 0.51, 0.4};
        for (int i = 0; i < 3; i++) {
            double prog = U1[i];
            double wynik = 0;
            double[] pu2u1pu2 = new double[3];
            double[] pu1mpu2 = new double[3];
            double suma = 0;
            double pu2 = (double) 1 / 3; // tutaj dlatego że mamy 3 wartości jakby prawdopodobienstw, plus tak nam mówił na zajęciach

            //Prawdopodobienstwo że P(x) znajdzie się w przedziale U1
            for (int j = 0; j < 3; j++) {
                pu2u1pu2[j] = px[j] / prog ; //tutaj chyba odliczamy to prawdopodobieństwo że U1 <= p(U1) czy  jakoś tak to było, sprawdź tam pod wynikami jest to napisane

                pu2u1pu2[j] = Math.min(1,pu2u1pu2[j]); //Nie może być większe od 1
                suma += pu2u1pu2[j]; // suma tego będzie potrzeba do obliczenia ogólnego prawdop... Czytaj 4 wypis, też sprawdź dokładnie
            }

            for (int j = 0; j < 3; j++) {
                results[j][i] = pu2u1pu2[j] / suma;
                // tutaj tak bo to warunkowe i tak jak w zadaniu chyba 2 trzeba dzielić przez prawdp ogólne, całościowe, czytaj chyba to było z bayesa
            }

            for (int j = 0; j < 3; j++) {
                pu1mpu2[j] = pu2 * pu2u1pu2[j]; // tutaj średnio pamiętam bo to mówił na labce ale właśnie tu jest te prawdp razy 0,3333 bo mamy 3 dane
                wynik += pu1mpu2[j]; // bo to było ogólne prawdopodobieństwo stąd suma
            }
            results[3][i] = wynik;
        }
        printResults(px,U1);
    }

    private static void printResults(double[] px, double[] U1) {
        StringBuilder stringBuilder = new StringBuilder("     |");
        for (int j = 0; j < 3; j++) {
            stringBuilder.append(String.format("%.2f ",px[j]));
        }
        stringBuilder.append("\nU1\\U2|");
        for (int j = 0; j < 3; j++) {
            stringBuilder.append(String.format(" %d   ",j));
        }
        stringBuilder.append("\n");
        for (int i = 0; i < 20; i++) {
            stringBuilder.append('-');
        }
        stringBuilder.append("\n");
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(i == 3 ? "Wynik|":String.format("%.2f |",U1[i]));
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(String.format("%.2f ",results[i][j]));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

}
