import java.util.Scanner;

/*
 * Created by Nicole Ganung and Brendan Mutton
 */
public class LongestCommonSubseqThree{

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);
        int firstRow = scan.nextInt();
        int secondRow = scan.nextInt();
        int thirdRow = scan.nextInt();
        scan.nextLine();

        String[] firstInputs;
        firstInputs = scan.nextLine().split(" ");
        long[] firstInputArr = new long[firstRow];

        String[] secondInputs;
        secondInputs = scan.nextLine().split(" ");
        long[] secondInputArr = new long[secondRow];

        String[] thirdInputs;
        thirdInputs = scan.nextLine().split(" ");
        long[] thirdInputArr = new long[thirdRow];

        for (int i = 0; i < firstInputs.length; i++)
            firstInputArr[i] = Long.parseLong(firstInputs[i]);

        for (int i = 0; i < secondInputs.length; i++)
            secondInputArr[i] = Long.parseLong(secondInputs[i]);

        for (int i = 0; i < thirdInputs.length; i++)
            thirdInputArr[i] = Long.parseLong(thirdInputs[i]);

        longestCommonSubseq(firstInputArr, secondInputArr, thirdInputArr);
    }

    public static void longestCommonSubseq(long[] a, long[] b, long[] c){
        return;
    }

}