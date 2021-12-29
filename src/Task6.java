import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String arithmeticExpression;
        System.out.println("Enter arithmetic expression:");
        do {
            arithmeticExpression = scanner.next();
            if(!checkEquation(arithmeticExpression)){
                System.out.println("Please enter the arithmetic expression correctly:");
            }
            checkEquation(arithmeticExpression);
        }while (!checkEquation(arithmeticExpression));
        System.out.println(calculate(arithmeticExpression));
    }
    public static boolean checkEquation(String arithmeticExpression){


        boolean result;
        int i, j;
        int[] allOptions = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', ')', '+', '^', '-', '/', '('};
        int[] expressions1 = {'*', ')', '+', '^',  '/', '(','-'};
        int[] expressions2 = {'*', '+', '^', '-', '/', '('};

        result = true;

        int stringSize = arithmeticExpression.length();
//מוודא שהערך המוכנס חוקי

        for (i = 0; i < stringSize; i++) {
            if(result){
                result=false;
                for (j = 0; j < allOptions.length; j++){
                    if (arithmeticExpression.charAt(i)==allOptions[j]){
                        result = true;
                        break;}}}
        }
        //מוודא שערך הספרה הראשונה היא לא פעולה חשבונית חוץ מסוגר פנימי
        for (i = 0; i < expressions1.length - 2; i++){
            if (arithmeticExpression.charAt(0) == expressions1[i]|
                    arithmeticExpression.charAt(0)==0){
                result = false;}}

        //מוודא שספרה האחרונה לא פעולה חשבונית
        for (i = 0; i < expressions2.length; i++){
            if (arithmeticExpression.charAt(stringSize - 1) == expressions2[i]){
                result = false;}}

        //מוודא שאין כפילות פעולה חשבונית
        for(i=0;i<stringSize-1;i++){
            if(checkIfOperator(arithmeticExpression.charAt(i))==checkIfOperator(arithmeticExpression.charAt(i+1))){
                result=false;}
        }


        //מוודא שאין סוגר שמאל בודד
        for(i=0;i<stringSize;i++){
            if(arithmeticExpression.charAt(i)=='('){
                result=false;
                for(j=i+3;j<stringSize;j++) {
                    if (arithmeticExpression.charAt(j) == ')') {
                        result = true;
                        break;
                    }}}}

        //מוודא שאין סוגר ימין בודד
        for(i=0;i<stringSize;i++){
            if(arithmeticExpression.charAt(i)==')'){
                result=false;
                for(j=0;j<stringSize;j++) {
                    if (arithmeticExpression.charAt(j) == '(') {
                        result = true;
                        break;
                    }}}}
        //מוודא שאין כפל ספרות (ספרות 1-9 ללא ספרות דו ספרתיות ומעלה)
        for (i = 0; i < stringSize-1; i++){
            if (checkIfDigit(arithmeticExpression.charAt(i)) && checkIfDigit(arithmeticExpression.charAt(i+1))){
                result=false;}}

        return result;
    }
    //בודק אם קיימת פעולה חשבונית
    public static boolean checkIfOperator(char operator){
        int[] operators = {'*', '+', '^',  '/', '-'};
        boolean result=false;
        for (int i = 0; i < operators.length; i++) {
            if (operator == operators[i]) {
                result = true;
                break;
            }
        }
        return result;
    }
    //בודק אם הערך הוא ספרה
    public static boolean checkIfDigit(char number){
        int[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean result = false;
        for (int i = 0; i < digit.length; i++) {
            if(number==digit[i]){
                result=true;
                break;}
        }
        return result;
    }

    public static double calculate(String arithmeticExpression){
        int i;
        int iStart=0;
        int changeToInt='0';
        int result=0;
        if(arithmeticExpression.charAt(0)=='-'){
            result=-1*(arithmeticExpression.charAt(1)-changeToInt);
            iStart=1;}

        //בודק אם ההתחלה היא סוגריים או - ומתחיל אחריהם כשהערך הראשוני הוא חרי הסוגריים או אחרי המינוס(כפול -1)
        else if(arithmeticExpression.charAt(0)=='('){
            if(arithmeticExpression.charAt(1)=='-'){
                result=-1*(arithmeticExpression.charAt(2)-changeToInt);
                iStart=2;}
            else if(arithmeticExpression.charAt(1)!='-'){
                result=(arithmeticExpression.charAt(1)-changeToInt);
                iStart=1;}
        }
        else
            //אם ההתחלה היא לא סוגריים או מינוס הערך הוא מיקום 0 -'0'
            result=arithmeticExpression.charAt(0)-changeToInt;

        //לולאה עוברת על כל המשוואה ופועלת בהתאם לפעלות החשבוניות
        for (i=iStart ; i < arithmeticExpression.length()-2; i++) {
            int digitLocation = arithmeticExpression.charAt(i + 2) - changeToInt;
            if(arithmeticExpression.charAt(i+1)=='^')
                result= (int) (Math.pow(result, digitLocation));

            if(arithmeticExpression.charAt(i+1)=='*')
                result=result* digitLocation;

            if(arithmeticExpression.charAt(i+1)=='/')
                result=result/ digitLocation;

            if(arithmeticExpression.charAt(i+1)=='+')
                result=result+ digitLocation;

            if(arithmeticExpression.charAt(i+1)=='-')
                result=result- digitLocation;

        }



        return result;}




















    public static int allPow(String math){
        int allPow=0;


        return allPow;
    }

    public static double insideParenthesis(String arithmeticExpression) {
        double insideParenthesis = 0;
        int changeToInd = '0';
        int j = 0;
        for (int i = 0; i < arithmeticExpression.length(); i++) {
            if (arithmeticExpression.charAt(i) == '(') {

                j = i + 1;

                while (arithmeticExpression.charAt(j) != ')') {

                    if (arithmeticExpression.charAt(j) == '-') {
                        insideParenthesis += -1 * (arithmeticExpression.charAt(j + 1) - changeToInd);
                    } else if (arithmeticExpression.charAt(j) == '+') {
                        insideParenthesis += arithmeticExpression.charAt(j + 1) - changeToInd;
                    }

                    j++;
                }
            }
        }

        return insideParenthesis;
    }}