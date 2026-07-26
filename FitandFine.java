import java.util.*;

class FitandFine {
    public static int[] userLogic(int[] fat, int[] protein, int[] vitamin) {
        Set<Integer> fatSet = new HashSet<>();
        Set<Integer> proteinSet = new HashSet<>();
        Set<Integer> vitaminSet = new HashSet<>();
        
        for (int f : fat) fatSet.add(f);
        for (int p : protein) proteinSet.add(p);
        for (int v : vitamin) vitaminSet.add(v);
        
        int countFat = 0, countProtein = 0, countVitamin = 0;
        
        // Count items in fat that are not in protein and vitamin
        for (int f : fat) {
            if (!proteinSet.contains(f) && !vitaminSet.contains(f)) {
                countFat++;
            }
        }
        
        // Count items in protein that are not in fat and vitamin
        for (int p : protein) {
            if (!fatSet.contains(p) && !vitaminSet.contains(p)) {
                countProtein++;
            }
        }
        
        // Count items in vitamin that are not in fat and protein
        for (int v : vitamin) {
            if (!fatSet.contains(v) && !proteinSet.contains(v)) {
                countVitamin++;
            }
        }
        
        return new int[]{countFat, countProtein, countVitamin};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fat = new int[N];
        int[] protein = new int[N];
        int[] vitamin = new int[N];
        
        for (int i = 0; i < N; i++) fat[i] = sc.nextInt();
        for (int i = 0; i < N; i++) protein[i] = sc.nextInt();
        for (int i = 0; i < N; i++) vitamin[i] = sc.nextInt();
        
        int[] result = userLogic(fat, protein, vitamin);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        sc.close();
    }
}