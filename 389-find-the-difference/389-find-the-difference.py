class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        
        
        s_list=list()
        t_list=list()
        
        for i in s:
            s_list.append(i)
            
        for i in t:
            t_list.append(i)
            
        s_list.sort()
        t_list.sort()
        
        ssorted=""
        tsorted=""
        
        for i in s_list:
            ssorted+=i
        for j in t_list:
            tsorted+=j
            
        for i in range(0,len(ssorted)):
            if(ssorted[i]!=tsorted[i]):
                return tsorted[i]
        
        return tsorted[-1]
            
        