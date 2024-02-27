from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:   
        count = 0
        endPointer = 0
        startTimes = []
        endTimes = []
        for i in intervals:
            startTimes.append(i[0])
            endTimes.append(i[1])  
            
        startTimes.sort()
        endTimes.sort()
        
        for i in startTimes:
            if i < endTimes[endPointer]:
                count += 1
            else: 
                endPointer +=1
        return count      

def main():
    solution = Solution()
    intervals = [[0,30],[5,10],[15,20],[7,25]]
    print(solution.minMeetingRooms(intervals))

if __name__ == "__main__":
    main()
