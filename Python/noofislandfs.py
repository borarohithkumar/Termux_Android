graph = [
        [1, 1, 0, 0, 0],
        [1, 1, 0, 0, 0],
        [0, 0, 1, 0, 0],
        [0, 0, 0, 1, 1]
        ]
rowlen = len(graph)
collen = len(graph[0])
def dfs(r, c):
    if r < 0 or r >= rowlen or c < 0 or c >= collen or graph[r][c] == 0:
        return
    graph[r][c] = 0
    dfs(r+1, c)
    dfs(r, c+1)
    dfs(r-1, c)
    dfs(r, c-1)
c = 0
for row in range(rowlen):
    for col in range(collen):
        if graph[row][col] == 1:
            c += 1
            dfs(row, col)
print(c)
