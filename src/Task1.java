public class Task1 {
    public static void main(String[] args) {
    int[] arr = {112,71,133,11656,21,50,33};
    System.out.println(findTheSmall(arr));
    }

    public static boolean checkIfSwitchNumber(int testNumber) {
        boolean switchNumber=true;
        String arr1;

        arr1 = ""+ testNumber;
        int stringSize=arr1.length();
        int [] n= new int[stringSize];
        for(int j=0;j<stringSize;j++)
        {
        n[j] = (arr1.charAt(j) % 2);
        }
        for(int j=0;j<stringSize-1;j++)
            if (n[j] == n[j + 1]) {
                switchNumber = false;
                break;
            }
                return switchNumber;
        }
    public static int findTheSmall(int[]numbersToCheck){

        int i;
        int index=0;
        int min=2147000000;
        int noSwitchedNumber=-1;
        int checkNoSwitch=0;
        for(i=0;i<numbersToCheck.length;i++){
        if (checkIfSwitchNumber(numbersToCheck[i])){
        numbersToCheck[i]=makeSumOfDigits(numbersToCheck[i]);
        }
        else numbersToCheck[i]=-1;
        if (numbersToCheck[i]>0 && numbersToCheck[i]<min){
        min=numbersToCheck[i];
        index=i;
        }}
        for(i=0;i<numbersToCheck.length;i++)
        checkNoSwitch=checkNoSwitch+numbersToCheck[i];
        if (checkNoSwitch==noSwitchedNumber*numbersToCheck.length){
        index=noSwitchedNumber;
        }
        return index;
        }
    public static int makeSumOfDigits(int numberForDigitsSum){
        int i;
        int digitsSum=0;
        char changeToInt='0';
        String changeTheNum= ""+numberForDigitsSum;
        for(i=0;i<changeTheNum.length();i++) {
        digitsSum=digitsSum+changeTheNum.charAt(i)-changeToInt;
        }
        return digitsSum;
        }}