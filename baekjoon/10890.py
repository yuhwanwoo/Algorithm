s=input()

dic=dict()

for i in range(len(s)):
    dic[s[i]]=dic.get(s[i],-1)
    if dic[s[i]]==-1:
        dic[s[i]]=i

for i in range(26):
    print(dic.get(chr(ord('a')+i),-1))