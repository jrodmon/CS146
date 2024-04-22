from typing import List

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        p = [i for i in range (n+1)]        # parent node
        rank = [0] * (n+1)                  # represents the depth of each node

        def find(x):
            if x!= p[x]:
                p[x] = find(p[x])
            return p[x]                  # searches for a node
        
        def union(x,y):
            rootx = find(x)
            rooty = find(y)

            if rootx == rooty:
                return False
            
            if rank[rootx] > rank[rooty]:
                p[rooty] = rootx
            elif rank[rootx] < rank[rooty]:
                p[rootx] = rooty
            else:
                p[rootx] = rooty
                rank[rooty] += 1            #adds a node to a group of connected nodes
            
            return True
        

        arr = []
        result = 0

        for i in range(len(wells)):         # iterates for the number of wells
            arr.append((0, i+1, wells[i]))  # adds (dummyNode, nodeNumber, cost of a well) to 
                                            # creates the edges connecting each house to the dummyNode

        for house1, house2, cost in pipes:
            arr.append((house1,house2,cost))      # adds each edge and weight in the graph to arr

        arr.sort(key=lambda x: x[2])            #sorts the array based off the third element, or the cost of the edge

        for house1, house2, cost in arr:
            if union(house1, house2):
                result += cost

        return result
    
if __name__ == "__main__":
    n = 2
    wells = [1,1]
    pipes = [[1,2,1], [1,2,2]]

    solution = Solution()
    print("Output:", solution.minCostToSupplyWater(n, wells, pipes))


    n = 3
    wells = [3,4,2]
    pipes = [[1,2,5],[1,2,7], [2,3,3], [1,3,8]]

    solution = Solution()
    print("Output:", solution.minCostToSupplyWater(n, wells, pipes))
