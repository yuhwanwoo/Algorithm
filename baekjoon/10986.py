# https://zoosso.tistory.com/550

n, m = map(int, input().split())

arr = [0] + list(map(int, input().split()))

psum = [0] * (n + 1)
cnt = [0] * (m)

for i in range(1, n + 1):
    # print(i)
    psum[i] = (psum[i - 1] + arr[i]) % m
    cnt[psum[i]] += 1
    # print(psum)
    # print(cnt)

ans = cnt[0]
for i in range(m):
    ans += (cnt[i] * (cnt[i] - 1)) // 2

print(ans)