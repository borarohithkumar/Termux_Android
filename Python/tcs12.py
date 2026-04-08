S = list(map(int, input("Enter the Intial Arrangement of Lockers separated by space(\" \"): ").strip().split(" ")))
print(S)
X = list(map(int, input("Enter the Final required swapped-Arrangement of Lockers separated by space(\" \"): ").strip().split(" ")))
print(X)
c = 0
while not S == X:
    for i in range(len(S) - 1):
        if X.index(S[i]) > X.index(S[i + 1]):
            S[i], S[i + 1] = S[i + 1], S[i]
            c += 1
print(c)
