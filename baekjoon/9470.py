from collections import deque

t=int(input())
for _ in range(t):
    k,m,p=map(int,input().split())
    sted=[[] for _ in range(m+1)]
    edst=[[] for _ in range(m+1)]
    q=deque()
    for i in range(p):
        s,e=map(int,input().split())
        sted[s].append(e)
        edst[e].append(s)
    print(sted)
    #print(edst)
    for i in range(1,m+1):
        if not edst[i]:
            q.append((i,1))
    print(q)
    while q:
        n,seq=q.popleft()
        for i in sted[n]:
            print(i)

