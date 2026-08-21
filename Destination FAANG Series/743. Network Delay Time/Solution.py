class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # Create an adjacency list for every node from 1 through n.
        graphToMap = {i: [] for i in range(1, n+1)}

        # Stores the shortest finalized delay from k to each visited node.
        visited = {}

        # Add each directed edge and its travel time to the adjacency list.
        for startNode, endNode, timeTaken in times:
            if startNode not in graphToMap:
                graphToMap[startNode] = []
            graphToMap[startNode].append([endNode, timeTaken])
          
        
        # Heap entries contain (accumulated delay, node).
        minHeap = []

        # Start from node k with an initial delay of zero.
        heapq.heappush(minHeap, (0, k))

        # Tracks the greatest shortest delay finalized so far.
        totalTime = 0

    #arrange an heap to indicate time taken from k node to different nodes
    #use heap to prioritise shortest time taken from k  node to different nodes
        while len(minHeap) > 0 :
            # Process the currently reachable node with the smallest delay.
            delay, node = heapq.heappop(minHeap)

            # A node may appear in the heap more than once. Once visited, its
            # shortest delay is already finalized, so do not process it again.
            if node in visited:
                continue

            visited[node] = delay

            # Nodes are finalized in increasing delay order.
            totalTime = delay

            # Add every outgoing neighbor with its accumulated path delay.
            for end, time in graphToMap[node]:
                heapq.heappush(minHeap, (totalTime + time, end))

        # Return the time needed to reach all nodes, or -1 if one is unreachable.
        return totalTime if(len(visited) == n) else -1
            

        


