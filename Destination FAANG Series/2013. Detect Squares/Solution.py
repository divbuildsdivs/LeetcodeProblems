class DetectSquares:

    def __init__(self):
        self.pointsCount = defaultdict(int)
        self.points = []
        

    def add(self, point: list[int]) -> None:
        self.pointsCount[tuple(point)] += 1
        self.points.append(point)

    def count(self, point: list[int]) -> int:
        px, py = point
        res = 0
        for x, y in self.points:
            if abs(px - x) != abs(py - y) or px == x or py == y:
                continue
            res += self.pointsCount[(px, y)] * self.pointsCount[(x, py)]
        return res



# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# obj.add(point)
# param_2 = obj.count(point)