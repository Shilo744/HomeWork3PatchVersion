import java.util.Scanner;
public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enteredNumber;
        int i;
        System.out.println("Enter a number to find his primary factors:");
        do {
        enteredNumber = scanner.nextInt();
        if (enteredNumber < 1) {
        System.out.println("Please enter a positive number higher then 1:");
        }
        } while (enteredNumber < 1);
        for(i=0;i<primaryFactorsOfNumber(enteredNumber).length;i++)
        System.out.println(primaryFactorsOfNumber(enteredNumber)[i]);
    }

    public static int[] primaryFactorsOfNumber(int enteredNumber) {
        int arraySize = getArraySize(enteredNumber);
        int[] primaryFactors=new int[arraySize];
        int j=0;
        for (int i = 2; i <= enteredNumber; ++i) {
        while (enteredNumber % i == 0) {
        primaryFactors[j]=i;
        j++;
        enteredNumber /= i;
        }
        }
        return primaryFactors;
    }
    public static int getArraySize(int enteredNumber) {
        int primeFactorsSize = 0;
        for (int i = 2; i <= enteredNumber; ++i) {
        while (enteredNumber % i == 0) {
        primeFactorsSize++;
        enteredNumber /= i;
        }}
        return primeFactorsSize;
    }}
