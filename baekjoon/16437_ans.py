import sys

sys.setrecursionlimit(10**8)

input = sys.stdin.readline
INF = int(1e9)

n = int(input())
graph = [0] * (n + 1)

for i in range(2, n + 1):
    a, b, c = input().split()
    graph[i] = [a, int(b), int(c)]

def search(start, count):
    a_type, cnt, node = graph[start]
    # if a_type == "S":
    #     count += cnt
    
    if a_type == 'W':
        count -= cnt
        # graph[start][1] = 0
        if count < 0:
            graph[start][1] = -count
            count = 0

    if node == 1:
        # print("cnt", count)
        return count
    else:
        if count > 0:
            count = search(node, count)
    return count

ans = 0
for i in range(n, 1, -1):
    tmp = search(i, graph[i][1])
    # print(tmp)
    ans += tmp

print(ans)