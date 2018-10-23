import java.util.Scanner;

/*
 * Created by Nicole Ganung and Brendan Mutton
 */
public class LongestIncreasingSubseqCount{

    public static long inputArr[];

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();
        sc.nextLine();

        String[] inputs;
        inputs = sc.nextLine().split(" ");
        inputArr = new long[numInputs];

        for (int i = 0; i < inputs.length; i++)
            inputArr[i] = Long.parseLong(inputs[i]);

        incrSubseqCount(inputArr);
    }

    /*
     * Count all possible subsequences in the given array
     */
    public static void incrSubseqCount(long[] arr) {
        long[] s = new long[arr.length];
        s[0] = 1; // Counting the empty set
        for(int j = 0; j < arr.length; j++) {
            s[j] = 1;
            for(int k=0; k<j; k++) {
                if(arr[k] < arr[j]){
                    s[j] += s[k]; // Add current number to previous if its a subseq
                    s[j] %= 1000000;
                }
            }
        }
        int total=1;
        // Add all subsequences together
        for(int b = 0; b<s.length; b++){
            total += s[b];
            total %= 1000000;
        }
        System.out.println(total);
    }
}