import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
         fun(25,24,55,43,55,3,34);
    }
    static void fun(int...v){
        System.out.println(Arrays.toString(v));
    }
}
