import sys

input = sys.stdin.readline

n = int(input())

balls = []
answer = dict()
ball_sum_dict = dict()

for i in range(n):
    c, s = map(int, input().split())
    balls.append((s, c, i))
    ball_sum_dict[c] = 0
    answer[i] = 0

balls.sort()
total = 0
j = 0
for i in range(n):
    while balls[j][0] < balls[i][0]:
        print("i, j", i, j)
        total += balls[j][0]
        ball_sum_dict[balls[j][1]] += balls[j][0]
        j += 1
    
    answer[balls[i][2]] = total - ball_sum_dict[balls[i][1]]

print(ball_sum_dict)
print(balls)
print(answer)