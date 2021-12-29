public class Task2 {
    public static void main(String[] args) {
    int[] arr1 ={3,4,443,3,85,533,2};
    int[] arr2 ={4,8,75,44,32,68};

    System.out.println(proximityLevel(arr1,arr2));
    }
public static int makeSumOfDigits(int numberForDigitsSum){
    int i;
    int digitsSum=0;
    int changeToInt='0';
    String changeTheNum= ""+numberForDigitsSum;
    for(i=0;i<changeTheNum.length();i++) {
    digitsSum=digitsSum+changeTheNum.charAt(i)-changeToInt;
}
return digitsSum;
}

public static int  proximityLevel(int[]arr1,int[]arr2) {
    int[] newArr1 = new int [arr1.length];
    int[] newArr2 = new int [arr2.length];
    int[] proximityLevel = new int[newArr1.length];
    int proximityLevelIndex=0;
    int i,j;
    int maxProximity=0;
    for (i=0;i<arr1.length;i++){
    newArr1[i]=makeSumOfDigits(arr1[i]);
    }
    for (i=0;i<arr2.length;i++){
    newArr2[i]=makeSumOfDigits(arr2[i]);
    }
    for(i=0;i<proximityLevel.length;i++){
        proximityLevel[i]=0;
    }
    for(i=0;i<newArr1.length;i++){
    for (j=0;j<newArr2.length;j++) {
    if(newArr1[i]==newArr2[j]) {
        proximityLevel[i]++;
    }}}
    for (i=0;i<proximityLevel.length;i++) {
    if (proximityLevel[i] > maxProximity){
        maxProximity=proximityLevel[i];
        proximityLevelIndex=i;
    }
    }
    if(maxProximity==0){
        proximityLevelIndex=-1;
    }
            return proximityLevelIndex;}
    }
