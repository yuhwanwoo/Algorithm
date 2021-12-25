from collections import deque

def dfs(n,data,temp,addr,dirname):
    if len(data[n])==0:    
        #print(addr)
        temp.append(addr)
        return temp
    for i in data[n]:
        dfs(i,data,temp,addr+"/"+dirname[i-1],dirname)
    return temp

def solution(N, relation, dirname):
    answer = 0
    
    temp=[]

    data=[[] for _ in range(N+1)]
    for rel in range(len(relation)):
        start,end=relation[rel]
        data[start].append(end)
    addr="root"
    #print(data)
    temp=dfs(1,data,temp,addr,dirname)

    print(temp)
    for i in temp:
        answer=max(answer,len(i))

    print(answer)
    return answer

N=7
relation=[[1,2],[2,5],[2,6],[1,3],[1,4],[3,7]]
dirname=["root","abcd","cs","hello","etc","hello","solution"]
solution(N,relation,dirname)
