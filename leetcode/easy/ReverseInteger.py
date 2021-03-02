class Solution:
    def reverse(self, x: int) -> int:
        
        minus=""
        if str(x)[0]=="-":
            minus="-"
            x=abs(x)
        
        temp=list(map(str,str(x)))
        temp.reverse()
        answer=int(minus+''.join(temp))

        if -2**31 >answer or answer>2**31-1:
            return 0
        
        return answer



x=-123
x=1534236469
a = Solution()

print(a.reverse(x))