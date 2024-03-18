from typing import List, Optional
from collections import deque

class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return[]
        treeList = []
        queue = deque()
        queue.append(root)
        
        while queue:
            levelSize = len(queue)
            currentLevel = []
            for i in range(levelSize):
                currentNode = queue.popleft()
                currentLevel.append(currentNode.val)
                if(currentNode.left):
                    queue.append(currentNode.left)
                if(currentNode.right):
                    queue.append(currentNode.right)
            treeList.append(currentLevel)
        return treeList
    
def main():
    solution = Solution()
    root = TreeNode(4)
    root.left = TreeNode(3)
    root.left.left = TreeNode(1)
    root.right = TreeNode(8)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(9)
    print(solution.levelOrder(root))
    
if __name__ == "__main__":
    main()
