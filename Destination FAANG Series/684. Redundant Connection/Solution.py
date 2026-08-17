class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        parent = [ i for i in range(len(edges) + 1)]
        rank = [1] * (len(edges) + 1)

        def find(n):
            p = parent[n]
            while(p != parent[p]):
                p = parent[p]
            return p
        
        def union(edge):
            a, b = edge
            par_a = find(a)
            par_b = find(b)

            if(par_a == par_b):
                return False
            if(rank[par_a] > rank[par_b]):
                rank[par_a] += rank[par_b]
                parent[par_b] = par_a
            else:
                rank[par_b] += rank[par_a]
                parent[par_a] = par_b
            return True

        for i in range(len(edges)):
            if(not union(edges[i])):
                return edges[i]