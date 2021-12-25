import heapq

n=int(input())

for i in range(n):
    m=int(input())
    files=list(map(int,input().split()))
    
    leng=len(files)
    answer=0

    heapq.heapify(files)

    temp_cnt=0
    temp=0
    while files:
        if len(files)==1:
            answer+=temp
            top=heapq.heappop(files)
            answer+=top
            print(answer)
            break
        temp+=heapq.heappop(files)
        temp_cnt+=1
        

        if temp_cnt==2:
            answer+=temp
            heapq.heappush(files,temp)
            temp=0
            temp_cnt=0

