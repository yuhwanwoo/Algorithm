### deque

1. deque에는 mexlen도 설정할수 있다
   * ex) deque(maxlen=5)

### for 여러가지 예
```python
for i in range(len(tickets)):
    print(tickets[i][1])
for ticket in tickets:
    print(ticket)
    print(ticket[1])
for idx, ticket in enumerate(tickets): # 인덱스랑 같이 뽑을때
    print(idx, ticket, ticket[1])
```



### Dict() 활용 예

```python
tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
routes=dict()
for (start, end) in tickets:
    #routes라는 dict에 출발지 key
    # 이렇게 하면
    # routes["ICN"]=["SFO","ATL"]
    # routes["SFO"]=["ATL"] 이런식으로 리스트가 만들어짐 
    print(start, end) # tickets[0]=["ICN", "SFO"] => start="ICN", end="SFO"
    routes[start] = routes.get(start, []) + [end] #리스트+리스트는 합쳐진 리스트기때문에 [end] []를씌워야함 아니면 그냥 원소값으로 들어감
    print(routes[start])

example=dict()
exam=[1,2,3,4,1]
for i in exam:
    example[i]=example.get(i,"")+"가" # key가 i 즉,1,2,3,4 || example[1]에 값이 없으면 "" 만약 있으면 기존에 value값에 +"가"를 해준다

print(example) # {1: '가가', 2: '가', 3: '가', 4: '가'}
```

##### - dic set() 초기화 하여 사용

```python
win = {x:set() for x in range(1, n+1)}
## print(win)  >>  {1: set(), 2: set(), 3: set(), 4: set(), 5: set()}

for winner, loser in results:
    win[winner].add(loser)
for winner in lose[i]:
	win[winner].update(win[i])

# 다른 방법
# 이런 것도 있더라 - dict에서 자동으로 set만드는 거
from collections import defaultdict
wins = defaultdict(set)
loses = defaultdict(set)

win[winner].add(loser)
win[winner].update(win[i])
```



### 리스트를 문자열로 변환

```python
list=['H','E','L','L','O']

print(''.join(list)) # HELLO
print('-'.join(list)) # H-E-L-L-O
print('\n'.join(list))
# H
# E
# L
# L
# O
```



### 알파벳인지 숫자인지 확인하는 법

```python
data=[a,1,2,3]

print(data[0].isalpha())
//True
print(data[0].isdigit())
//False

print(data[1].isalpha())
//False
print(data[1].isdigit())
//True

```



### 날짜 파이썬으로 계산하기

```python
import datetime
from datetime import timedelta # 시간 연산할 때

d=datetime.datetime(2020,1,1,10,24,10)
d=d+timedelta(seconds=20)

d=d.strftime('%H:%M:%S') # %H는 24시간 기준 %I는 12시간 기준
```



### lambda 예시 (더 업데이트 하기)

```python
def strange_sort(strings, n):
    '''strings의 문자열들을 n번째 글자를 기준으로 정렬해서 return하세요'''
    return sorted(strings, key=lambda x: x[n]) #문자의 두번째 알파벳 기준으로 정렬

strings = ["sun", "bed", "car"] 
print(strange_sort(strings, 1))
```

### lambda 정렬

```python
# 문제 참고 백준:국영수 책:A23

# [정렬 기준]
# 1) 두 번째 원소를 기준으로 내림차순 정렬
# 2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
# 3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
# 4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬

students.sort(key=lambda x:(-int(x[1]),int(x[2]),-int(x[3]),x[0]))
```

### zip 함수

```python
x='python'
y='123456'
zip_x_y=zip(x,y)
print(list(zip_x_y))
// [('p', '1'), ('y', '2'), ('t', '3'), ('h', '4'), ('o', '5'), ('n', '6')]

x=[1,2,3,4]
y=['a','b','c','d']
z='ABCD'
zip_x_y_z=zip(x,y,z)
print(list(zip_x_y_z))
// [(1, 'a', 'A'), (2, 'b', 'B'), (3, 'c', 'C'), (4, 'd', 'D')]

x=('a','b','c')
y=[1,2,3,4,5,6,7]
zip_x_y=zip(x,y)
print(list(zip_x_y))
// [('a', 1), ('b', 2), ('c', 3)]
```

### startswith()와 endswith()

```python
#startswith()
>>> new_str = "Hello"
>>> new_str.startswith("H")
True
>>> new_str.startswith("h")
False
>>> new_str.startswith("He")
True


#endswith()
>>> new_str = "World"
>>> new_str.endswith("d")
True
>>> new_str.endswith("D")
False
>>> new_str.endswith("ld")
True
```



### heap

```python
import heapq

h=[]

for i in works:
	heapq.heappush(h,i)

print(h) # [3, 4, 3]

heapq.heappop(h)
```

