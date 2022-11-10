import java.util.Arrays;

public class LissageSignal {

    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);        
        int nbMesures = scanner.nextInt();  
        double diffMax = scanner.nextDouble();
        double[] mesures = new double[nbMesures];
        
        for (int i = 0; i < nbMesures; i++) {
            mesures[i] = scanner.nextDouble();
        }

    */
        double diffMax = 1.120;
        double[] mesures = new double[] {1.292, 1.343, 3.322, 4.789, -0.782, 7.313, 4.212};


        System.out.printf("%d", getLissageNumber(mesures, diffMax));

    }
    
    private static int getLissageNumber(double[] mesures, double diffMax) {

        if (checksProperty(mesures, diffMax)) return 0;

        double[] handle = lissage(mesures);
        int lissagesNumber = 1;

        while(!checksProperty(handle, diffMax)) {
            handle = lissage(handle);
            lissagesNumber++;
        }
        return lissagesNumber;
    }


    private static double[] lissage(double[] mesures) {
        double[] output = new double[mesures.length];
        output[0] = mesures[0];
        output[mesures.length - 1] = mesures[mesures.length - 1];
        for (int i = 1; i < mesures.length - 1; i++) {
            output[i] = (mesures[i - 1] + mesures[i + 1]) / 2;
        }
        return output;
    }
    
    private static boolean checksProperty(double[] mesures, double diffMax) {
        for (int i = 1; i < mesures.length; i++) {
            if (Math.abs(mesures[i - 1] - mesures[i]) > diffMax) return false;
        }
        return true;
    }


}
