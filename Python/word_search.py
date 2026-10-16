def exist(board, word):



test_cases = [([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"), ([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"), ([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB")]
for board, word in test_cases:
    print(exist(board, word))
