import json
import requests

def topArticles(limit):
    # Write your code here
    num=2
    target="https://jsonmock.hackerrank.com/api/articles?page="+str(num)
    response=requests.get(url=target)
    
    data=response.json()
    arti_list=[]
    print(data['data'])

limit=2
topArticles(limit)