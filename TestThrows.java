package example.com;

import java.io.DataInputStream;
import java.io.IOException;

class GetInput{
    DataInputStream dis =  new DataInputStream(System.in);
    String name;
    void getAndDisplayName() throws IOException {
        System.out.println("Enter your name: ");
        name = dis.readLine();
        System.out.println("Your name is "+name);
    }
}

public class TestThrows {
    static void main() throws IOException /*throws IOException*/ {
//            DataInputStream dis = new DataInputStream(System.in);
//            System.out.println("Enter Name: ");
//            String name = dis.readLine();
//            System.out.println("Name: " + name);
//
        display();

    }
    static void display() throws IOException {
        GetInput dis = new GetInput();
        dis.getAndDisplayName();
    }
}
