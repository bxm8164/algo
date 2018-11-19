import java.util.Arrays;

public class Graph{

    public int V;
    public LinkedList<Integer> adj[];
    public boolean[] marked;  // marked[v] = is there an s-v path
    public int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    public int[] distTo;
    public int[] numPaths;

    /**
     *  We initialize the Graph with number of vertices v in the graph
     */
    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * This method will add an  edge between node u and w.
     */
    void addEdge(int u, int w){
        adj[u].add(w);
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
}
