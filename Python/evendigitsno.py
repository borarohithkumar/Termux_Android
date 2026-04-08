for i in range(1000, 3001):
    n = i
    disp = True
    while n > 0:
        d = n % 10
        if d & 1:
            disp = False
            break
        n //= 10
    if disp:
        print(f"{i}", end = ", ")
print("n\b\b\bn")
