def merges(arr, n):
    def merge(l, m, r):
        la = arr[l:m+1]
        ra = arr[m+1:r+1]
        i, j, k = 0, 0, l
        while i < len(la) and j < len(ra):
            if la[i] <= ra[j]:
                arr[k] = la[i]
                i += 1
            else:
                arr[k] = ra[j]
                j += 1
            k += 1
        while i < len(la):
            arr[k] = la[i]
            i += 1
            k += 1
        while j < len(ra):
            arr[k] = ra[j]
            j += 1
            k += 1
    def div(l, r):
        if l >= r:
            return
        m = (l + r) // 2
        div(l, m)
        div(m + 1, r)
        merge(l, m, r)
    div(0, n-1)
    return arr
n = int(input(f"Enter No.of Elements: "))
l = []
for i in range(n):
    l.append(int(input(f"Enter Element {i+1}: ")))
print(merges(l, n))
