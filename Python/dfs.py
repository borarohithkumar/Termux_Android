graph = {
    0: [1, 2],
    1: [0, 3, 4],
    2: [0],
    3: [1],
    4: [1, 5, 6],
    5: [4],
    6: [4]
}
src = int(input("Enter the Source Node: "))
visit = set()
node = src
def dfs(node):
    if node in visit:
        return 
    print(node, end=" ")
    visit.add(node)
    for neigh in graph[node]:
        dfs(neigh)
print("DFS Traversal: ", end="")
dfs(src)

# output: DFS Traversal: 0 1 3 4 5 6 2
