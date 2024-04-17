def findTheCity(n, edges, distanceThreshold):
    # Initialize the distance matrix with maximum values
    distance = [[float('inf')] * n for i in range(n)]
    
    for edge in edges:
        fromNode, toNode, weight = edge
        distance[fromNode][toNode] = weight
        distance[toNode][fromNode] = weight  # bidirectional edge, so update the reverse direction
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if distance[i][k] != float('inf') and distance[k][j] != float('inf'):
                    distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])  #sets the shorter distance between i to j and i to k to j
    
    minReachable = n                # initialize with maximum nodes
    result = -1                     # initialize 
    for i in range(n):
        reachableCounter = 0        # Counter for reachable cities
        for j in range(n):
            if i != j and distance[i][j] <= distanceThreshold:
                reachableCounter += 1                       ##inc reachableCounter if less than threshold
        
        if reachableCounter <= minReachable:
            minReachable = reachableCounter
            result = i
    
    return result

if __name__ == "__main__":
    n1 = 4
    edges1 = [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
    distanceThreshold1 = 4
    print("Test Case 1:", findTheCity(n1, edges1, distanceThreshold1))

    n2 = 5
    edges2 = [[0, 1, 2], [0, 4, 8], [1, 2, 3], [1, 4, 2], [2, 3, 1], [3, 4, 1]]
    distanceThreshold2 = 2
    print("Test Case 2:", findTheCity(n2, edges2, distanceThreshold2))
