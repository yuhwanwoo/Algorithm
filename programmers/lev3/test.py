answer = 0
def dfs(begin,target,words,visited):
    global answer
    stacks = [begin]
 
    while stacks:
        print(stacks,"스택")
        # 스택을 활용한 dfs 구현
        stack = stacks.pop()
        print("stack",stack)
        if stack == target:
            return answer
        
        for w in range(0,len(words)):
            print([i for i in range(0,len(words[w])) if words[w][i]!=stack[i]], words[w])
            # 조건 1. 한 개의 알파벳만 다른 경우
            if len([i for i in range(0,len(words[w])) if words[w][i]!=stack[i]]) == 1:
                print(words[w])
                if visited[w] != 0:
                    continue
 
                visited[w] = 1
 
                # stack에 추가
                stacks.append(words[w])
            
        
        # depth +
        answer +=1
        print("answer",answer)
def solution(begin, target, words):
    global answer
    if target not in words:
        return 0
    
    visited = [0 for i in words]
    
    dfs(begin,target,words,visited)
    print(answer)
    return answer


begin="hit"
target="cog"
words=["hot", "dog", "lot", "dot", "log", "cog","loj"]
solution(begin,target,words)


