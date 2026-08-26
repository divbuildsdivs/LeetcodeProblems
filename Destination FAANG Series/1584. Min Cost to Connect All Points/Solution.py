class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        N = len(points)
        adj = {i: [] for i in range (N)}

        for  i in range (N):
            for j in range(i + 1, N):
                mandist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                adj[i].append([mandist, j])
                adj[j].append([mandist, i])

        #prim's algo
        minHeap = [[0, 0]] #dist, point
        visited = set()
        res = 0

        while minHeap:
            dist, point = heapq.heappop(minHeap)
            if(point in visited):
                continue
            res += dist
            visited.add(point)

            for neighbordist, neighbor in adj[point]:
                heapq.heappush(minHeap, [neighbordist, neighbor])
        
        return res
                    