package Leetcode;
import java.util.*;
//leetcode 380
public class Insert_Delete_GetRandom_O_1 {
}
class RandomizedSet {
    List<Integer> list; // maintain constant insertion
    Map<Integer,Integer> map;   // maintain constant removing by storing indexes to avoid shifting of elements
    Random rand;    // for random index generation
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        rand=new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        //swap the last element with removing element
        //to avoid shifting of elements after removal operation internally
        int index = map.get(val);
        int last=list.get(list.size()-1);
        list.set(index,last);
        map.put(last,index);    //update the map

        list.remove(list.size()-1);  //remove from last
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
