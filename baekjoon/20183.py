# 부분성공
import heapq
import sys

input=sys.stdin.readline
sys.setrecursionlimit(10**9)

n,m,a,b,c=map(int,input().split())

graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)

ans=int(1e9)

for i in range(m):
    s,e,d=map(int,input().split())
    heapq.heappush(graph[s],(d,e))
    heapq.heappush(graph[e],(d,s))

q=[]

def dfs(st,dis,bigger):
    global ans
    if st==b:
        # ans=min(ans,bigger)
        heapq.heappush(q,bigger)
        return
    leng=len(graph[st])
    for _ in range(leng):
        dist,ed=heapq.heappop(graph[st])
        # print(st,ed,dist)
        if not visited[ed]:         
            visited[ed]=True
            if dis+dist<=c:            
                dfs(ed,dis+dist,max(bigger,dist))
            visited[ed]=False

visited[a]=True
dfs(a,0,0)

if q:
    ans=heapq.heappop(q)
    print(ans)
else:
    print(-1)

# if ans==int(1e9):
#     print(-1)
# else:
#     print(ans)