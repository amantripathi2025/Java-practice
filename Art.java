import java.util.*;

public class Art {
    public static void user_logic(int n, List<int[]> positions) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        
        for (int[] pos : positions) {
            xs.add(pos[0]);
            ys.add(pos[1]);
        }
        
        Collections.sort(xs);
        Collections.sort(ys);
        
        long countX = 1, countY = 1;
        
        if (n % 2 == 1) {
            countX = 1;
            countY = 1;
        } else {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            countX = xs.get(mid2) - xs.get(mid1) + 1;
            countY = ys.get(mid2) - ys.get(mid1) + 1;
        }
        
        System.out.println(countX * countY);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> positions = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            positions.add(new int[]{x, y});
        }
        
        user_logic(n, positions);
        sc.close();
    }
}