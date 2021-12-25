def solution(encrypted_text, key, rotation):
    answer = ''
    temp_char=[]
    if rotation>=0:
        r = rotation % len(key)
    else:
        r=-(abs(rotation) % len(key))

    encrypted_text=encrypted_text[r:]+encrypted_text[:r]
    print(encrypted_text)
    for i in range(len(encrypted_text)):
        stan=(ord(encrypted_text[i]))-(ord(key[i]))
        a-z=-25
        if stan<0:
            stan=((stan)+26)%26
        elif stan==0:
            stan=26
        else:
            stan=stan%26
        
        temp_char.append(chr(stan+96))
        
    
    answer="".join(temp_char)
    print(answer)
    return answer

encrypted_text="qyyigoptvfb"
key="abcdefghijk"
rotation=3

# encrypted_text="e"
# key="a"
# rotation=0
solution(encrypted_text,key,rotation)
