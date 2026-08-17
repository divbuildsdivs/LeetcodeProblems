class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        self.visited = set()
        provinces = 0

        for i in range (len(isConnected)):
            if(i not in self.visited):
                provinces += 1
                self.dfs(i, isConnected)
        return provinces

    def dfs(self, i, isConnected):
        self.visited.add(i)
        for j in range (len(isConnected[i])):
            if(isConnected[i][j] and j not in self.visited):
                self.dfs(j, isConnected)