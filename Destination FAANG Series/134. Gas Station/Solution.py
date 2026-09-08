class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        N = len(gas)
        if sum(gas) < sum(cost):
            return -1
        
        start = 0
        totalgas = 0
        for i in range(N):
            totalgas += gas[i] - cost[i]
            print(start, totalgas)

            if totalgas < 0:
                totalgas = 0
                start = i + 1
        return start