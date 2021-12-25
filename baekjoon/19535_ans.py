N = int(sys.stdin.readline())
linkArr = [0] * N
edges = []
# 링크 수를 arr에 담고, edges를 채운다.
for _ in range(N - 1):
    a, b = map(int, sys.stdin.readline().split(" "))
    linkArr[a - 1] += 1
    linkArr[b - 1] += 1
    edges.append([a, b])
resD, resJ = 0, 0
# 조합을 이용하여 ㅈ트리를 구한다.
for i in range(N):
    resJ += linkArr[i] * (linkArr[i] - 1) * (linkArr[i] - 2) / 6 if linkArr[i] >= 3 else 0
# 두 노드의 link 수를 이용하여 ㄷ트리를 구한다.
for a, b in edges:
    resD += (linkArr[a - 1] - 1) * (linkArr[b - 1] - 1)
if resD > resJ * 3:
    print("D")
elif resD < resJ * 3:
    print("G")
else:
    print("DUDUDUNGA")