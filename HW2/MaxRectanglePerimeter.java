import java.util.Scanner;

/**
 * Created by brendanmutton & nicoleganung on 9/23/18.
 */
public class MaxRectanglePerimeter {

    public static long greatestPerimeter = 0, tempPerimeter = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numInputs = scan.nextInt();

        Node[] vertex_array = new Node[numInputs];
        String[] shortStrArr = new String[2];
        String[] strArr = new String[numInputs * 2];

        scan.nextLine();

        for (int i  = 0; i < numInputs; i++) {
            shortStrArr = scan.nextLine().split(" ");
            vertex_array[i] = new Node(Long.parseLong(shortStrArr[0]), Long.parseLong(shortStrArr[1]));
        }

        long tempX = 0;
        Stack stack = new Stack();
        stack.push(vertex_array[1].getX(), vertex_array[1].getY());

        for (int i = 2; i < vertex_array.length; i++) {

            if (vertex_array[i].getY() > vertex_array[i - 1].getY() && vertex_array[i].getY() != stack.peek().getY())
                stack.push(vertex_array[i].getX(), vertex_array[i].getY());
            else if (vertex_array[i].getY() < stack.peek().getY()) {
                while (stack.peek().getY() <= vertex_array[i].getY()) {
                    calcPerimeter(vertex_array[i].getX(), stack.peek().getX(), stack.peek().getY());
                    tempX = stack.peek().getX();
                    stack.pop();
                }
                stack.push(tempX, vertex_array[i].getY());
            }
            calcPerimeter(vertex_array[i].getX(), stack.peek().getX(), stack.peek().getY());
        }

        System.out.println(greatestPerimeter);
    }

    /*
     */
    public static void calcPerimeter(long x_1, long x_2, long height) {
        tempPerimeter = ((x_1 - x_2) * 2) + (height * 2);
        if(tempPerimeter > greatestPerimeter){
            greatestPerimeter = tempPerimeter;
        }
    }
}

/*
 */
class Node {
    public long x;
    public long y;
    public Node next;

    /*
     */
    public Node(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /*
     */
    public long getX() {
        return x;
    }

    /*
     */
    public long getY() {
        return y;
    }

    /*
     */
    public void viewNode() {
        System.out.println("(" + this.x + ", " + this.y + ")");
        System.out.println("");
    }
}

/*
 */
class LinkedList {

    public Node first = null;

    /*
     */
    public void insert(long x, long y) {
        Node n = new Node(x, y);
        n.next = first;
        first = n;
    }

    /*
     */
    public Node delete_head() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    /*
     */
    public void printList() {
        Node n = first;

        while (n != null) {
            n.viewNode();
            n = n.next;
        }
    }

    /*
     */
    public boolean isEmpty() {
        return first == null;
    }
}

/*
 */
class Stack {

    LinkedList link = new LinkedList();

    /*
     */
    public void pop() {
        link.delete_head();
    }

    /*
     */
    public void push(long x, long y) {
        link.insert(x, y);
    }

    /*
     */
    public Node peek() {
        return link.first;
    }
}

