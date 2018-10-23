import java.util.Scanner;

/*
 * Created by Nicole Ganung and Brendan Mutton
 */
public class LongestConvexSubseq{

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

        longestConvexSubseq(inputArr);
    }

    public static void longestConvexSubseq(long[] inputArr){
        return;
    }

}