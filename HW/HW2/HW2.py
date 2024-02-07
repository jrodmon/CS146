def firstBadVersion(endpoint)
  beginning = 0
  end = endpoint
  midpoint = (beginning + end) // 2

  while beginning < end:
    if isBadVersion(midpoint):
      end = midpoint
      midpoint = (beginning + end) // 2
    elif not isBadVersion(midpoint)
      beginning = midpoint
      midpoint = (beginning + end) // 2

    if beginning == midpoint and isBadVersion(end):
      return beginning + 1
      
  return -1

if __name__ == "__main__":
  print(firstBadVersion(20))
