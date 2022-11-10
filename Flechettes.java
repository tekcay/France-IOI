class Flechettes {

    private static final int asciiA = (int) 'a';

    private static String generateSimpleLine(char ch, int length) {
        String simpleLine = "";
        for (int i = 0; i < length; i++) {
            simpleLine += ch;
        }
        return simpleLine;
    }

    private static String getChars(int nbLettres) {
        String chars = "";
        for (int i = 0; i < nbLettres; i++) {
            chars += String.valueOf((char)(asciiA + i));
        }
        return chars;
    }

    private static String getReverseChars(int nbLettres) {
        String chars = "";
        for (int i = nbLettres - 1; i >= 0; i--) {
            chars += String.valueOf((char)(asciiA + i));
        }
        return chars;
    }

    private static String[] getCible(int nbLettres) {

        String chars = getChars(nbLettres);
        String reverseChars = getReverseChars(nbLettres);

        int length = 2 * nbLettres - 1;

        String[] lignes = new String[length];

        //Generates the first & last line
        String simpleLine = generateSimpleLine('a', length);
        lignes[0] = simpleLine;
        lignes[length - 1] = simpleLine;

        //Generates the middleLine
        //lignes[nbLettres + 1] = generateMiddleLine(length, nbLettres);

        for (int i = 1; i < nbLettres; i++) {

            //Generate the start and the end of line
            String startLine = chars.substring(0, i);

            //Generate the end of line
            String endLine = reverseChars.substring(nbLettres - i);

            //Generate the middle of the line
            String handle = generateSimpleLine(chars.charAt(i), length - i * 2);

            //The line
            String line = startLine + handle + endLine;

            lignes[i] =  line;
            lignes[length - 1 - i] = line;
        }
        return lignes;
    }

    private static String toString(String[] lignes) {
        String cible = new String();

        for (String str : lignes) {
            cible += str + '\n';
        }
        return cible;
    }

    private static void print(String[] lignes) {
        for (String str : lignes) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        print(getCible(5));
    }

}
