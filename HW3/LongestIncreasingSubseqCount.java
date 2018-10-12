import java.util.Scanner;

public class LongestIncreasingSubseqCount{

    public static long inputArr[];

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();
        sc.nextLine();

        String[] inputs = new String[numInputs];
        inputs = sc.nextLine().split(" ");
        inputArr = new long[numInputs];

        for (int i = 0; i < inputs.length; i++)
            inputArr[i] = Long.parseLong(inputs[i]);

        System.out.println(incrSubseq(inputArr));

    }

    public static long incrSubseq(long[] arr) {
        long[] s = new long[arr.length];

        for(int j = 0; j < arr.length; j++) {
            s[j] = 1;
            for(int k=0; k<j; k++) {
                if(arr[k] < arr[j]){
                    System.out.println("s[j] = " + s[j] + "\ns[k] = " + s[k]);
                    s[j] += s[k];
                }
            }
            if(j >= arr.length) {
                s[j + 1] = s[j];
            }
        }
        for(int b = 0; b<s.length; b++){
            System.out.println(s[b]);
        }

        return s[arr.length-1];//%1000000
    }
}