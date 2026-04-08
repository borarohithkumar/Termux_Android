def max_t_pts(N, M, t, d):
    def count_t_pts(mid):
        c = 0
        for i in range(N):
            if t[i] >= mid:
                c += (t[i] - mid) // d[i] + 1
        return c
    l = 0
    h = max(t)
    best_m = 0
    while l <= h:
        mid = (l + h) // 2
        m = count_t_pts(mid)
        if m >= M:
            best_m = mid
            l = mid + 1
        else:
            h = mid - 1
    taken_m = 0
    t_pts = 0
    for i in range(N):
        m = 0
        if t[i] >= best_m:
            m = (t[i] - (best_m + 1)) // d[i] + 1
            if m > 0:
                f = t[i]
                l = t[i] - ((m - 1) * d[i])
                t_pts += m * (f + l) // 2
                taken_m += m
    rem_m = M - taken_m
    if rem_m > 0:
        t_pts += rem_m * best_m
    return t_pts
data = list(map(int, input().split()))
N, M = data[0], data[1]
t = data[2:N + 2]
d = data[2 + N:2 + 2 * N]
print(max_t_pts(N, M, t, d))
