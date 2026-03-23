package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class challange88 {
    public static class RobustFileReader {
        static void main() {
            Scanner input = new Scanner(System.in);

            System.out.println("Please enter the name of file you wish to read: ");
            String fileName = input.next();

            try(FileReader reader = new FileReader(fileName)){
                int read;
                while((read = reader.read()) != -1) {
                    System.out.print((char)read);
                }
            } catch(FileNotFoundException exception){
                System.out.printf("File not found exception %s: ",fileName );
            }


            catch (IOException e) {
                System.out.printf("Exception occured: %s",
                        e.getMessage());
            }
        }
    }
}
