def find_duplicate(arr):
    slow = arr[0]
    fast = arr[0]

    print("PHASE 1")

    while True:
        slow = arr[slow]
        fast = arr[arr[fast]]

        print(f"slow={slow}, fast={fast}")

        if slow == fast:
            print("Collision!")
            break

    print("\nPHASE 2")

    slow = arr[0]

    while slow != fast:
        print(f"slow={slow}, fast={fast}")

        slow = arr[slow]
        fast = arr[fast]

    print(f"Entrance = {slow}")

    return slow
arr = [1, 3, 4, 2, 2]
print(find_duplicate(arr))
