# 이건 다른 사람 풀이
def solution(n, results):
    win = {x:set() for x in range(1, n+1)}
    lose = {x:set() for x in range(1, n+1)}
    print(win)
    for winner, loser in results:
        win[winner].add(loser)
        lose[loser].add(winner)
        
    for i in range(1, n+1):
        # i가 진 사람들(승자들)은 i가 이긴 사람들도 이긴다
        for winner in lose[i]:
            win[winner].update(win[i])
        # i에게 진 사람들(패자들)은 i가 진사람들에게도 진다
        for loser in win[i]:
            lose[loser].update(lose[i])
    
    answer = 0
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1
    return answer

# 이렇게 풀어서 성공
def solution2(n, results):
    answer = 0
    # 이런 것도 있더라
    win = defaultdict(set)
    lose = defaultdict(set)

   

    for result in results:
        winner,loser=result
        win[winner].add(loser)
        lose[loser].add(winner)
    
    for i in range(1,n+1):
        for winner in lose[i]:
            win[winner].update(win[i])
        for los in win[i]:
            lose[los].update(lose[i])
    print(win)
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1
    

    return answer

# 이렇게 풀었는데 시간 초과 뜸
def solution3(n, results):
    answer = 0
    win=dict()
    lose=dict()

    # 이런 것도 있더라
    # from collections import defaultdict
    # wins = defaultdict(set)
    # loses = defaultdict(set)

    for i in range(1,n+1):
        win[i]=[]
        lose[i]=[]
    

    for result in results:
        winner,loser=result
        win[winner]=win.get(winner,[])+[loser]
        lose[loser]=lose.get(loser,[])+[winner]
    
    for i in range(1,n+1):
        for winner in lose[i]:
            win[winner]+=win[i]
        for los in win[i]:
            lose[los]+=lose[i]

    for i in range(1,n+1):
        win[i]=set(win[i])
        lose[i]=set(lose[i])
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1
    
    return answer

n=5
results=[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
solution(n,results)