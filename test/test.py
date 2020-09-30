import pandas as pd

sym = "TSLA"  # This is not case-sensitive
token = "pk_e49a09f4223c458fb2144f18f3bb17b1"
df_temp = pd.read_json('https://cloud.iexapis.com/stable/stock/'+sym+'/chart/1y?token='+token+'')
print(df_temp)
#print('https://cloud.iexapis.com/stable/stock/'+sym+'/chart/1y?token='+token+'')
#print("https://cloud.iexapis.com/stable/stock/aapl/quote?token="+token)

