def fibonacci(n):
    firstValue = 0
    secondValue = 1
    newValue = 0
    for i in range (1,n):
        newValue = firstValue + secondValue
        firstValue = secondValue
        secondValue = newValue
    return firstValue

def main():
    print(fibonacci(7))
    
if __name__ == "__main__":
    main()
