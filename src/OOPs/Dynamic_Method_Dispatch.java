package OOPs;

public class Dynamic_Method_Dispatch {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        C c=new C();
        A ref;
        ref=a;
        ref.print();
        ref=b;
        ref.print();
        ref=c;
        ref.print();
    }
}
class A{
    void print(){
        System.out.println("hey i am in OOPs.A class");
    }
}
class B extends A{
    void print(){
        System.out.println("hey i am in OOPs.B class");
    }
}
class C extends A{
    void print(){
        System.out.println("hey i am in OOPs.C class");
    }
}
