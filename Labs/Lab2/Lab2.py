def isAnagram(s, t):
    if len(s) != len(t):
        return False
    
    # now we have to sort the string
    sortedS = sorted(s)
    sortedT = sorted(t)

    if sortedS != sortedT:
        return False

    return True


if __name__ == "__main__":
    s = "abcD"
    t = "Dbca"
    print(isAnagram(s,t))