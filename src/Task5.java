import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text");
        String text = scanner.nextLine();
        int [] counter = new int[text.length()];
        char [] charBeenSeen = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
        char currentTested = text.charAt(i);
        if (!(beenChecked(charBeenSeen, currentTested) | currentTested == ' ')){
            charBeenSeen[i] = currentTested;
        for (int j = 0; j < text.length(); j++) {
        if (currentTested == text.charAt(j)) {
        counter[i]++;}
        }}}
        int letterMaxIndex = MaxIndexCheck(counter);
        counter[letterMaxIndex] = 0;
        int secondMaxIndex = MaxIndexCheck(counter);

        char maxChar = text.charAt(letterMaxIndex);
        char secondMaxChar = text.charAt(secondMaxIndex);
        char[] changedText = replaceChars(text, maxChar, secondMaxChar);
        System.out.println(changedText);
    }

    private static boolean beenChecked(char[] charBeenSeen, char currentTested) {
        boolean result=false;
        for (int i = 0; i < charBeenSeen.length; i++) {
        if (currentTested == charBeenSeen[i]) {
        result = true;
        break;
        }}
        return result;
        }
    private static int MaxIndexCheck(int[] counter) {
        int max = 0;
        for (int i = 0; i < counter.length; i++ ) {
        if (counter[max] < counter[i]) {
        max = i;
        }}
        return max;
        }
    private static char[] replaceChars(String text, char maxChar, char secondMaxChar) {
        char[] newText = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
        char currentTested = text.charAt(i);
        if (currentTested == maxChar) {
        newText[i] = secondMaxChar;
        }
        else if (currentTested == secondMaxChar) {
        newText[i] = maxChar;
        }
        else {
        newText[i] = currentTested;
        }}
        return newText;
        }
        }