import java.util.Scanner;
/*
 * Created by Brendan Mutton & Nicole Ganung
 */

public class NumPaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numVerticies = scan.nextInt(); // n
        int numEdges = scan.nextInt(); // m

        Vertex[] points = new Vertex[numVerticies];

        int x,y;
        for (int i = 0; i < numVerticies; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            points[i] = new Vertex(x, y);
            scan.nextLine();
        }

        numPaths(points);
    }

    public static void numPaths(Vertex[] points){

    }
}

class Vertex {
    int x = 0;
    int y = 0;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}