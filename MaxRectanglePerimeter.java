import java.util.Scanner;
/**
 * Created by brendanmutton & nicoleganung on 9/23/18.
 */
public class MaxRectanglePerimeter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numInputs = scan.nextInt();

        Node[] vertex_array = new Node[numInputs];
        String [] shortStrArr = new String[2];
        String [] strArr = new String[numInputs * 2];

        scan.nextLine();

        for(int i = 0; i < numInputs; i++)
        {
            shortStrArr = scan.nextLine().split(" ");
            vertex_array[i] = new Node(Long.parseLong(shortStrArr[0]), Long.parseLong(shortStrArr[1]));
        }


        Stack stack = new Stack();


        
        // for retrieving x value, n/2
        // for retrieving y value, n/2-1
    }

    /*
     */
    public long calcPerimeter(long x_1, long x_2, long height){
        return ((x_2 - x_1)*2) + (height*2);
    }
}

class Node{
    public long x;
    public long y;
    public Node next;


    public Node(long x, long y)
    {
        this.x = x;
        this.y = y;
    }

    public void viewNode()
    {
        System.out.println("("+this.x + ", " + this.y+")");
        System.out.println("");
    }
}

class LinkedList{
    public Node first = null;

    public void insert(long x, long y)
    {
        Node n = new Node(x, y);
        n.next = first;
        first = n;
    }

    public Node delete_head()
    {
        Node temp = first;

        first = first.next;

        return temp;
    }

    public void printList()
    {
        Node n = first;
        while(n != null)
        {
            n.viewNode();
            n = n.next;
        }
    }

    public boolean isEmpty()
    {
        return first == null;
    }
}

class Stack{
    LinkedList link = new LinkedList();

    public void pop(){
        link.delete_head();
    }
    public void push(long x, long y){
        link.insert(x, y);

    }
    public Node peek()
    {
        return link.delete_head();
    }
}

