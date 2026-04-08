def bubbles(arr, n):
    if n < 2:
        return arr
    for i in range(n):
        swap = False
        for j in range(n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swap = True
        if not swap:
            return arr
    return arr
n = int(input(f"Enter No.of Elements: "))
l = []
for i in range(n):
    l.append(int(input(f"Enter Element {i+1}: ")))
print(bubbles(l, n))
