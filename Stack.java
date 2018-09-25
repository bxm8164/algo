/**
 * Created by brendanmutton on 9/24/18.
 */
public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int maxSize)
    {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j)
    {
        stackArray[top++] = j;
    }

    public long pop()
    {
        return stackArray[top--];
    }



}
