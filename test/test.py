import requests

response=requests.get(url="https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tsk_13f6baf1ef594f9d8a53654b6d30c8a4")

data=response.json()

symbols=[]
for i in data:
    symbols.append(i["symbol"])

print(symbols)