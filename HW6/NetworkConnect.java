import java.util.Scanner;
public class NetworkConnect{
    public static int numComputers, numConnections, source, sink;
    public static int[] array;
    public static int len;
    public static int[] temp;
    public static int[] path;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] a = line.split(" ");
        numComputers = Integer.parseInt(a[0])+1;
        numConnections = Integer.parseInt(a[1]);

        String line1 = scan.nextLine();
        String[] b = line1.split(" ");
        source = Integer.parseInt(b[0]);
        sink = Integer.parseInt(b[1]);

        int graph[][] = new int[numComputers][numConnections];
        int s = source;
        int t = sink;

        for(int i=0; i<numComputers; i++){
            b = scan.nextLine().split(" ");
            int u = Integer.parseInt(b[0]), v = Integer.parseInt(b[1]), w = Integer.parseInt(b[2]);
            graph[u][v] = w;
        }

        edmondsKarp(graph, s, t);

    }

    public static boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        boolean visited[] = new boolean[numComputers];
        for(int i=0; i<numComputers; ++i)
            visited[i]=false;

        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        visited[s] = true;
        parent[s]=-1;

        while (!queue.isEmpty())
        {
            int u = queue.dequeue();

            for (int v=0; v<numComputers; v++)
            {
                if (!visited[v] && rGraph[u][v] > 0)
                {
                    queue.enqueue(v);
                    parent[v] = u;
                    visited[v] = true;

                }
            }
        }

        return (visited[t]);
    }

    public static void edmondsKarp(int graph[][], int s, int t)
    {
        int u, v;

        int rGraph[][] = new int[numComputers][numConnections];

        for (u = 0; u < numComputers; u++)
            for (v = 0; v < numComputers; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[numComputers];

        while (bfs(rGraph, s, t, parent))
        {
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

        }

        bfs(rGraph, s, t, parent);

        sort(parent);

        for(int i = 1; i < parent.length; i++)
        {
            if(rGraph[source][i] == 0 && i != source)
            {
                System.out.println(source +" "+ i);
                System.exit(0);
            }
        }
        System.out.println("NO");

    }
    public static void sort(int arr[])
    {
        array = arr;
        len = arr.length;
        temp = new int[len];
        mergeSort(0, len-1);

    }

    private static void mergeSort(int lower, int higher)
    {
        if(lower < higher)
        {
            int mid = lower + (higher - lower) / 2;
            mergeSort(lower, mid);
            mergeSort(mid + 1, higher);
            merge(lower, mid, higher);
        }
    }

    public static void merge(int lower, int mid, int higher)
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
            if(temp[i] <= temp[j])
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

class Queue<T> {


    private class Node{
        T item;
        Node next;

        Node(T t){
            item = t;
            next = null;
        }

        public String toString()  {
            return  item.toString();
        }
    }


    private Node first, last;

    Queue(){
        first = null;
        last = null;
    }


    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(T t){
        Node oldLast = last;
        last = new Node(t);
        if (isEmpty()) first = last;
        else   oldLast.next = last;
    }

    public T dequeue(){
        if (isEmpty())
            return  null;

        if (first == last){
            T t = (T) first.item;
            first = last = null;
            return  t;
        }

        T t = (T) first.item;
        first = first.next;
        return t;
    }
/*
    public String toString(){
        if (first == null)
            return null;

        if (first == last)
            return first.item.toString();

        StringBuffer sb = new StringBuffer();
        Node cur = first;
        while(cur != last){
            sb.append(cur.item.toString()+" ");
            cur = cur.next;
        }
        sb.append(last.item.toString());
        return sb.toString();
    }
*/
}
