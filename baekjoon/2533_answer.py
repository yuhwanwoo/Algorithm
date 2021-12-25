# https://developmentdiary.tistory.com/453

import sys
sys.setrecursionlimit(10**9)
 
N=int(sys.stdin.readline())
Tree=[[] for _ in range(N+1)]
# check=[0 for _ in range(N+1)]
# print(check)
for _ in range(N-1):
    u,v=map(int,sys.stdin.readline().split())
    Tree[u].append(v)
    Tree[v].append(u)
print(Tree)
DP=[[0,0] for _ in range(N+1)]
print(DP)
check=[True for _ in range(N+1)]
def DFS(cur):
    check[cur]=False#방문체크
    # print(check)
    DP[cur][0]=1#현재 노드 포함할때
    DP[cur][1]=0#현재 노드 포함하지 않을때
    # print(DP)
    # print(check)
    for i in Tree[cur]:#연결된 노드 탐색
        if check[i]:#자식노드라면 
            DFS(i)
            DP[cur][0]+=DP[i][1]#현재노드 포함했을때
            DP[cur][1]+=max(DP[i][0],DP[i][1])#현재노드를 포함 안했을때
            # print("for안",DP)
 
DFS(1)
print(DP)
print(N-max(DP[1][0],DP[1][1]))