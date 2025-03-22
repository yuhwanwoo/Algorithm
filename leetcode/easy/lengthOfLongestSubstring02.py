def lengthOfLongestSubstring(s):
    answer = 0
    dic = dict()
    tmpSum = 0
    for i in range(len(s)):
        now = s[i]
        if now in dic.keys():
            answer = max(answer, i - dic[now])
        dic[now] = i
    return answer



# s = "bbbbb"
# s = "pwwkew"
# s = "abcabcbb"
# s = "au"
s = "aab"
print(lengthOfLongestSubstring(s))