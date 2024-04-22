import java.util.*;

class Main {
    public static void main(String[] args) {
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
        System.out.println("Output: " + minCostToSupplyWater(n, wells, pipes));

        int n2 = 3;
        int[] wells2 = {3, 4, 2};
        int[][] pipes2 = {{1, 2, 5}, {1, 2, 7}, {2, 3, 3}, {1, 3, 8}};
        System.out.println("Output: " + minCostToSupplyWater(n2, wells2, pipes2));
    }

    private static int find(int x, int[] p) {
        if (x != p[x]) {
            p[x] = find(p[x], p);
        }
        return p[x];    //searches for a node
    }

    private static boolean union(int x, int y, int[] p, int[] rank) {
        int rootX = find(x, p);
        int rootY = find(y, p);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {
            p[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            p[rootX] = rootY;
        } else {
            p[rootX] = rootY;
            rank[rootY]++;
        }

        return true;        //adds a node to ta group of connected nodes
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] p = new int[n + 1];           //parent node
        int[] rank = new int[n + 1];        //represents the depth of each node
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }

        List<int[]> arr = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < wells.length; i++) {
            arr.add(new int[]{0, i + 1, wells[i]});
        }

        for (int[] pipe : pipes) {
            arr.add(new int[]{pipe[0], pipe[1], pipe[2]});
        }

        Collections.sort(arr, Comparator.comparingInt(a -> a[2]));  //sorts the array from least to greatest

        for (int[] edge : arr) {
            if (union(edge[0], edge[1], p, rank)) {
                result += edge[2];
            }
        }

        return result;
    }


}
