import math
n = int(input("Enter a No.: "))
if n < 2:
    print("Non-Prime")
else:
    prime = True
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            prime = False
            break
    if prime:
        print("Prime")
    else:
        print("Non-Prime")
