n = int(input())
arr = list(map(int, input().split()))

answer = 0

for i in range(n):
    if arr[i] == 0:
        continue
    temp = arr[i]
    for j in range(arr[i]):
        if i + j >= n:
            break
        if temp == arr[i + j]:
            arr[i + j] = 0
        temp -= 1
    answer += 1

print(answer)

#include <bits/stdc++.h>
using namespace std;
int n;
int st[1000001];
int main(){
	scanf("%d", &n);
	int cnt=0;
	for(int i=0;i<n;i++){
		int in;
		scanf("%d", &in);
		if(st[in+1]==0){
			st[in]++;
			cnt++;
			continue;
		}
		st[in+1]--;
		st[in]++;
	}
	printf("%d\n", cnt);
	return 0;
}
