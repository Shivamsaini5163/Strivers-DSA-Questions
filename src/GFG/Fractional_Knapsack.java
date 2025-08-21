package GFG;

import java.util.Arrays;

//  Complexity =>   O(n log n)  O(1)
public class Fractional_Knapsack {
    // Helper class to store item info
    static class Item{
        int val,weight;
        Item(int v,int w){
            this.val=v;
            this.weight=w;
        }
    }
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        Item[] items=new Item[n];
        // Step 1: Create item objects
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        // Step 2: Sort items by value/weight ratio (descending)
        Arrays.sort(items,(a, b)->
                Double.compare((double)b.val / b.weight, (double)a.val / a.weight)
        );
        // Step 3: Greedy pick
        double totalValue = 0;
        int capacity = W;
        for(Item item : items){
            if(capacity==0) break;
            if(item.weight <= capacity){
                // Take the whole item
                totalValue += item.val;
                capacity -= item.weight;
            }else{
                // Take fractional part
                totalValue += ((double)item.val / item.weight) * capacity;
                capacity = 0;
            }
        }
        return totalValue;
    }
}
