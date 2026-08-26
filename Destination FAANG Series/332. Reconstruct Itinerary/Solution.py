class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        adj = { src: [] for src, dst in tickets}
        for src, dst in tickets:
           adj[src].append(dst)
        for src in adj:
            adj[src].sort(reverse=True)

        res = []
        
        def dfs(code): # Hierholzer's algorithm
            while code in adj and adj[code]:
                dst = adj[code].pop()
                dfs(dst)
            res.append(code)
        dfs("JFK")   
        res.reverse()
        return res