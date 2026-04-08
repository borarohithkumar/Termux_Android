l = list(map(int, input().split(" ")))
def sumevenoddigits(l):
    e = o = 0
    for i in l:
        n = i
        while n > 0:
            d = n % 10
            if d & 1:
                o += d
            else:
                e += d
            n //= 10
    return (e, o)
print(sumevenoddigits(l))
