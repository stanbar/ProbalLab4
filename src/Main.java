public class Main {

    public static void main(String[] args) {
        double[][] results = new double[3][4];
        double[] px = {0.3, 0.5, 0.2};
        double[] U1 = {1.0, 0.51, 0.4};

        //For U1 inrange of [0,1]
        //P(YES , U2 = i) = P(YES | U2 = i) * P(U2 = i) = px/1 * 1/3
        double summ1 = 0;
        for (int i = 0; i < px.length; i++) {
            double probabilityOfYesAndX = calculatePTakForXEquals(px[i], U1[0]);
            results[0][i] = probabilityOfYesAndX;
            summ1 += probabilityOfYesAndX;
        }
        //P(YES) = ∑P(YES , U2 = i)
        results[0][3] = summ1;


        //For U1 inrange of [0,0.51]
        //P(YES , U2 = i) = P(YES | U2 = i) * P(U2 = i) = px/0.51 * 1/3
        double summ2 = 0;
        for (int i = 0; i < px.length; i++) {
            double probabilityOfYesAndX = calculatePTakForXEquals(px[i], U1[1]);
            results[1][i] = probabilityOfYesAndX;
            summ2 += probabilityOfYesAndX;
        }
        //P(YES) = ∑P(YES , U2 = i)
        results[1][3] = summ2;

        //For U1 inrange of [0,0.4]
        //P(YES , U2 = i) = P(YES | U2 = i) * P(U2 = i) = px/0.4 * 1/3
        double summ3 = 0;
        for (int i = 0; i < px.length; i++) {
            double probabilityOfYesAndX = calculatePTakForXEquals(px[i], U1[2]);
            results[2][i] = probabilityOfYesAndX;
            summ3 += probabilityOfYesAndX;
        }
        //P(YES) = ∑P(YES , U2 = i)
        results[2][3] = summ3;

        printResults(results,px, U1);
    }

    private static double calculatePTakForXEquals(double px, double range) {
        return Math.min(1, px / range) * 1 / 3;
    }

    private static void printResults(double[][] results, double[] px, double[] U1) {
        StringBuilder stringBuilder = new StringBuilder("      P(YES , X1 = U2i)");
        stringBuilder.append("\n").append("**************************").append("\n").append("     |");
        for (int j = 0; j < 4; j++) {
            stringBuilder.append(j == 3 ? "P(YES)" : String.format("%.2f ", px[j]));
        }
        stringBuilder.append("\nU1\\U2|");
        for (int j = 0; j < 4; j++) {
            stringBuilder.append(j == 3 ? "    " :String.format(" %d   ", j));
        }
        stringBuilder.append("\n");
        for (int i = 0; i < 20; i++) {
            stringBuilder.append('-');
        }
        stringBuilder.append("\n");
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(String.format("%.2f |", U1[i]));
            for (int j = 0; j < 4; j++) {
                stringBuilder.append(String.format("%.2f ", results[i][j]));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

}
