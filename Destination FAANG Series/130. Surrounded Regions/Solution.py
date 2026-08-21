class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        num_rows = len(board)
        num_cols = len(board[0])

        def dfs(r, c):
            dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            if(r < 0 or r >= num_rows or c < 0 or c >= num_cols or board[r][c] != "O"):
                return
            board[r][c] = "T"
            for [x, y] in dir:
                dfs(r + x, c + y)

        for i in range(num_rows):
            for j in range(num_cols):
                if((i == 0 or i == num_rows - 1 or j == 0 or j == num_cols - 1) ):
                    dfs(i, j)

        for u in range(num_rows):
            for v in range(num_cols):
                if(board[u][v] == "O"):
                    board[u][v] = "X"
                if(board[u][v] == "T"):
                    board[u][v] = "O"
                    
                    
        
        

            


        