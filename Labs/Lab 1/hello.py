nums = [1,2,3,4,5,6,7,8,9]
target = 17
intMap = {}

# put the index of a value into a map, with the key being difference
for i in range(len(nums)):
    difference = target - nums[i]
    intMap[difference] = i

# iterate through the array and if the value is there, then there is a solution
for i in range(len(nums)):
    if nums[i] in intMap and i != intMap[nums[i]]:
        print(i, intMap[nums[i]])