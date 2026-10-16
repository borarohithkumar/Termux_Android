class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.data = arr
        self.seg_tree = [0] * 4 * self.n
        self.build(0, 0, self.n - 1)
    def build(self, i, l, h):
        if l == h:
            self.seg_tree[i] = self.data[l]
            return
        m = (l + h) // 2
        self.build(2 * i + 1, l, m)
        self.build(2 * i + 2, m + 1, h)
        self.seg_tree[i] = self.seg_tree[2 * i + 1] + self.seg_tree[2 * i + 2]
    def update(self, i, l, h, idx, val):
        if l == h:
            self.data[idx] = val
            self.seg_tree[i] = val
            return 
        m = (l + h) // 2
        if idx <= m:
            self.update(2 * i + 1, l, m, idx, val)
        else:
            self.update(2 * i + 2, m + 1, h, idx, val)
        self.seg_tree[i] = self.seg_tree[2 * i + 1] + self.seg_tree[2 * i + 2]

    def query(self, i, l, h, ql, qh):
        if qh < l or ql > h:
            return 0
        if ql <= l and qh >= h:
            return self.seg_tree[i]
        m = (l + h) // 2
        left = self.query(2 * i + 1, l, m, ql, qh)
        right = self.query(2 * i + 2, m + 1, h, ql, qh)
        return left + right


arr = [5, 3, 2, 8]

# 1. Build your tree here...
my_tree = SegmentTree(arr)

# 2. First Query
print(my_tree.query(0, 0, 3, 1, 2))

# 3. Update
my_tree.update(0, 0, 3, 2, 10)

# 4. Second Query
print(my_tree.query(0, 0, 3, 1, 2))

# 5
# 13
