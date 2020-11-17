from collections import defaultdict

def solution(n, results):
    answer = 0
    # 이런 것도 있더라
    win = defaultdict(set)
    lose = defaultdict(set)

   

    for result in results:
        loser,winner=result
        win[winner].add(loser)
        lose[loser].add(winner)
    
    for i in range(1,n+1):
        for winner in lose[i]:
            win[winner].update(win[i])
        for los in win[i]:
            lose[los].update(lose[i])

    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1
    print(answer)

    return answer

n=6
results=[[6,6],[1,5],[3,4],[4,2],[4,6],[5,2],[5,4]]
solution(n,results)