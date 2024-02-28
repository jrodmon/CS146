class Solution:
    def longestPalindrome(self, s: str) -> int:
        palindromeLength = 0
        isOdd = False
        charCount = {}

        for c in s:
            charCount[c] = charCount.get(c, 0) + 1

        for count in charCount.values():
            if count % 2 == 0:
                palindromeLength += count
            else:
                palindromeLength += count - 1
                isOdd = True

        if isOdd:
            palindromeLength += 1

        return palindromeLength

solution = Solution()
s = "abccccdd"
print(solution.longestPalindrome(s))
