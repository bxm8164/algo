import java.util.Scanner;
/**
 * Created by brendanmutton & nicoleganung on 9/23/18.
 */
public class MaxRectanglePerimeter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numInputs = scan.nextInt();

        int [] arr = new int[numInputs * 2];
        String [] shortStrArr = new String[2];
        String [] strArr = new String[numInputs * 2];

        scan.nextLine();
        for(int i = 0; i <= numInputs+2; i+=2){
            shortStrArr = (scan.nextLine()).split(" ");
            strArr[i] = shortStrArr[0];
            strArr[i+1] = shortStrArr[1];
        }

        for(int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
            System.out.print(arr[i] + " ");
        }

        Stack stack = new Stack();

        // for retrieving x value, n/2
        // for retrieving y value, n/2-1
    }

    /*
     */
    public int calcPerimeter(int x_1, int x_2, int height){
        return ((x_2 - x_1)*2) + (height*2);
    }
}

class Node{
    public Node next;
    public int height;
    public int x;

    public Node(Node _next, int _height, int _x){
        next = _next;
        height = _height;
        x = _x;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node _next){
        next = _next;
    }
    public int getHeight(){
        return height;
    }
    public int getX(){
        return x;
    }
}

class LinkedList{
    public Node first;
    public Node current;

    public void insert(Node node){
        if(first == null){
            first = node;
            first.setNext(null);
            current = node;
        }
        else if(first.getNext() == null){
            current = node;
            first.setNext(node);
            current.setNext(null);
        }
        else{
            current = node;
            current.setNext(null);
        }
    }
    public boolean isEmpty(){
        if(first == null){
            return empty;
        }
    }
}

class Stack{
    public Stack(){

    }
    public void pop(){

    }
    public void push(){

    }
}

