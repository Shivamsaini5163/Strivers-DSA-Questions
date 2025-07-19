package Leetcode;
//leetcode 134
public class  Gas_Station{
    //Brute Force O(N^2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            int j=0; //no.of stations visited
            int fuel=0;
            while(j<n){
                int curr_station=(i+j)%n;
                fuel+=gas[curr_station];
                fuel-=cost[curr_station];
                if(fuel<0) break;  // Can't proceed, break
                j++;
            }
            if(j==n){
                return i; // Successfully completed the circuit
            }
        }
        return -1; // No valid starting station found
    }
    //Optimize Approach using Greedy Approach O(N)
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n=gas.length;
        int total_gas=0,total_cost=0;
        for(int i=0;i<n;i++){
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
        if(total_gas<total_cost) return -1;
        //now we have guarantee that the solution exists
        int total=0;
        int ans=0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                ans=i+1;
            }
        }
        return ans;
    }
}
