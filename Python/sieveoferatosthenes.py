n = int(input("Enter a Positive Integer to get all the Primes till n: "))
prime = [True] * (n + 1)
prime[0] = prime[1] = False
i = 2
while i * i <= n:
    if prime[i]:
        j = i * i
        while j <= n:
            prime[j] = False
            j += i
    i += 1
for p in range(len(prime)):
    if prime[p]:
        print(p)
