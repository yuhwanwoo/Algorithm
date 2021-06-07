from collections import deque

t=int(input())
for _ in range(t):
    k,m,p=map(int,input().split())

    indegree=[0]*(m+1)
    graph=[[] for _ in range(m+1)]

    # 인덱스 0은 최대순서 1은 개수
    seq=[[0,0] for _ in range(m+1)]

    q=deque()
    for i in range(p):
        s,e=map(int,input().split())
        graph[s].append(e)
        indegree[e]+=1

    for i in range(1,m+1):
        if indegree[i]==0:
            q.append(i)
            seq[i][0]=1
            

    result=[]

    while q:
        now=q.popleft()
        result.append(now)

        for i in graph[now]:
            indegree[i]-=1
            if seq[i][0]<seq[now][0]:
                seq[i][0]=seq[now][0]
                seq[i][1]=1
            elif seq[i][0] == seq[now][0]:
                seq[i][1]+=1
            if indegree[i]==0:
                if seq[i][1]>1:
                    seq[i][0]+=1
                q.append(i)
    print(k,seq[m][0])