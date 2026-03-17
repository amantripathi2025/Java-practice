package Intermediate;

interface A{
    default void hello(){
        System.out.println("Hello, I'm Aman");
    }
}

interface B{
    default void hello (){
        System.out.println("Hello from B");
    }
}

class C implements A,B{
    @Override
    public void hello(){
        A.super.hello();
        System.out.println("Hello from C--- conflict resolved");
    }
}




public class Q12 {
    static void main() {
        C obj = new C();
        obj.hello();
    }
}
