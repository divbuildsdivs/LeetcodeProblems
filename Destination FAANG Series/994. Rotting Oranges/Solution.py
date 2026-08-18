class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        fresh = 0
        queue = deque()
        for i in range(row):
            for j in range(col):
                if(grid[i][j] == 1):
                    fresh += 1
                elif(grid[i][j] == 2):
                    queue.append([i,j])
    
        def bfs(queue, fresh) -> int:
            time = 0
            dir = [[0,1], [0, -1], [1,0], [-1, 0]]
            while(queue and fresh > 0):
                for i in range(len(queue)):
                    rotten = queue.popleft()
                    for [x, y] in dir:
                        r= rotten[0] + x
                        c = rotten[1] + y
                        if(r >= 0 and r < row and c >= 0 and c < col and grid[r][c] == 1):
                            grid[r][c] = 2
                            fresh -= 1
                            queue.append([r, c])
                time += 1
            return time if fresh == 0 else -1        
        
        return bfs(queue, fresh)




