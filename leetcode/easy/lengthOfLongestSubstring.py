def lengthOfLongestSubstring(s):
    answer, leng, st, end, size = 0, 0, 0, 0, len(s)
    dic = dict()
    if size == 1 or size == 0:
        return size
    while(True):
        if st == size - 1:
            break
        if end == size:
            st += 1
            end = st + 1
            continue
        if s[end] in dic.keys():
            del dic[s[st]]
            leng -= 1
            st += 1
        else:
            dic[s[end]] = 1
            leng += 1
            end += 1
        answer = max(answer, leng)
    
    return answer



# s = "abcabcbb" 
#    01234
# s = "bbbbb"
s = "pwwkew"
# s = "au"
# s = "aab"
# s = "abba"
print(lengthOfLongestSubstring(s))