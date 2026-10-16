# input:

# Enter the No. of Nodes: 5
# Enter the 1 Edge: 0 1 10
# Enter the 2 Edge: 0 2 5
# Enter the 3 Edge: 1 2 2
# Enter the 4 Edge: 1 3 1
# Enter the 5 Edge: 2 3 3
# Edges = [
        #     (0, 1, 10),
        #     (0, 2, 5),
        #     (1, 2, 2),
        #     (1, 3, 1),
        #     (2, 3, 3)
# ]
# Graph = {
        #     0: [(1, 10), (2, 5)],
        #     1: [(0, 10), (2, 2), (3, 1)],
        #     2: [(0, 5), (1, 2), (3, 3)],
        #     3: [(1, 1)],
# }
# Enter the Source Node: 0

import heapq
n = int(input("Enter the No. of Nodes: "))
m = int(input("Enter the No. of Edges: "))
edges = []
for i in range(m):
    u, v, w = map(int, input(f"Enter the {i + 1} Edge: ").split())
    edges.append((u, v, w))
src = int(input("Enter the Source Node: "))
graph = {}
for i in range(n):
    graph[i] = []
for u, v, w in edges:
    graph[u].append((v, w))
    graph[v].append((u, w))
dist = [float('inf')] * n
parent = [None] * n
dist[src] = 0
parent[src] = -1
pq = [(0, src)]
while pq:
    pdist, node = heapq.heappop(pq)
    if pdist > dist[node]:
        continue
    for neigh, ndist in graph[node]:
        new_dist = pdist + ndist
        if new_dist < dist[neigh]:
            dist[neigh] = new_dist
            parent[neigh] = node
            heapq.heappush(pq, (new_dist, neigh))
print(dist)
print(parent)

# output:

# Distances from Node 0: [0, 7, 5, 8, inf]
# Parent Nodes: [-1, 2, 0, 1, None]
