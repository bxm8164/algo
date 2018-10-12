package HW2;

/**
 * Created by brendanmutton on 10/9/18.
 */
public class LongestIncreasingSubseqRecursive {
    public static int max = 0;
    public static void main(String[] args) {
        int[] arr = {25053, 4601, 4540, 20255, 23073, 17419, 10282, 3621, 32092, 945};
        int j = 9;

        int max = LIS(arr, j);
        System.out.println(max);


    }


    public static int _lis(int arr[], int n){
        if(n==0) return 1;

        int m=1, temp;
        for(int i=0; i<n; i++){
            if(arr[i]<arr[n]){
                temp= 1 + _lis(arr, i);
                if(temp > m)
                    m=temp;    //   m = max(m, 1 + _lis(arr, i));
            }
        }
        return m;
    }

    public static int LIS(int arr[], int n){
        int temp, m=0;

        for(int i=0; i<n; i++){
            temp = _lis(arr, i);
            if(temp>m)
                m= temp;
        }
        return m;
    }
/*
    public static int incrHelp(int j, int[] arr)
    {
        int m= 0;
        for (int i=0; i<j; i++)
            m = incrSubseqRecursive(i,arr);
        return m;
    }

    public static int incrSubseqRecursive(int j, int[] arr)
    {
        if (j == 1)
            return 1;


        int temp = 0;
        for(int i = 0; i < j; i++)
        {
            if(arr[i] < arr[j])
            {
                temp = 1 + incrSubseqRecursive(i, arr);
                if (temp > max)
                    max = temp ;
            }

        }

        return max;
    }*/
}
