def gym(n):
    plans={
            1: 2000,
            3: 5000,
            6: 9000,
            9: 12000,
            12: 15000,
        }
    return plans[n] if n in plans else None
n=int(input("Enter no.of Subscription Mnths: "))
print(f"{gym(n)}")
