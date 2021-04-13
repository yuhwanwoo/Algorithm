color=[[0]*5 for _ in range(5)]

for i in range(5):
    for j in range(5):
        color[i][j]=(i % 2 == 0 and j % 2 == 0) or (i % 2 != 0 and j % 2 != 0)

print(color)