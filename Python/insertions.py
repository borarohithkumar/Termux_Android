def insertions(l):
    ln = len(l)
    for i in range(1, ln):
        k = l[i]
        j = i - 1
        while j >= 0 and l[j] > k:
            l[j+1] = l[j]
            j -= 1
        l[j+1] = k
    return l
n = int(input(f"Enter No.of Elements: "))
l = []
for i in range(n):
    l.append(int(input(f"Enter Element {i+1}: ")))
print(insertions(l))
