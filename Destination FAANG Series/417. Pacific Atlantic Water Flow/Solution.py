class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:


        if len(heights) == 0:
            return [[]]

        numRows = len(heights)
        numCols = len(heights[0])
        res = []
        pacificReachable =[[False] * numCols for i  in range(numRows)]
        atlanticReachable = [[False] * numCols for i  in range(numRows)]

        

        def dfs(i, j, reachable):
            reachable[i][j] = True
            directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            for dir in directions:
                x = i + dir[0]
                y = j + dir[1]
                
                if(x < 0 or x >= numRows or y < 0 or y >= numCols or reachable[x][y] == True or (heights[i][j] > heights[x][y])):
                    continue
                else:
                    dfs(x, y, reachable)
        
        for i in range (numRows):
            for j in range (numCols):
                if(i == 0 or j == 0):
                    dfs(i, j, pacificReachable)
                if(i == numRows - 1 or j == numCols - 1):
                    dfs(i, j, atlanticReachable)
        

        for i in range (numRows):
            for j in range (numCols):
                if(pacificReachable[i][j] and  atlanticReachable[i][j]):
                    res.append([i, j])
        
        return res