class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        smap = {}
        tmap = {}

        for i in range(len(s)):
            if s[i] not in smap:
                smap[s[i]] = t[i]
            elif s[i] in smap and smap[s[i]] != t[i]:
                return False
            if t[i] not in tmap:
                tmap[t[i]] = s[i]
            elif t[i] in tmap and tmap[t[i]] != s[i]:
                return False
        return True
