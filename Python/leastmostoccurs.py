l = list(map(int, input().split(" ")))
d = {}
for i in l:
    d[i] = d.get(i, 0) + 1
m = float('inf')
M = float('-inf')
mi = 0
Mi = 0
for i in d:
    if d[i] > m:
        m, mi = d[i], i
    if d[i] < M:
        M, Mi = d[i], i
print(Mi, mi)
