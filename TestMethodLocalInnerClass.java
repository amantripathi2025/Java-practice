package example.com;

class OuterLocal{
    void myMethod(){
        class InnerLocal{
            void myLocalMethod(){
                System.out.println("Inner local class in method");
            }
        }

        InnerLocal ob = new InnerLocal();
        ob.myLocalMethod();
    }

}




public class TestMethodLocalInnerClass {
   static void main() {

        OuterLocal ob = new OuterLocal();
        ob.myMethod();
    }
}
