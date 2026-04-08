n1 = int(input())
n2 = int(input())
c = 0
for i in range(n1, n2 + 1):
    m = (1 << 10)
    n = i
    while n > 0:
        d = n % 10
        if (m >> d) & 1:
            m &= ~(1 << 10)
            break
        m |= (1 << d)
        n //= 10
    if m >> 10:
        c += 1
print(c)
