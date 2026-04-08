def qs(l, r, arr):
    if l >= r:
        return arr
    pivot = arr[(l+r)//2]
    i, j = l, r
    while i <= j:
        while arr[i] < pivot:
            i += 1
        while arr[j] > pivot:
            j -= 1
        if i <= j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
    qs(l, j, arr)
    qs(i, r, arr)
    return arr
n = int(input("Enter no. of Elements: "))
l = []
for i in range(n):
    l.append(int(input(f"Enter Element {i+1}: ")))
print(qs(0, len(l)-1, l))

