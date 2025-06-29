coins=[1,2,5,10,20,50,100,500,2000]
v=int(input("enter v value :"))
coins=coins[::-1]
count=0
for x in coins:
        while x<=v:
            count+=1
            v-=x
print(count)



    