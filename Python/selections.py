def selections(arr, n):
	if n < 2:
		return arr
	for i in range(n):
		min_i = i
		for j in range(i+1, n):
			if arr[j] < arr[min_i]:
				min_i = j
		arr[i], arr[min_i] = arr[min_i], arr[i]
	return arr
n = int(input(f"Enter No.of Elements: "))
l = []
for i in range(n):
    l.append(int(input(f"Enter Element {i+1}: ")))
print(selections(l, n))
