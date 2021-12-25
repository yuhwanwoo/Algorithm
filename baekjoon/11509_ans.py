# https://chance0523.github.io/algorithm/boj/greedy/silver1/algorithm-ballon/

import sys
input = sys.stdin.readline

N = int(input())
nList = list(map(int, input().split()))
# 이 높이에서 날아오는 화살이 있나 check
arrow = [0 for height in range(10)]
ans = 0

for n in nList:
    # n+1 높이에서 날아오는 화살이 없는 경우
    if arrow[n+1] == 0:
        # n 높이에서 날아오는 화살 추가
        arrow[n] += 1
        ans += 1
    # n+1 높이에서 날아오는 화살이 있는 경우
    else:
        # n 높이로 교체
        arrow[n+1] -= 1
        arrow[n] += 1
    print(arrow)

print(ans)