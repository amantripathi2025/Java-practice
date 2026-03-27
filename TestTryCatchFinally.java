import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTryCatchFinally {
    static void main() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter first number: ");
            int x = Integer.parseInt(br.readLine());
            System.out.println("Enter second number: ");
            int y = Integer.parseInt(br.readLine());

            int z = x/y;
            System.out.println(z);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        catch (ArithmeticException ae){
            ae.printStackTrace();
        }
        finally {
            System.out.println("Finally block running \nBye! Bye!");

        }
    }
}
