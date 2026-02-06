package in.kgcoding.challange82;

public class ArrayOperations {
    private int[] numbers;
    public  class Stastics{
        double mean(){
            return 0;

        }

        double median(){
            double sum = 0;
            for(int number : numbers){
                sum += number;
            }
            return sum/numbers.length;
        }
    }
}
