import java.util.Scanner;

/*
 * Created by Nicole Ganung and Brendan Mutton
 */
public class MinWeightKnapsack{

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int numItems = scan.nextInt();
        int maxWeight = scan.nextInt();

        int item, itemWeight;
        double unsortedWeightedCost[] = new double[numItems];
        for(int i=0; i<numItems; i++){
            item = scan.nextInt();
            itemWeight = scan.nextInt();
            item/itemWeight = unsortedWeightedCost[i];
        }

    }

}