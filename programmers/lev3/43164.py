from collections import deque

def solution(tickets):
    answer = []

    bean=[[]]

    visited=[False]*len(tickets)

    sort=sorted(tickets)
    temp=[]
    for i in range(len(sort)):
        if sort[i][0]=="ICN":
            dfs(sort,i,temp,visited,sort[i][1],1)
    
    return answer

def dfs(sort,i,test,visited,loc,depth):
    

    

tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL","ICN"],["ATL","SFO"]]
#tickets=[['ICN','BOO' ], [ 'ICN', 'COO' ], [ 'COO', 'DOO' ], ['DOO', 'COO'], [ 'BOO', 'DOO'] ,['DOO', 'BOO'], ['BOO', 'ICN' ], ['COO', 'BOO']]
#print(sorted(tickets))
# [ICN, ATL, ICN, SFO, ATL, SFO]
solution(tickets)
