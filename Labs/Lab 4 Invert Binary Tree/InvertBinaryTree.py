class Solution(object):
    def invertTree(self, root):
        if root is None:
            return None
        temp = root.left
        root.left = root.right
        root.right = temp
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
  
class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right
        
        
root = TreeNode(1)
root.left = TreeNode(2)
root.left.left = TreeNode(3)
root.left.right= TreeNode(4)
root.right = TreeNode(8)
root.right.left = TreeNode(5)
root.right.right = TreeNode(6)

print(root.val)
print(root.left.val, root.right.val)
print(root.left.left.val, root.left.right.val, root.right.left.val,  root.right.right.val)

solution = Solution()

invertedTree = solution.invertTree(root)
print(invertedTree.val)
print(invertedTree.left.val, invertedTree.right.val)
print(invertedTree.left.left.val, invertedTree.left.right.val, invertedTree.right.left.val,  invertedTree.right.right.val)
