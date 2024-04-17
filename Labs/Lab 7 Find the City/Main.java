import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold1 = 4;
        System.out.println("Test Case 1: " + findTheCity(n1, edges1,distanceThreshold1));

        int n2 = 5;
        int[][] edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold2 = 2;
        System.out.println("Test Case 2: " + findTheCity(n2,edges2,distanceThreshold2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];   // an n by n matrix the length of the number of nodes
        int inf = Integer.MAX_VALUE;        // infinity value, used when no edge connects two nodes
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], inf);  // fill matrix with infinity values
            distance[i][i] = 0;             // set the diagonal to 0
        }

        for (int[] edge : edges) {          // place the edge values in the correct spot
            int from = edge[0];             // from this node
            int to = edge[1];               // to this node
            int weight = edge[2];           // will be this weighted value
            distance[from][to] = weight;
            distance[to][from] = weight;    // bidirectional, so we update the weight on both directions
        }

        for (int k = 0; k < n; k++) {       //Floyd Warshalls
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != inf && distance[k][j] != inf) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);  //chooses least between i to j and i to j to k
                    }
                }
            }
        }

        int minReachable = n;           // set minimum reachable nodes to the number of nodes
        int result = -1;                // initialize result with filler
        for (int i = 0; i < n; i++) {
            int reachableCounter = 0;           // Counter for reachable cities
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    reachableCounter++;         //inc counter if the distance between two cities is within the distanceThreshold
                }
            }

            if (reachableCounter <= minReachable) {     //if the current city has less reachable cities
                minReachable = reachableCounter;        //set the minReachable cities the counter
                result = i;                             //updates to the highest node city.
            }
        }

        return result;
    }

}
