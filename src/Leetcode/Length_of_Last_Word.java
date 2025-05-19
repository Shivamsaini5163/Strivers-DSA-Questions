package Leetcode;
//leetcode 58
//Time and Space Complexity =>    O(N) O(1)
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                count++;
            }
            else if(count>0){
                return count;
            }
        }
        return count;
    }
    //using libraries but you are modifying string here
    public int lengthOfLastWord2(String s) {
        s=s.trim();
        int lastindex=s.lastIndexOf(' ');
        return s.length()-lastindex-1;
    }

    //2nd Method but not optimized so not use this one
//    private static int method_2(String s){
//        int count=0;
//        int lastWordLength=0;
//        for (char i:s.toCharArray()) {
//            if (!Character.isSpaceChar(i)){
//                count++;
//            }
//            else {
//                if (count>0){
//                    lastWordLength=count;
//                }
//                count=0;
//            }
//        }
//        if (count>0){
//            return count;
//        }
//        else {
//            return lastWordLength;
//        }
//    }
}
