import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String s = "i.like.this.program.very.much";
        String[] words=s.split("\\.+");
        System.out.println(Arrays.toString(words));
        StringBuilder sb=new StringBuilder();
        int n=words.length;
        for(int i=n-1;i>=0;i--){
            sb.append(words[i]);
            if (i != 0) {
                sb.append(".");
            }
        }
    }
}
