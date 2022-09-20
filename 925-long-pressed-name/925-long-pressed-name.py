from collections import Counter
from itertools import groupby

class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        hold=0
        for i in name:
            try:
                hold=typed.index(i,hold)+1
            except:
                return False
        
        nc,nty=dict(Counter(name)),dict(Counter(typed))
        
        nameval,typedval=list(nc.values()),list(nty.values())
        namekey,typekey=list(nc.keys()),list(nty.keys())
        
        groupname,grouptyped=groupby(name),groupby(typed)
        gname,gtyped=[x for x in groupname],[y for y in grouptyped]
        
        if(len(gname)!=len(gtyped)):
            return False
        
        if(len(typedval)!=len(nameval)):
                return False
            
        for i in range(len(namekey)):
            if(namekey[i]!=typekey[i]):
                return False
            
        for i in range(len(nameval)):
            if(typedval[i]<nameval[i]):
                return False
        
        return True