import java.util.Scanner;

public class CompositionMusicale {

    public static void main(String[] args) {
        String input = "aabbaabbdccdfe";
        System.out.printf("%s - > %s", input, corrigeComposition(input));
    }


    private static String corrigeComposition(String str) {
        String correction = str;
        boolean hasRemovedDuplicates = true;

        while (hasRemovedDuplicates) {
            hasRemovedDuplicates = false;
            for (int i = 1; i < correction.length(); i++) {
                if (correction.charAt(i - 1) != correction.charAt(i)) continue;
                hasRemovedDuplicates = true;
                correction = correction.substring(0, i - 1) + correction.substring(i + 1);
            }
        }
        return correction;
    }
}
