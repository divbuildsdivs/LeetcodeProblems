class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        for i in range(1, numRows):
            temp = [0] + res[-1] + [0] #[0, ..nums from last row, 0]
            rowLength = i + 1
            newRow = [0] * rowLength
            for j in range(rowLength):
                newRow[j] = temp[j] + temp[j+1]
            res.append(newRow)
        return res
        