import heapq
def solve(l, k, arr):
    max_sum = float('-inf')
    for i in range(l):
        in_heap = []
        curr_sum = 0
        heapq.heapify(in_heap)
        out_heap = [(-arr[idx], idx) for idx in range(l)]
        heapq.heapify(out_heap)
        for j in range(i, l):
            gain = 0
            saved_in, saved_out = [], []
            heapq.heappush(in_heap, arr[j])
            curr_sum += arr[j]
            for _ in range(k):
                while out_heap and i <= out_heap[0][1] <= j:
                    heapq.heappop(out_heap)
                if not in_heap or not out_heap:
                    break
                worst_in = heapq.heappop(in_heap)
                neg_best_out, idx = heapq.heappop(out_heap)
                saved_in.append(worst_in)
                saved_out.append((neg_best_out, idx))
                best_out = -neg_best_out
                if best_out > worst_in:
                    gain += best_out - worst_in
                else:
                    break
            for t in saved_in:
                heapq.heappush(in_heap, t)
            for t in saved_out:
                heapq.heappush(out_heap, t)
            max_sum = max(curr_sum + gain, max_sum)
    return max_sum

    # max_sum = float('-inf')
    # for i in range(l):
    #     for j in range(i, l):
    #         inside = arr[i : j + 1]
    #         outside = arr[:i] + arr[j + 1 :]
    #         inside.sort()
    #         curr_sum = sum(inside)
    #         outside.sort(reverse=True)
    #         swaps = min(k, len(inside), len(outside))
    #         for s in range(swaps):
    #             if outside[s] > inside[s]:
    #                 curr_sum += outside[s] - inside[s]
    #             else:
    #                 break
    #         max_sum = max(curr_sum, max_sum)
    # return max_sum

# --- TEST CASES ---

# Test 1: Multiple positive islands
print("Test 1 | Output:", solve(6, 2, [10, -10, -10, 10, -10, 10]), "| Expected: 30")
# Test 2: All negative numbers
print("Test 2 | Output:", solve(4, 2, [-8, -3, -10, -5]), "| Expected: -3")
# Test 3: k equals length
print("Test 3 | Output:", solve(4, 4, [-2, 5, -1, 6]), "| Expected: 11")
# Test 4: Zero swaps allowed (k = 0)
print("Test 4 | Output:", solve(5, 0, [-2, 4, -1, 3, -5]), "| Expected: 6")
# Test 5: All positive numbers
print("Test 5 | Output:", solve(3, 2, [4, 5, 6]), "| Expected: 15")
# Test 6: Minimum array size (length = 2)
print("Test 6 | Output:", solve(2, 1, [-100, 50]), "| Expected: 50")
# Test 7: Isolated max trap
print("Test 7 | Output:", solve(7, 1, [4, 4, -20, 4, 4, -50, 10]), "| Expected: 26")
