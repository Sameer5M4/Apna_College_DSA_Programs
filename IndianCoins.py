coins=[1,2,5,10,20,50,100,500,2000]
v=int(intput("enter v value"))
i,j=0,len(coins)-1
while i<j :
  if(coins[j]<v):
    sum=coins[j]
    j+=1
  if coint[i