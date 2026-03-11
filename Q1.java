class Animal {
     void speak() {
         System.out.println("Animal make sound");
     }
 }

    class Dog extends Animal{
        @Override
                void speak(){
            super.speak();
            System.out.println("Dog woof");
        }
    }

    class Cat extends Animal{
        @Override
        void speak() {
            super.speak();
            System.out.println("Cate Meow");
        }
    }
    public class Q1 {
        public static void main(String[] args) {
            Animal d = new Dog();
            Animal c = new Cat();
            d .speak();
            System.out.println("-----------------");
            c.speak();

        }
    }


