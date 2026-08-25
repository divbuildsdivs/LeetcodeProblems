class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        num_rows = len(heights)
        num_cols = len(heights[0])
        visited = set()
        directions = [[1,0], [-1, 0], [0, 1], [0, -1]]
        minHeap = [[0, 0, 0]] #[[diff, r, c]]
        while minHeap:
            diff, r, c = heapq.heappop(minHeap)
            if((r,c) in visited):
                continue
            if((r, c) == (num_rows - 1, num_cols - 1)):
                return diff
            visited.add((r,c))
            for dirx, diry in directions:
                x, y = r + dirx, c + diry
                if(x < 0 or y < 0 or x >= num_rows or y >= num_cols or (x,y) in visited):
                    continue
                newdiff = max(diff, abs(heights[r][c] - heights[x][y])) # storing effort from source to x,y
                heapq.heappush(minHeap, [newdiff, x, y])