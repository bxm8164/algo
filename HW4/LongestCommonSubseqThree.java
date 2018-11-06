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
        int[] firstInputArr = new int[firstRow];

        String[] secondInputs;
        secondInputs = scan.nextLine().split(" ");
        int[] secondInputArr = new int[secondRow];

        String[] thirdInputs;
        thirdInputs = scan.nextLine().split(" ");
        int[] thirdInputArr = new int[thirdRow];

        for (int i = 0; i < firstInputs.length; i++)
            firstInputArr[i] = Integer.parseInt(firstInputs[i]);

        for (int i = 0; i < secondInputs.length; i++)
            secondInputArr[i] = Integer.parseInt(secondInputs[i]);

        for (int i = 0; i < thirdInputs.length; i++)
            thirdInputArr[i] = Integer.parseInt(thirdInputs[i]);

        longestCommonSubseq(firstInputArr, secondInputArr, thirdInputArr);
    }

    public static void longestCommonSubseq(int[] a, int[] b, int[] c){
        int[][][] s = new int[a.length+1][b.length+1][c.length];

        for(int j=1; j<a.length; j++){
            for(int k=1; k<b.length; k++) {
                for(int l=1; l<c.length; l++) {
                    s[j][k][l] = max(s[j - 1][k][l], s[j][k - 1][l], s[j][k][l-1]);
                    if (a[j] == b[k] && b[k] == c[l]) {
                        s[j][k][l] = max(s[j][k][l], s[j - 1][k - 1][l-1] + 1, -1);
                    }
                }
            }
        }

        int subseqLen = s[a.length-1][b.length-1][c.length-1];
        System.out.println(subseqLen);

        int[] reconstruct = new int[subseqLen];
        int count = 0;

        int m = a.length-1;
        int n = b.length-1;
        int o = c.length-1;
        while(m > 0 && n > 0 && o > 0){
            if(a[m] == b[n] && b[n] == c[o] && s[m-1][n-1][o-1] + 1 == s[m][n][o]){
                reconstruct[count] = a[m];
                count++;
                m--;
                n--;
                o--;
            } else if(max(s[m-1][n][o], s[m][n-1][o], s[m][n][o-1]) == s[m-1][n][o]) {
                m--;
            } else if(max(s[m-1][n][o], s[m][n-1][o], s[m][n][o-1]) == s[m][n-1][o]){
                n--;
            } else{
                o--;
            }
        }

        for(int i = subseqLen-1; i >= 0; i--){
            System.out.print(reconstruct[i] + " ");
        }
        System.out.println("");
        return;
    }


    public static int max(int a, int b, int c){
        if (a >= b && a > c){
            return a;
        } else if (b > a && b > c){
            return b;
        } else { return c; }
    }
}
