import java.util.*;

/**
 * Created by brendanmutton & Nicole Ganung on 9/26/18.
 */
public class WeightedByDiffInversions {
    public static int midcount;
    public static int num_inputs;
    public static long weighted_count;

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
        System.out.println(weighted_count);

    }

    //split the list in two and sort each half, and call countMidInv, which calculates the weighted count.
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


            for(int i = 0; i<mid; i++)
                left.inv[i] = in.inv[i];

            for(int i = 0; i<mid2; i++)
            {
                right.inv[i] = in.inv[i+mid];

            }

            countInv(left);
            countInv(right);
            countMidInv(left.inv, right.inv);


            return Merge(in, left.inv, right.inv);
        }
    }

    //calculate the weighted count
    public static void countMidInv(long[] left, long[] right)
    {
        int i = 0, j = 0;
        long left_sum = 0;
        for(int k = 0; k < left.length; k++)
        {
            left_sum +=left[k];
        }
        //

        while(i<left.length && j<right.length)
        {
            if(left[i] <= right[j]) {
                left_sum -= left[i];
                i++;
            }
            //update temp when i increases
            else if(left[i] > right[j])
            {
                weighted_count += left_sum - ((left.length - i) * right[j]);
                j++;

            }
        }
    }

    //merge the two lists.
    public static Inversions Merge(Inversions in, long[] left, long[] right)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int c = left.length+right.length;

        while(k < c && i < left.length && j < right.length)
        {
            if(left[i] < right[j] )
            {
                in.inv[k] = left[i];
                i++;
            }
            else
            {
                in.inv[k] = right[j];
                j++;
            }


            k++;
        }

        if(i >= left.length )
        {
            while(j < right.length)
            {
                in.inv[k] = right[j];
                j++;
                k++;
            }


        }
        else if (j >= right.length)
        {
            while(i < left.length)
            {
                in.inv[k] = left[i];
                i++;
                k++;
            }
        }


        return in;
    }



}

class Inversions
{
    public int count;
    public long[] inv;
}