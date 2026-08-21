class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courseMap = {i:[] for i in range(numCourses)}
        n = len(prerequisites)
        for pre in prerequisites:
            courseMap[pre[0]].append(pre[1])
        visited = set()
        schedule = set()
        result = []

        def dfs(course):
            visited.add(course)
            for preq in courseMap[course]:
                if(preq in visited):
                    return False
                if(preq not in schedule):
                    if(dfs(preq) == False):
                        return False
            visited.remove(course)
            schedule.add(course)
            result.append(course)
            return True

        for course in courseMap:
            if (course not in result and dfs(course) == False):
                return []
        return result