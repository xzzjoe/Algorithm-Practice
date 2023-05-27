import java.util.PriorityQueue;

public class pQ {
    public static void main(){
        PriorityQueue myQ = new PriorityQueue<>(3);
        int[] arr = {1,3,4,5,6};
        for (int i : arr){
            myQ.add(i);
        }
        String ptrStr = myQ.toString();
        System.out.println(ptrStr);
    }
}
