
import java.util.*;

public class Spacecraft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        
        long[] pos = new long[n];
        long[] speed = new long[n];
        for (int i = 0; i < n; i++) pos[i] = sc.nextLong();
        for (int i = 0; i < n; i++) speed[i] = sc.nextLong();
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        
        // Sort by position descending (closest to destination first)
        Arrays.sort(indices, (a, b) -> Long.compare(pos[b], pos[a]));
        
        double maxTime = 0.0;
        int fleets = 0;
        
        for (int idx : indices) {
            double time = (double) (k - pos[idx]) / speed[idx];
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
            // else: this spaceship catches up to the fleet ahead, joins it
        }
        
        System.out.println(fleets);
    }
}