import java.util.Scanner;
/*
 * Created by Brendan Mutton & Nicole Ganung
 */

class Prerequisites{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Vertex[] courses = new Vertex[n];

        for(int i = 1; i<n; i++){
            Vertex v = new Vertex(i);
            courses[i] = v;
        }

        Graph g = new Graph(courses);
    }
}

class Sort{
    public Sort(){

    }
    public int dfs(Graph g){
        return 0;
    }
    public void sort(){

    }
}

class Graph{
    public Vertex courses[];

    public Graph(Vertex[] courses){
        this.courses = courses;
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < courses.length; i++){
            String pre = scan.nextLine();
            String[] preReqs = pre.split(" ");
            courses[i].addEdges(preReqs);
        }
    }
}

class Edge{
    public int course,prereq;

    public Edge(int course, int prereq){
        this.course = course;
        this.prereq = prereq;
    }
}

class Vertex{
    public int courseNumber;
    public Edge[] edges;
    public int counter = 0;

    public Vertex(int courseNumber){
        this.courseNumber = courseNumber;
    }

    public void addEdges(String[] arr){
        //add edges
    }
}

