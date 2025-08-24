package Leetcode;

// leetcode 860
// Complexity =>  O(N)    O(1)
public class Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,twenty=0;
        for(int bill:bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(ten>0&&five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
