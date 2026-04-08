def lnp(l):
    min_c = float('inf')
    for i in range(len(l) - 1):
        for j in range(i + 1, len(l) - 1):
            if l[i] != l[j]:
                cost = abs(l[i] - l[j])
                if not cost & 1:
                    min_c = min(cost, min_c)
    return min_c
l = list(map(int, input().split()))
print(lnp(l))
