n=int(input())


data_map=[["*"]*n for _ in range(n)]


def sol(data_map,n):
    if n==1:
        return None
    for i in range(n//3,(n//3)*2):
        for j in range(n//3,(n//3)*2):
            data_map[i][j]=" "
            sol(data_map,n//3)
    return 0


sol(data_map,n)

for i in range(n):
    for j in range(n):
        print(data_map[i][j],end="")
    print()