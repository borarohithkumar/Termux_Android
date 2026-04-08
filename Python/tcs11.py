def trans(amount):
    def discount(a):
        return amount - (amount * a) / 100
    if amount < 1001:
        return discount(5)
    elif 1000 < amount < 5001:
        return discount(10)
    return discount(15)
amount = int(input("Enter ur Transaction Amount: "))
print(f"U can Pay {trans(amount)}/-")
