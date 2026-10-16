# import heapq
Foods = 3
Meals = 10 ** 9
Taste = [10 ** 9, 8 * 10 ** 8, 6 * 10 ** 8]
Cloy = [2, 2, 2]
# pq = [(-Taste[i], i, 1) for i in range(Foods)]
# heapq.heapify(pq)
# total_taste = 0
# for _ in range(Meals):
#     taste, index, time = heapq.heappop(pq)
#     if taste > -1:
#         break
#     total_taste += -taste
#     next_taste = taste + Cloy[index] * time
#     heapq.heappush(pq, (next_taste, index, time + 1))
# print(total_taste)
def count(i, m):
    if Taste[i] >= m:
        return ((Taste[i] - m) // Cloy[i] + 1)
    return 0
l, h = 1, max(Taste)
min_threshold = 0
while l <= h:
    m = (l + h) // 2
    total_meals = 0
    for i in range(Foods):
        total_meals += count(i, m)
    if total_meals >= Meals:
        min_threshold = m
        l = m + 1
    else:
        h = m - 1
total_meals, total_points = 0, 0
for i in range(Foods):
    if Taste[i] >= min_threshold:
        meals = count(i, min_threshold)
        total_points += (meals * Taste[i]) - (Cloy[i] * (meals * (meals - 1)) // 2)
        total_meals += meals
if total_meals > Meals:
    extra_meals = total_meals - Meals
    total_points -= extra_meals * min_threshold
print(total_points)

# TestCase:

    # Input:
    # Meals = 5
    # Taste = [5, 7, 9]
    # Cloy = [2, 4, 6]

    # Output w Explanation: 
        # you can buy the 2 meals of the first type and 2 meals of the second type and 1 meal of the third type and get 27 taste points as follows:
    #         first type: 5 + (5 - 2) * 1 = 8
    #         second type: 7 + (7 - 4) * 1 = 10
    #         third type: 9 = 9
    #         answer: 8 + 10 + 9 = 27

# Ultimate 10⁹ TestCase:

    # Input
    # Meals (M): 1,000,000,000 (1 Billion)
    # Taste (v): [1000000000, 800000000, 600000000]
    # Cloy (d): [2, 2, 2]

    # Expected Output:
    # 486666667666666666
