//Samajhana haii ek baar aur
public class LeetcodeEven {
    public static void main(String[] args) {
       int[]nums = {12,456,7890,2345, -2345};
        System.out.println(findNumbers(nums));
    }
    static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(even(num)){
                 count++;
            }
        }
        return count;
    }

     static boolean even(int num) {
           int NumberOfDigits = digits(num);
           /*if(NumberOfDigits % 2 == 0){
               return true;
           }
           return false;
            */
         return NumberOfDigits % 2 == 0;
    }

    static int digits(int num){
        if(num < 0){
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        int count = 0;
        while(num > 0){
            count ++;
            num =  num / 10;
        }
        return count;
    }
}
