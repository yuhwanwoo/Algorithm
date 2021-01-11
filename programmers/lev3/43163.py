INF=int(1e9)
ans=INF
def dfs(begin,target,words,visited,answer):
    
    if begin==target:
        global ans
        answer-=1
        ans=min(ans,answer)
        print("이건",answer)
        return answer

    for i in range(len(words)):
        if visited[i]==1:
            continue
        cnt=0
        for j in range(len(words[i])):
            if words[i][j]!=begin[j]:
                cnt+=1
            if cnt>1:
                break
        if cnt==1:
            print("출",words[i],answer)
            visited[i]=1
            dfs(words[i],target,words,visited,answer+1)

    return INF
    


def solution(begin, target, words):
    answer = 0
    global ans
    n=0
    min_num=INF
    visited=[0 for _ in range(len(words))]
    
    dfs(begin,target,words,visited,0)
    if ans==INF:
        return 0
    return answer

begin="hit"
target="cog"
words=["hot", "dot", "dog", "lot", "log", "cog"]
solution(begin,target,words)