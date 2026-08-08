import java.util.*;

public class Total {

    public static int userLogic(int n, List<int[]> positionsCards) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        for (int[] pc : positionsCards) {
            int p = pc[0];
            int c = pc[1];
            if (p < 0) left.add(pc);
            else if (p > 0) right.add(pc);
        }

        // Sort by distance from 0 (closest first)
        left.sort((a, b) -> Integer.compare(Math.abs(a[0]), Math.abs(b[0])));
        right.sort((a, b) -> Integer.compare(Math.abs(a[0]), Math.abs(b[0])));

        // Try both starting directions
        int maxCards = 0;
        
        // Start right
        int lIdx = 0, rIdx = 0;
        boolean movingRight = true;
        int cards = 0;
        while (lIdx < left.size() || rIdx < right.size()) {
            if (movingRight) {
                if (rIdx >= right.size()) {
                    // No more right cards, game ends
                    break;
                }
                cards += right.get(rIdx)[1];
                rIdx++;
                movingRight = false;
            } else {
                if (lIdx >= left.size()) {
                    // No more left cards, game ends
                    break;
                }
                cards += left.get(lIdx)[1];
                lIdx++;
                movingRight = true;
            }
        }
        maxCards = Math.max(maxCards, cards);

        // Start left
        lIdx = 0; rIdx = 0;
        movingRight = false;
        cards = 0;
        while (lIdx < left.size() || rIdx < right.size()) {
            if (movingRight) {
                if (rIdx >= right.size()) {
                    break;
                }
                cards += right.get(rIdx)[1];
                rIdx++;
                movingRight = false;
            } else {
                if (lIdx >= left.size()) {
                    break;
                }
                cards += left.get(lIdx)[1];
                lIdx++;
                movingRight = true;
            }
        }
        maxCards = Math.max(maxCards, cards);

        return maxCards;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> positionsCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            positionsCards.add(new int[]{p, c});
        }
        System.out.println(userLogic(n, positionsCards));
        scanner.close();
    }
}