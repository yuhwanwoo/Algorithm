n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

answer = []

idxA = 0
idxB = 0

while not (idxA == n and idxB == m):
    if idxA == n:
        answer.append(b[idxB])
        idxB += 1
    elif idxB == m:
        answer.append(a[idxA])
        idxA += 1
    else:
        if a[idxA] < b[idxB]:
            answer.append(a[idxA])
            idxA += 1
        else:
            answer.append(b[idxB])
            idxB += 1
        

print(*answer)