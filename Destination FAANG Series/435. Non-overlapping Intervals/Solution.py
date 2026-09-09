class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        prev =  0
        count = 0
        intervals.sort(key = lambda i: i[0])
        for i in range(1, len(intervals)):
            if(intervals[prev][1] > intervals[i][0]):
                if(intervals[prev][1] > intervals[i][1]):
                    prev = i
                count += 1
            else:
                prev = i
        return count