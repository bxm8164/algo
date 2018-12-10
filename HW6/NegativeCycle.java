
import java.util.NoSuchElementException;
import java.util.Scanner;

//Created by Nicole Ganung and Brendan Mutton

public class NegativeCycle
{
    public static void main(String[] args) throws  Exception
    {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Graph g =  new Graph(n+1, m);
        int s = 0;

        for(int i = 0; i < m; i++)
        {
            input = sc.nextLine().split(" ");
            int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]), w = Integer.parseInt(input[2]);
            if(w < 0)
                s = v;
            g.adj[u].add(new Node(v, w));
        }

        g.dijkstra(s);

    }
}

class Graph{

    public int V;
    public int E;
    public LinkedList adj[];
    public boolean[] finalized;
    public int[] distTo;
    public boolean[] marked;
    public int[] edgeTo;
    public int[] numPaths;

    /**
     *  We initialize the Graph with number of vertices v in the graph
     */
    public Graph(int v, int e) {
        this.V = v;
        this.E = e;
        adj = new LinkedList[v];
        finalized = new boolean[v];
        distTo = new int[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void bfs(Graph G, int s) throws Exception{
        marked = new boolean[V];
        edgeTo = new int[V];
        distTo = new int[V];
        numPaths = new int[V];
        Queue<Integer> q = new Queue<Integer>();
        for(int i = 0; i<G.V; i++)
            marked[i] = false;
        for (int v = 0; v < G.V; v++)
            distTo[v] = Integer.MAX_VALUE;
        for(int i = 0; i<G.V; i++)
            numPaths[i] = 0;

        distTo[s] = 0;
        numPaths[s] = 1;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();

            for(int i = s; i<=adj[v].size(); i++)
            {
                int w = adj[v].get(i-1);
                if (!marked[w]) {
                    marked[w] = true;
                    q.enqueue(w);
                }
                if(distTo[w] > distTo[v]+1)
                {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    numPaths[w] = numPaths[v];
                }
                else if(distTo[w] == distTo[v]+1)
                    numPaths[w] += numPaths[v];
            }

        }

    }


    public void dijkstra(int s) throws Exception
    {

        for(int i = 1; i < V; i++)
        {
            distTo[i] = Integer.MAX_VALUE;
            finalized[i] = false;
        }

        distTo[s] = 0;

        update(s, s);

        for(int i = 1; i < V; i++)
        {
            int u = extract_min(s);
            finalized[u] = true;
            update(u, s);
        }

        if(distTo[s] < 0)
        {
            System.out.println("YES");
            System.exit(0);
        }
        int x =0;

    }

    public int extract_min(int s)
    {
        int min = Integer.MAX_VALUE;
        int min_vertex = 0;

        for(int i = 1; i < distTo.length; i++)
        {
            if(distTo[i] < min && !finalized[i] && i!=s)
            {
                min = distTo[i];
                min_vertex = i;
            }
        }

        return min_vertex;
    }


    public void update(int u, int s) throws Exception
    {
        LinkedList a = adj[u];

        for(int i = 1; i <= a.size(); i++)
        {
            Node v = adj[u].get(i-1);
            if(distTo[v.vertex] > distTo[u] + v.cost && !finalized[v.vertex])
            {
                distTo[v.vertex] = distTo[u] + v.cost;
            }

        }
    }

}



class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(Node data) {
        Node node = data;
        if (this.first == null) {
            this.first = this.last = node;
        }else{
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public Node get(int index) throws Exception
    {
        Node current = first;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {

            if (count == index)
                return current;
            count++;
            current = current.next;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert(false);
        return null;
    }



    public boolean contains(int data) {
        Node current = this.first;

        while (current != null) {
            if (current.getCost() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }

}
class Node {

    public int vertex;
    public int cost;
    public Node next;

    public Node(int vertex, int cost) {
        this.cost = cost;
        this.vertex = vertex;
        this.next = null;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }
}

public class Queue<T> {


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
}
