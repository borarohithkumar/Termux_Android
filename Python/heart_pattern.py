# \033[91m sets the terminal text color to red, \033[0m resets it back to default
RED = "\033[91m"
RESET = "\033[0m"

for row in range(6):
    for col in range(7):
        # Your original logic that creates the heart shape grid
        if (row == 0 and col % 3 != 0) or (row == 1 and col % 3 == 0) or (row - col == 2) or (row + col == 8):
            print(f"{RED}♥{RESET}", end=" ")
        else:
            print(" ", end=" ")
    print()
