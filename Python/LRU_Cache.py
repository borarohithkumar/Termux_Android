class DLL:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None
class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.head = DLL(0, 0)
        self.tail = DLL(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
    def put(self, key, val):
        if key in self.cache:
            node = self.cache[key]
            self.rem(node)
            node.val = val
            self.add(node)
            return
        if len(self.cache) == self.capacity:
            oldest = self.tail.prev
            self.rem(oldest)
            del self.cache[oldest.key]
        node = DLL(key, val)
        self.cache[key] = node
        self.add(node)
    def get(self, key):
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.rem(node)
        self.add(node)
        return node.val
    def add(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    def rem(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
cache = LRUCache(2)

cache.put(1, 100)
cache.put(2, 200)

print(cache.get(1))

cache.put(3, 300)

print(cache.get(2))
print(cache.get(3))
