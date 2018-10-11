package HW2;

import java.util.Scanner;

/**
 * Created by brendanmutton on 10/9/18.
 */
public class IntervalsBreaks {
    private Interval[] array;
    private Interval[] temp;
    private int len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] b = new int[n][n];
        Interval[] intervals = new Interval[n];

        for(int i=0; i<n; i++)
        {
            String[] in = new String[2];
            in = sc.nextLine().split(" ");
            intervals[i] = new Interval(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
        }

        for(int i=0; i<n; i++)
        {
            String[] bs = new String[n];
            bs = sc.nextLine().split(" ");

            for(int j=0; j<n; j++)
            {
                b[i][j] = Integer.parseInt(bs[j]);
            }
        }
        IntervalsBreaks t = new IntervalsBreaks();
        t.sort(intervals);
        int m = t.weighted_sched(intervals,b);
        System.out.println(m);
    }

    public int weighted_sched(Interval[] intervals, int[][] b)
    {
        int max = 0;
        int[] classes = new int[intervals.length];

        for(int j = 0; j<intervals.length; j++)
        {
            for(int k = 0; k<intervals.length; k++)
            {
                int gap = intervals[k].start - intervals[j].finish;
                if(gap >= b[j][k])
                    classes[j] += 1;
            }
        }
        max = max(classes);
        return max;
    }
    public static int max(int[] arr)
    {
        int max = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public void sort(Interval arr[])
    {
        this.array = arr;
        this.len = arr.length;
        this.temp = new Interval[len];
        mergeSort(0, len-1);

    }

    private void mergeSort(int lower, int higher)
    {
        if(lower < higher)
        {
            int mid = lower + (higher - lower) / 2;
            mergeSort(lower, mid);
            mergeSort(mid + 1, higher);
            merge(lower, mid, higher);
        }
    }

    private void merge(int lower, int mid, int higher)
    {
        for(int i = lower; i <= higher; i++)
        {
            temp[i] = array[i];
        }
        int i = lower;
        int j = mid + 1;
        int k = lower;
        while(i <= mid && j <= higher)
        {
            if(temp[i].finish <= temp[j].finish)
            {
                array[k] = temp[i];
                i++;
            }
            else
            {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i <= mid)
        {
            array[k] = temp[i];
            k++;
            i++;
        }
    }

}
class Interval
{
    int start = 0;
    int finish = 0;

    public Interval(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }
}
