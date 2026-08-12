public class LeetcodeWealth {
    public static void main(String[] args) {
      int[][]nums =  {
              {1,2,3},
              {3,2,1}
      };
        System.out.println(maximumWealth(nums));
    }
    static int ans = Integer.MIN_VALUE;
    public static int maximumWealth(int[][] accounts) {
        for(int person = 0; person < accounts.length; person++){
            int sum = 0;
            for(int account = 0; account < accounts[person].length; account++){
                sum += accounts[person][account];
                if(sum > ans){
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
