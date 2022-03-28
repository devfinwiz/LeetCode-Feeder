class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        
        i1=0
        i2=0
        summ=0
        count=0
        res=[]
        res2=dict()
        res3=[]
        
        for i in list1:
            if (i in list2):
                i1=list1.index(i)
                i2=list2.index(i)
                summ=i1+i2
                res2[i]=summ
        
        
        mini=min(res2,key=res2.get)
        
        print(res2)
        for i,j in res2.items():
            if(res2[mini]==j):
                res3.append(i)
        
        return res3
        
                