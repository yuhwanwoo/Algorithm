max = 1000

t = int(input()) # 1 <= t <= 50
for _ in range(t):
    n = int(input()) # 0 <= n <= 100
    homeX, homeY = map(int, input().split())
    stores = []
    for _ in range(n):
        storeX, storeY = map(int, input().split())
        stores.append((storeX, storeY))
    festivalX, festivalY = map(int, input().split())

    graph = [[max] * (n + 2) for _ in range(n + 2)]
    arr = [(homeX, homeY)]
    arr.extend(stores)
    arr.append((festivalX, festivalY))

    # 정점 간 이동 가능 표시
    for i in range(n + 2):
        for j in range(n + 2):
            if i == j:
                graph[i][j] = 0
                continue
            x1, y1 = arr[i]
            x2, y2 = arr[j]
            dist = abs(x1 - x2) + abs(y1 - y2)
            if dist <= 1000:
                graph[i][j] = 1

    for k in range(n + 2):
        for i in range(n + 2):
            for j in range(n + 2):
                if graph[i][k] + graph[k][j] < graph[i][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

    if 0 < graph[0][n +1] < max:
        print('happy')
    else:
        print('sad')