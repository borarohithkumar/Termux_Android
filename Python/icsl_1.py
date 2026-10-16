# import heapq
People = 10 ** 9
Desks = 2
Time = [7, 10]
# pq = [(t, t) for t in Time]
# heapq.heapify(pq)
# for i in range(People - 1):
#     finish_time, process_time = heapq.heappop(pq)
#     heapq.heappush(pq, (finish_time + process_time, process_time))
# print(pq[0][0])
l, h = min(Time), min(Time) * People
total = l
while l <= h:
    m = (l + h) // 2
    process_time = 0
    for t in Time:
        process_time += m // t
    if process_time >= People:
        total = m
        h = m - 1
    else:
        l = m + 1
print(total)
