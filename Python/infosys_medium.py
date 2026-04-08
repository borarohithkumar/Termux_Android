def mss(l, n):
    msas = float('-inf')
    for i in range(len(l)):
        for j in range(i, len(l)):
            inside = l[i:j+1]
            outside = l[:i] + l[j+1:]
            inside.sort()
            outside.sort(reverse=True)
            curr_sum = sum(inside)
            m = min(n, len(inside), len(outside))
            for i in range(m):
                if inside[i] < outside[i]:
                    curr_sum += outside[i] - inside[i]
                msas = max(msas, curr_sum)
    return msas
l = list(map(int, input().split()))
n = int(input())
print(mss(l, n))
