import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Random random = new Random();
        int secretCode;
        do {
            secretCode = random.nextInt(5210)+ 1234;
        } while (!isCodeValid(secretCode));
        System.out.println(secretCode);
        String code = Integer.toString(secretCode);
        gamePlay(code);
    }
    public static int chooseLevel(){
        Scanner scanner = new Scanner(System.in);
        int level;
        do {
            System.out.println("Choose your level: ");
            System.out.println("press 1 for easy run     (20 tries)   :");
            System.out.println("press 2 for medium run   (15 tries)   :");
            System.out.println("press 3 for hard run     (10 tries)   :");
            System.out.println("press 4 for surprise run (5-25 tries) :");
            level = scanner.nextInt();
        } while (level > 4 | level < 1);
        return level;
    }
    public static boolean isCodeValid (int secretCode){
        boolean isCodeValid = false;
        if (oneToSixDigits(secretCode) && checkIfSameDigits(secretCode)){
            isCodeValid = true;
        }
        return isCodeValid;
    }

    public static boolean checkIfSameDigits(int code) {
        boolean noSimilarDigits = true;
        String theCode=""+code;
        while (code != 0) {
            if (theCode.charAt(3) != theCode.charAt(2) &&
                theCode.charAt(3) != theCode.charAt(1) &&
                theCode.charAt(3) != theCode.charAt(0) &&
                theCode.charAt(2) != theCode.charAt(1) &&
                theCode.charAt(2) != theCode.charAt(0) &&
                theCode.charAt(1) != theCode.charAt(0)) {
                code = code / 10;
            } else {
                noSimilarDigits = false;
                break;
            }
        }
        return noSimilarDigits;
    }

    public static boolean oneToSixDigits (int code){
        String stringCode=""+code;
        int lastDigit=stringCode.charAt(3)-'0';
        boolean isValid = true;
        if (code < 1000 | code > 6666){
            isValid = false;
        }
        while (code != 0){
            if (lastDigit != 0 &&  lastDigit != 7 && lastDigit != 8 && lastDigit !=9){
                code = code / 10;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void gamePlay (String code){
        Scanner scanner = new Scanner(System.in);
        int triesLeft = 0;
        int level = chooseLevel();
        switch (level){
            case 1: triesLeft = 20;
                break;
            case 2: triesLeft = 15;
                break;
            case 3: triesLeft = 10;
                break;
            case 4: triesLeft = 25;
                break;
        }
        int inputCode;
        String codeGuessString = "";
        do { do {
                if (level == 4) {
                    System.out.println("To guess the secret code enter four digits from 1 to 6: ");
                } else {
                    System.out.println("You left with: " + triesLeft + " tries. You can do it! Enter four digits from 1 to 6: ");
                }
                inputCode = scanner.nextInt();
                if (oneToSixDigits(inputCode)) {
                    if (!checkIfSameDigits(inputCode)){
                        triesLeft = triesLeft - 1;
                        System.out.println("Don't put the same digit " +
                                "now you lost 2 tries.. Sorry.. its hurt me more then it hurt you );");
                    }
                    triesLeft--;
                    codeGuessString = Integer.toString(inputCode);
                    guessesPosition(code, codeGuessString);
                }
            } while (!oneToSixDigits(inputCode));
        } while (!exposeCode(code, codeGuessString) && triesLeft >= 0);
        if (exposeCode(code, codeGuessString)){
            System.out.println("You are the best! congratulation, you won!");
        } else
        {System.out.println("Sometimes yo win, sometimes you lose :( better luck next time! ^^ The code was : " + code);
        }
    }

    public static void guessesPosition (String code, String codeGuessString){
        int exactlyGuessedDigit = 0;
        int partiallyGuessedDigit = 0;
        for (int i = 0; i < code.length(); i++){
            for (int j = 0; j < codeGuessString.length(); j++){
                if (code.charAt(i) == codeGuessString.charAt(j)){
                    if (i == j){
                        exactlyGuessedDigit+=1;
                    } else {
                        partiallyGuessedDigit+=1;
                    }
                    break;
                }}}
        System.out.println("You got " + exactlyGuessedDigit+" in the right place");
        System.out.println("There are correct " + partiallyGuessedDigit+" correct digits but not at the right spot");
    }

    public static boolean exposeCode (String code, String inputCode){
        boolean reveal = true;
        for (int i= 0; i < 4; i++){
            if (code.charAt(i) != inputCode.charAt(i)) {
                reveal = false;
                break;
            }
        }
        return reveal;
    }

}