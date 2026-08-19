class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseMap = {i: [] for i in range(numCourses)}
        for i in range(len(prerequisites)):
            courseMap[prerequisites[i][0]].append(prerequisites[i][1])
        
        visited = set()
        def dfs(course):
            if course in visited:
                return False
            if courseMap[course] == []:
                return True
            visited.add(course)
            for prereq in courseMap[course]:
                if dfs(prereq) == False:
                    return False
            courseMap[course] = []
            visited.remove(course)
            return True

        for i in range(numCourses):
            if dfs(i) == False:
                return False
        return True