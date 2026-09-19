def isSafe(row, col, board):
    if board[row][col] == 1:
        return False
    for r in range(row):
        if board[r][col] == 1:
            return False
    r = row - 1
    c = col - 1
    while r >= 0 and c >= 0:
        if board[r][c] == 1:
            return False
        r -= 1
        c -= 1
    r = row - 1
    c = col + 1
    while r >= 0 and c < len(board):
        if board[r][c] == 1:
            return False
        r -= 1
        c += 1
    return True
def findNPos(row, N, board, sols):
    if row == N:
        sols.append([r[:] for r in board])
        return
    for col in range(N):
        if not isSafe(row, col, board):
            continue
        board[row][col] = 1
        findNPos(row + 1, N, board, sols)
        board[row][col] = -1
def main():
    N = 4
    board = [[-1] * N for _ in range(N)]
    sols = []
    findNPos(0, N, board, sols)
    for sol in sols:
        for i in sol:
            print(i)
        print()
main()
