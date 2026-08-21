class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)   # Convert list to set for O(1) lookup
        wordQueue = deque()
        wordQueue.append([beginWord, 1])
        visitedWords = set()
    
        while wordQueue:
            [word, level] = wordQueue.popleft()
            if word == endWord:
                return level
            for i in range(len(word)):
                for j in range(ord('a'), ord('z')+1):
                    updateWord = word[: i] + chr(j) + word[i+1:]
                    if (updateWord not in visitedWords and updateWord in  wordSet):
                        wordQueue.append([updateWord, level+1])
                        visitedWords.add(updateWord)
        return 0
                    