plain=input()
enc=input()

len_pl=len(plain)
len_en=len(enc)

if len_en<len_pl:
    leng=len_pl-len_en
    for i in range(leng):
        enc+=enc[i]

answer=""

for i in range(len_pl):
    if plain[i]==' ':
        answer+=" "
    else:
        temp=ord(plain[i])-ord(enc[i])
        if temp>0:
            answer+=chr(ord('a')+temp-1)
        else:
            answer+=chr(ord('z')+temp)
print(answer)