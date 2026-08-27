# Logic:
# Use Dijkstra's algorithm with a min-heap. Each heap entry stores the minimum
# water level needed to reach a cell, which is the maximum elevation seen along
# that path. Always process the cell with the smallest required water level.
# For each neighbor, the new cost is max(current cost, neighbor elevation).
# The first time the bottom-right cell is popped, its cost is optimal.
# Time: O(N^2 log N), Space: O(N^2).
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        N = len(grid)
        visited = set()
        minHeap =[[grid[0][0], 0, 0]]
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        while minHeap:
            maxheight, x, y = heapq.heappop(minHeap)
            if x == N -1 and y == N -1:
                return maxheight
            for dirx, diry in directions:
                neix, neiy = x + dirx, y + diry
                if(neix < 0 or  neiy < 0 or neix >= N or neiy >= N or (neix,neiy) in visited ):
                    continue
                visited.add((neix, neiy))
                heapq.heappush(minHeap, [max(maxheight, grid[neix][neiy]), neix, neiy])

