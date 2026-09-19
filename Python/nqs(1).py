def isSafe(row, col, board):
    for r in range(row):
        if board[r] == col:
            return False
        if abs(board[r] - col) == abs(r - row):
            return False
    return True
def findNPos(row, N, board, sols):
    if row == N:
        sols.append(board[:])
        return
    for col in range(N):
        if not isSafe(row, col, board):
            continue
        board[row] = col
        findNPos(row + 1, N, board, sols)
        board[row] = -1
def main():
    N = 7
    board = [-1] * N
    sols = []
    findNPos(0, N, board, sols)
    for sol in sols:
        print(sol)
        print()
main()
