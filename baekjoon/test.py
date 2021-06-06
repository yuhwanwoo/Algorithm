import bisect

arr=[1,2,4,4,5]

idx=bisect.bisect(arr,3)
print(idx)
print(arr)