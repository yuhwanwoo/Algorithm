import sys

input = sys.stdin.readline

n = int(input())

dic = dict()

for _ in range(n):
    att = input()
    dic[att] = dic.get(att, 0) + 1

for _ in range(n-1):
    finisher = input()
    dic[finisher] -= 1

for key in dic.keys():
    if dic[key] == 1:
        print(key)