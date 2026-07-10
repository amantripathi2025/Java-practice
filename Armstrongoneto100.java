public class Armstrongoneto100 {
    public static void main(String[]args){
        int i = 1;
        while(i <= 500){
            int temp =  i;
            int sum = 0;
            while(temp > 0){    
                int d = temp % 10;
                sum = sum + (d * d * d);
                temp = temp / 10;
            }
            if(sum == i){
                System.out.print(i + ", " );
               
            }
            
            i++;
        }

        System.out.print("is an armstrong number ");
    }
}
