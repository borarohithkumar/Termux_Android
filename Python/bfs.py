# input: 

# Enter the No. of nodes: 5
# Enter the Neighbors of 0: 1 2
# Enter the Neighbors of 1: 0 3
# Enter the Neighbors of 2: 0 4
# Enter the Neighbors of 3: 1
# Enter the Neighbors of 4: 2
# graph = {
        #     0: [1, 2],
        #     1: [0, 3],
        #     2: [0, 4],
        #     3: [1],
        #     4: [2]
# }
# Enter the Source Node: 0

from collections import deque
n = int(input("Enter the No. of nodes: "))
graph = {}
for i in range(n):
    neighbors = input(f"Enter the Neighbors of {i}: ").split()
    graph[i] = list(map(int, neighbors)) if neighbors else []
start = int(input("Enter the Source node: "))
visit = set([start])
q = deque([start])
level = {}
level[start] = 0
print("BFS Traversal: ", end="")
while q:
    node = q.popleft()
    print(node, end=" ")
    for neigh in graph[node]:
        if neigh not in visit:
            q.append(neigh)
            level[neigh] = level[node] + 1
            visit.add(neigh)
print("\nLevels: ")
print(level)

# output:

# BFS Traversal: 0 1 2 3 4
# Levels:
# {0: 0, 1: 1, 2: 1, 3: 2, 4: 2}
