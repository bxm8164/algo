import java.util.Scanner;
public class NetworkConnect{
    public static int numComputers, numConnections, source, sink;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] a = line.split(" ");
        numComputers = Integer.parseInt(a[0]);
        numConnections = Integer.parseInt(a[1]);

        String line1 = scan.nextLine();
        String[] b = line1.split(" ");
        source = Integer.parseInt(b[0]);
        sink = Integer.parseInt(b[1]);

        Graph graph = new Graph(numComputers, numConnections);
        int s = source;
        int t = sink;

        for(int i=0; i<numComputers; i++){
            line = scan.nextLine().split(" ");
            int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]), w = Integer.parseInt(input[2]);
            if(w < 0){
                s=v;
            }
            g.adj[u].add(new Node(v,w));
        }
        //g.maxFlow(s, t);
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

    public void bfs(Graph G, Node s) throws Exception{
        marked = new boolean[V];
        edgeTo = new int[V];
        distTo = new int[V];
        numPaths = new int[V];
        Queue q = new Queue();
        for(int i = 0; i<G.V; i++)
            marked[i] = false;
        for (int v = 0; v < G.V; v++)
            distTo[v] = Integer.MAX_VALUE;
        for(int i = 0; i<G.V; i++)
            numPaths[i] = 0;

        distTo[s.vertex] = 0;
        numPaths[s.vertex] = 1;
        marked[s.vertex] = true;
        q.enqueue(s.vertex, s.cost);

        while (!q.isEmpty()) {
            Node v = q.dequeue();

            for(int i = s.vertex; i<=adj[v.vertex].size(); i++)
            {
                Node w = adj[v.vertex].get(i-1);
                if (!marked[w.vertex]) {
                    marked[w.vertex] = true;
                    q.enqueue(w.vertex, w.cost);
                }
                if(distTo[w.vertex] > distTo[v.vertex]+1)
                {
                    edgeTo[w.vertex] = v.vertex;
                    distTo[w.vertex] = distTo[v.vertex] + 1;
                    numPaths[w.vertex] = numPaths[v.vertex];
                }
                else if(distTo[w.vertex] == distTo[v.vertex]+1)
                    numPaths[w.vertex] += numPaths[v.vertex];
            }

        }

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
class Queue {

    public Node first, last;

    public Queue(){
        first = null;
        last = null;
    }


    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(int t, int tt){
        Node oldLast = last;
        last = new Node(t, tt);
        if (isEmpty()) first = last;
        else   oldLast.next = last;
    }

    public Node dequeue(){
        if (isEmpty())
            return  null;

        if (first == last){
            first = last = null;
            return first;
        }

        Node t = first;
        first = first.next;
        return t;
    }
}
