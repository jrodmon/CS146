def isPalindrome(s):
    lowerString = s.lower()
    newString = ""

    for ch in lowerString:
        if ch.isalpha() or ch.isnumeric():
            newString += ch

    index1 = 0
    index2 = len(newString) - 1

    while index1 < index2:
        if newString[index1] != newString[index2]:
            return False
        index1 += 1
        index2 -= 1
    return True

#if __name__ == "__main__":
#    print(isPalindrome("Too hot to hoot. "))
