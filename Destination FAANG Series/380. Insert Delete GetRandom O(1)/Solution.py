class RandomizedSet:

    def __init__(self):
        self.hmap = {}
        self.numsArray = []
    def insert(self, val: int) -> bool:
        if val not in self.hmap:
            self.hmap[val] = len(self.numsArray)
            self.numsArray.append(val)
            return True
        return False

    def remove(self, val: int) -> bool:
        if val in self.hmap:
            lastNum = self.numsArray[-1]
            index = self.hmap[val]
            self.numsArray[index] = lastNum
            self.numsArray.pop()
            self.hmap[lastNum] = index
            del self.hmap[val]
            return True
        return False
       

    def getRandom(self) -> int:
        return random.choice(self.numsArray)     


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()