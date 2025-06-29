nums=[[5,24],
          [39,60],
          [5,28],
          [27,40],
          [50,90]]
sortData=sorted(nums,key=lambda x:x[0])
ans=[]
ans.append(sortData[0])
secondEle=sortData[0][1]
for i in range(1,len(nums)):
    if(secondEle<sortData[i][0]):
        ans.append(sortData[i])
        secondEle=sortData[i][1]
print(ans)
