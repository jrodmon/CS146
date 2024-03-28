from collections import deque

def canFinish(numCourses, prerequisites):
    adjList = [[] for i in range(numCourses)] #build adjacency list
    indegree = [0] * numCourses
    for a, b in prerequisites:
        adjList[b].append(a)
        indegree[a] += 1

    queue = deque()         #Topological Sort
    counter = 0
    for i in range(numCourses):
        if indegree[i] == 0:
            queue.append(i)

    while queue:
        course = queue.popleft()
        counter += 1
        for destinationNode in adjList[course]:
            indegree[destinationNode] -= 1
            if indegree[destinationNode] == 0:
                queue.append(destinationNode)

    return counter == numCourses

if __name__ == "__main__":
    numCourses1 = 2
    prerequisites1 = [[1, 0]]
    print(canFinish(numCourses1, prerequisites1))

    numCourses2 = 2
    prerequisites2 = [[1, 0], [0, 1]]
    print(canFinish(numCourses2, prerequisites2))
