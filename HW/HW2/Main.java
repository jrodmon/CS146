package org.example;

public class Main {
  public static void main(String[] args) {
    System.out.print(firstBadVersion(20));  //not really sure how to check my code with this specific problem...
  }

  public int firstBadVersion(int endpoint) {
    int beginning = 0;
    int end = endpoint;
    int midpoint = (beginning + end) / 2;

    
    while (beginning < end) {   
      if (isBadVersion(midpoint)) {    //if there is a bad version at the mid, start checking the left half
        end = midpoint;
        midpoint = (beginning + end) / 2;
      }
      else if (!isBadVersion(midpoint)) {  //if there is not a bad version at the midpoint, start checking the right half
        beginning = midpoint;
        midpoint = (beginning + end) / 2;

      if (beginning == midpoint && isBadVersion(end))  //after enough splitting, the beginning will overlap with the midpoint, and when it does, that means the beginning and the end are next to each other
        return beginning + 1;
      }
    }  //wait this is an infinite while loop......
     return -1; // this is if there is no bad version 

  }
