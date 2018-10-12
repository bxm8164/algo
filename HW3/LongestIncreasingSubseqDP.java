package HW2;

/**
 * Created by brendanmutton on 10/9/18.
 */
public class LongestIncreasingSubseqDP {
    public static void main(String[] args) {
        int[] arr = {25053, 4601, 4540, 20255, 23073, 17419, 10282, 3621, 32092, 945};
        int m = incrSubseqDP(arr);
        System.out.println(m);
    }

    public static int incrSubseqDP(int[] arr)
    {
        int[] s = new int[arr.length];

        for(int j = 0; j<arr.length; j++)
        {
            s[j] = 1;
            for(int k=0; A[k]<S[j]; k++)
            {
                if(arr[k]<arr[j] && s[j]<s[k] + 1)
                    s[j] = s[k]+1;
            }
        }

        return max(s);
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
}
