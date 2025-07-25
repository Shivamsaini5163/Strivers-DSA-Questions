package GFG;

public class Find_XOR_of_numbers_from_L_to_R {
    public static int findXOR(int l, int r) {
        return XORSum(r)^XORSum(l-1);
    }
    private static int XORSum(int n){
        //Find the Pattern
        if(n%4==0){
            return n;
        }else if(n%4==1){
            return 1;
        }else if(n%4==2){
            return n+1;
        }else{
            return 0;
        }
    }
}
