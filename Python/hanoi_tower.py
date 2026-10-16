def hanoi(n, source, aux, target):
    if n == 0:
        return
    hanoi(n - 1, source, target, aux)
    print(f"Move disk {n} from {source} to {target}")
    hanoi(n - 1, aux, source, target)

hanoi(5, 'A', 'B', 'C')
