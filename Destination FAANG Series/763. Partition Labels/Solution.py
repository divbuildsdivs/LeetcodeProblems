class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        N = len(s)
        lastOccurence = {}
        res = []
        for i in range(N):
            lastOccurence[s[i]] = i
        partitionStart = 0
        partitionEnd = 0
        for i in range(N):
            if lastOccurence[s[i]] > partitionEnd:
                partitionEnd = lastOccurence[s[i]]
            if i == partitionEnd:
                res.append(partitionEnd - partitionStart + 1)
                partitionStart = i + 1 
        return res

        