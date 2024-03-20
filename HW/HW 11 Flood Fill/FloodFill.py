from collections import deque

class Solution:
    def floodFill(self, image, sr, sc, color):
        if not image or not image[0]:
            return image

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        queue = deque()
        visited = [[False for i in range(len(image[0]))] for i in range(len(image))]
        initialColor = image[sr][sc]


        if initialColor == color:
            return image

        queue.append((sr, sc))
        visited[sr][sc] = True

        while queue:
            row, col = queue.popleft()
            image[row][col] = color

            for rowDir, colDir in directions:
                newRow, newCol = row + rowDir, col + colDir
                if 0 <= newRow < len(image) and 0 <= newCol < len(image[0]) and not visited[newRow][newCol] and image[newRow][newCol] == initialColor:
                    queue.append((newRow, newCol))
                    visited[newRow][newCol] = True

        return image

def main():
    # Test the function
    image = [
        [1, 1, 1],
        [1, 1, 0],
        [1, 0, 1]
    ]
    sr = 1
    sc = 1
    color = 2
    sol = Solution()
    result = sol.floodFill(image, sr, sc, color)
    for row in result:
        print(row)

if __name__ == "__main__":
    main()
