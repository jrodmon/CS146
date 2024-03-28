package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(canFinish(numCourses1, prerequisites1));

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses2, prerequisites2));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();    // adjacency list to represent graph
        for (int i = 0; i < numCourses; i++) {              // create an adjacency list the size of the number of courses
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];                   // int array of size numCourses
        for (int[] prerequisite : prerequisites) {              // traverses through the List of prerequisites
            adjList.get(prerequisite[1]).add(prerequisite[0]);  // looks at course B (prereq), and adds course A (desired) to the adjList
            inDegree[prerequisite[0]]++;                        // increment indegree of course A
        }
        //Adjacency List built^

        // Topological Sort
        Queue<Integer> queue = new LinkedList<>();  // we use a queue for topological sort
        int counter = 0;                            // counter to track courses visited
        for (int i = 0; i < numCourses; i++) {      // add courses with indegree 0 to the queue
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {          // while the queue of nodes isnt empty
            int course = queue.poll();      // dequeue a course with indegree 0
            counter++;                      // new node visited, increment counter
            for (int destinationNode : adjList.get(course)) {
                inDegree[destinationNode] -= 1;         // Decrement in-degree of destinationNodes
                if (inDegree[destinationNode] == 0) {
                    queue.offer(destinationNode); // add destinationNode to queue if indegree = 0
                }
            }
        }

        return (counter == numCourses); //if the counter matches the numCourses then we correctly reached all nodes
    }
}
