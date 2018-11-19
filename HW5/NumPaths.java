import java.util.Scanner;

public class NumPaths {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        String[] n_m = sc.nextLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        String[] s_t = sc.nextLine().split(" ");
        int s = Integer.parseInt(s_t[0]);
        int t = Integer.parseInt(s_t[1]);

        Graph g = new Graph(n+1);
        for(int i = 0; i<m; i++)
        {
            String[] e = sc.nextLine().split(" ");
            g.addEdge(Integer.parseInt(e[0]), Integer.parseInt(e[1]));
            g.addEdge(Integer.parseInt(e[1]), Integer.parseInt(e[0]));
        }

        g.bfs(g, s);

        System.out.println(g.numPaths[t]);

    }
}


