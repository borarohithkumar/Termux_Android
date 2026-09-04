arr1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
print(arr1)
n = len(arr1)
for i in range(0, n):
    arr1[0][i], arr1[n - 1][i] = arr1[n - 1][i], arr1[0][i]
print(arr1)
for i in range(0, n):
    for j in range(i + 1, n):
        arr1[i][j], arr1[j][i] = arr1[j][i], arr1[i][j]
print(arr1)
