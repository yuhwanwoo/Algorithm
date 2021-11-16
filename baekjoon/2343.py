import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lecs = list(map(int, input().split()))

s = 0
e = 10**9
ans = 10**9

length = len(lecs)

while s <= e:
    mid = (s + e) // 2

    size = 0
    cnt = 0
    flag = False
    for i in range(length):
        lec = lecs[i]
        if lec > mid:
            flag = True
            break
        size += lec
        if size > mid:
            size -= lec
            cnt += 1
            size = lec
    if flag:
        s = mid + 1
        continue

    if size <= mid:
        cnt += 1
    else:
        cnt += 2
    
    if cnt <= m:
        # print(s, e, mid, size, cnt, "t")
        e = mid - 1
        
        ans = min(ans, mid)
    else:
        # print(s, e, mid, size, cnt, "z")
        s = mid + 1
        

print(ans)