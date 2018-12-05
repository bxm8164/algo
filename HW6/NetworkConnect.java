import java.util.Scanner;
public class NetworkConnect{
    public static int numComputers, numConnections, serverNum, userNum;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] a = line.split(" ");
        numComputers = Integer.parseInt(a[0]);
        numConnections = Integer.parseInt(a[1]);

        Node[] network = new Node[numComputers];
        Edge[] connections = new Edge[numConnections];

        String line1 = scan.nextLine();
        String[] b = line1.split(" ");
        serverNum = Integer.parseInt(b[0]);
        userNum = Integer.parseInt(b[1]);

        for(int i=0; i<numComputers; i++){
            network[i] = new Node(i);
            if(network[i].getId() == serverNum){
                network[i].setServer(true);
            } else if(network[i].getId() == userNum){
                network[i].setClient(true);
            }
        }
        for(int j=0; j<numConnections; j++){
            String line2 = scan.nextLine();
            String[] edgeInfo = line2.split(" ");
            Node start = null;
            Node end = null;
            for(int k=0; k<network.length; k++){
                if(network[k].getId() == Integer.parseInt(edgeInfo[0])){
                    start = network[k];
                } else if(network[k].getId() == Integer.parseInt(edgeInfo[1])){
                    end = network[k];
                }
            }
            connections[j] = new Edge(start, end, Integer.parseInt(edgeInfo[2]));
        }
    }
}

class Node{
    public Edge[] edges;
    public int id;
    public boolean server = false, client = false;
    public Node(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void addEdge(Edge newEdge){

    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public void setServer(boolean server) {
        this.server = server;
    }
}

class Edge{
    public Node start;
    public Node end;
    public int bandwitdth;
    public Edge(Node start, Node end, int bandwidth){
        this.start = start;
        this.end = end;
        this.bandwitdth = bandwidth;
    }

    public int getBandwitdth() {
        return bandwitdth;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }
}