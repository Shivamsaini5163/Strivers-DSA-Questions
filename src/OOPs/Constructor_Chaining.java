package OOPs;

public class Constructor_Chaining {
    Constructor_Chaining(int a, int b){
        System.out.println(a*b);
    }
    Constructor_Chaining(int a){
        this(2,3);
    }
    Constructor_Chaining(){
        this(2);
        System.out.println("default");
    }

    public static void main(String[] args) {
        new Constructor_Chaining();
    }
}
//    Rules of constructor chaining :
//        The this() expression should always be the first line of the constructor.
//        There should be at-least be one constructor without the this() keyword (constructor 3 in above example).
//        Constructor chaining can be achieved in any order.
