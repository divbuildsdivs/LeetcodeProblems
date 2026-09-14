class RecentCounter:

    def __init__(self):
        self.pingtimes = deque()

    def ping(self, t: int) -> int:
        self.pingtimes.append(t)
        while self.pingtimes and self.pingtimes[0] < t - 3000:
            self.pingtimes.popleft()
        return len(self.pingtimes)


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)