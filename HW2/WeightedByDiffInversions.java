package HW2;

import java.util.*;

/**
 * Created by brendanmutton on 9/26/18.
 */
public class WeightedByDiffInversions {
    public static int midcount;
    public static int num_inputs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num_inputs = Integer.parseInt(sc.nextLine());


        String[] inputs = new String[num_inputs];
        inputs = sc.nextLine().split(" ");
        Inversions in = new Inversions();
        in.inv = new long[num_inputs];

        for (int i = 0; i < inputs.length; i++)
            in.inv[i] = Long.parseLong(inputs[i]);

        countInv(in);
        System.out.println(in.count);

    }

    public static Inversions countInv(Inversions in)
    {
        if(in.inv.length == 1)
            return in;

        else
        {

            int mid = in.inv.length/2;
            int mid2 = in.inv.length - (in.inv.length/2);
            Inversions left = new Inversions();
            Inversions right = new Inversions();
            left.inv = new long[mid];
            right.inv = new long[mid2];

            int j = mid;

            for(int i = 0; i<mid; i++)
                left.inv[i] = in.inv[i];

            for(int i = 0; i<mid2; i++)
            {
                right.inv[i] = in.inv[j];
                j++;
            }

            left = countInv(left);
            right = countInv(right);
            midcount = countMidInv(left.inv, right.inv);

            in.count = left.count + right.count + midcount;

            return Merge(in, left.inv, right.inv);
        }
    }
    public static int countMidInv(long[] left, long[] right)
    {
        int mc = 0;
        int i = 0, j = 0;

        while(i<left.length && j<right.length)
        {
            if(left[i] < right[i])
                i++;
            else if(left[i] > right[i])
            {
                mc += (left.length-i);
                j++;
            }
        }
        return mc;
    }

    public static Inversions Merge(Inversions in, long[] left, long[] right)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int c = left.length+right.length;

        while(k < c)
        {
            if(left[i] < right[i])
            {
                in.inv[i] = left[i];
                i++;
            }
            else
            {
                in.inv[i] = right[j];
                j++;
            }
            k++;
        }


        return in;
    }


}

class Inversions
{
    public int count;
    public long[] inv;
}