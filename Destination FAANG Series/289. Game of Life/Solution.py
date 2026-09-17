class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        def countOnes(r,c):
            count = 0
            directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
            for dir in directions:
                neir = r + dir[0]
                neic = c + dir[1]
                if (0 <= neir < rows) and (0 <= neic < cols) and  (board[neir][neic] in (1, -1) ):
                    count += 1
            return count
            
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 1 and (countOnes(r,c) < 2 or countOnes(r,c) > 3):
                    board[r][c] = -1
                if board[r][c] == 0 and countOnes(r,c) == 3:
                    board[r][c] = 2
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == -1:
                    board[r][c] = 0
                if board[r][c] == 2:
                    board[r][c] = 1
        