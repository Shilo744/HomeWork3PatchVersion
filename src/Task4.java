public class Task4 {
    public static void main(String[] args) {
int [] messArray={6,7,3,2,1,4,5};
int [] organizedArray={8,7,6,5,4,3,2};
        System.out.println("Mess array full is: "+ checkIfFull(messArray));
        System.out.println("Organized array full is: "+ organizedCheckIfFull(organizedArray));
}
public static boolean checkIfFull(int [] messArray){
boolean isFull=false;

    int swap1;
    int swap2;
    for (int j = 0; j < messArray.length; j++) {
    for (int i=0;i<messArray.length-1;i++){
    if(messArray[i]<messArray[i+1]){
    swap1=messArray[i];
    swap2=messArray[i+1];
    messArray[i]=swap2;
    messArray[i+1]=swap1;
    }}}
    if(organizedCheckIfFull(messArray)){
    isFull=true;}

return isFull;
    }
public static boolean organizedCheckIfFull(int [] organizedArray){
        boolean isFull=true;
    for (int i = 0; i < organizedArray.length-1; i++) {
    if (organizedArray[i]!=organizedArray[i+1]+1){
    isFull=false;
    break;
    }
    }
    return isFull;
    }

    }