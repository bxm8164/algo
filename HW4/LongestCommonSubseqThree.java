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
        // TODO: Make into 3D solution array
        int[][] sol = new int[a.length][b.length];

        for(int j=1; j<a.length; j++){
            for(int k=1; k<b.length; k++) {
                if((sol[j-1][k] > sol[j][k-1]) || sol[j-1][k] == sol[j][k-1]){
                    sol[j][k] = sol[j-1][k];
                } else if(sol[j-1][k] < sol[j][k-1]) {
                    sol[j][k] = sol[j][k-1];
                }
                if(a[j] == b[k]){
                    sol[j][k] = (sol[j-1][k-1]) + 1;
                }
                System.out.print(sol[j][k]);
            }
            System.out.println("");
        }
        System.out.println((sol[a.length-1][b.length-1])-1);
        return;
    }

}