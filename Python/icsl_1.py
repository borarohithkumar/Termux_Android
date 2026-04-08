# import heapq

P = 6
D = 2
T = [7, 10]

# pq = [(i, i) for i in T]
# for _ in range(P - 1):
#     time_taken, interval = heapq.heappop(pq)
#     heapq.heappush(pq, (time_taken + interval, interval))
# print(heapq.heappop(pq)[0])

l = 1
h = min(T) * P
total_time = h
while l <= h:
    m = (l + h) // 2
    ps_in_time = sum(m // t for t in T)
    if ps_in_time >= P:
        total_time = m
        h = m - 1
    else:
        l = m + 1
print(total_time)
