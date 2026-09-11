class Solution:
    def racecar(self, target: int) -> int:
        queue = deque()
        visited = set()
        queue.append([0,1,0])  #position, speed, moves
        visited.add((0, 1))
        while queue:
            pos, speed, moves = queue.popleft()
            
            if pos == target:
                return moves
            
            #A
            new_position = pos + speed
            new_speed = 2 * speed

            if -target <= new_position <= 2*target:                 #limits Acceleration beyond -target to 2xtarget

                if (new_position, new_speed) not in  visited:
                    visited.add((new_position, new_speed))
                    queue.append([new_position, new_speed, moves + 1])

            #R
            new_speed  =  -1 if speed > 0 else 1
            if (pos, new_speed) not in  visited:
                visited.add((pos, new_speed))
                queue.append([pos, new_speed, moves + 1])
            


            