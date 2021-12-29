import java.util.Scanner;
public class Task7 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String quadraticEquation;
        System.out.println("Enter quadratic equation the format of ax^2+bx+c=0 :");
        do {
        quadraticEquation = scanner.next();
        if (checkCorrectEquation(quadraticEquation))
        System.out.println("Please enter the equation correctly:");
        }while (checkCorrectEquation(quadraticEquation));
        calculateEquation(quadraticEquation);
    }

    public static boolean checkCorrectEquation(String quadraticEquation) {
        boolean correctEquation=true;
        int[]equationOptions={'1','2','3','4','5','6','7','8','9','x','^','-','+','1','2'};
        int[]digits={'1','2','3','4','5','6','7','8','9','1','2','3'};
        int i;
        int j;

    for(i=0;i<quadraticEquation.length()-3;i++) {
    if(correctEquation){
    correctEquation=false;
    for (j=0;j<equationOptions.length;j++){
    if (quadraticEquation.charAt(i) == equationOptions[j])
    correctEquation=true;
    }}}

    if(quadraticEquation.length()!=12&&
       quadraticEquation.length()!=11&&
       quadraticEquation.length()!=10&&
       quadraticEquation.length()!=9&&
       quadraticEquation.length()!=8){
       return true;}

if(quadraticEquation.length()>=9 && quadraticEquation.charAt(6)!='x' && quadraticEquation.charAt(7)!='x'){
    correctEquation=false;}
if(quadraticEquation.charAt(0)!='-'&&quadraticEquation.length()==12){
    return true;
}
    if(quadraticEquation.charAt(quadraticEquation.length()-1)!='0'|
       quadraticEquation.charAt(quadraticEquation.length()-2)!='=')
        correctEquation=false;

        int signSpot = quadraticEquation.charAt(quadraticEquation.length() - 4);
        int numSpot = quadraticEquation.charAt(quadraticEquation.length() - 3);
        if(numSpot!='x' && signSpot!='-'&& signSpot!='+')
            correctEquation=false;

    if(correctEquation){
    if((quadraticEquation.charAt(1)!='x'|
       quadraticEquation.charAt(2)!='^'|
       quadraticEquation.charAt(3)!='2')|
            (quadraticEquation.charAt(0)=='-'&&
            quadraticEquation.charAt(2)!='x'|
            quadraticEquation.charAt(3)!='^'|
            quadraticEquation.charAt(4)!='2')){
        correctEquation=false;}}

if(quadraticEquation.charAt(0)!='-'){
if(quadraticEquation.charAt(4)!='-'&&
   quadraticEquation.charAt(4)!='+'){
    if(quadraticEquation.charAt(4)!='=')
    correctEquation=false;}
    }
        if(quadraticEquation.charAt(0)=='-'){
        if(quadraticEquation.charAt(5)!='-'&&
           quadraticEquation.charAt(5)!='+'){
        if(quadraticEquation.charAt(5)!='=')
        correctEquation=false;}
        }
         if(quadraticEquation.charAt(0)!='-'){
    i=0;
    while (i!=digits.length-1&&quadraticEquation.charAt(5)!=digits[i]&&
        quadraticEquation.charAt(6)!='='){
    i++;}
    if (i==digits.length-1){
    correctEquation=false;}

}
        if(quadraticEquation.charAt(0)=='-'){
            i=0;
            if(quadraticEquation.charAt(0)!='-'){
            while (quadraticEquation.charAt(6) != digits[i] | quadraticEquation.charAt(7) != digits[i] && quadraticEquation.charAt(7) != '='){
            i++;
            if (i == digits.length - 1) {
            correctEquation = false;
            break;
            }}
            }

            if(quadraticEquation.charAt(0)=='-'){
            while ((quadraticEquation.charAt(6)!=digits[i] &&
            quadraticEquation.charAt(7)!='=')){
            i++;
            if (i == digits.length - 1) {
            correctEquation = false;
            break;
            }}}

        }
        return !correctEquation;
    }
    public static void calculateEquation(String quadraticEquation){
      int a=findA(quadraticEquation);
      int b=findB(quadraticEquation);
      int c=findC(quadraticEquation);

        int inSqrt = (b * b) - 4 * a * c;
        double sqrtEquation = Math.sqrt(inSqrt);
        double x1=(-b+ sqrtEquation)/(2*a);
       double x2=(-b- sqrtEquation)/(2*a);
        if(inSqrt <0){
            System.out.println("The equation have no result for this numbers.");
        }
        else {
        System.out.println("x1="+x1);
        System.out.println("x2="+x2);}

    }

    public static int findA(String quadraticEquation){
        int changeToInt='0';
        int a=0;
        if(quadraticEquation.charAt(0)!='-')
        a=quadraticEquation.charAt(0)-changeToInt;
        else if (quadraticEquation.charAt(0)=='-')
            a=(quadraticEquation.charAt(1)-'0')*-1;
    return a;
    }
    public static int findB(String quadraticEquation){
        int changeToInt='0';
        int b=0;
        if(quadraticEquation.charAt(6)=='x')
                b=quadraticEquation.charAt(5)-changeToInt;
        if(quadraticEquation.charAt(4)=='-')
            b=-b;

        if(quadraticEquation.charAt(7)=='x')
            b=quadraticEquation.charAt(6);
        if(quadraticEquation.charAt(5)=='-')
            b=-b;

    return b;
    }
    public static int findC(String quadraticEquation) {
        int c = 0;
        int changeToInt = '0';
        int signLocation = (quadraticEquation.length() - 4);
        int cLocation = (quadraticEquation.length() - 3);

         if(quadraticEquation.charAt(signLocation)=='+'){
            c=quadraticEquation.charAt(cLocation)-changeToInt;
        }
        else if(quadraticEquation.charAt(signLocation)=='-'){
            c=-(quadraticEquation.charAt(cLocation)-changeToInt);}
            return c;
    }
    }
