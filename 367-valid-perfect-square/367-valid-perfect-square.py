class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left=1
        right=num

        while(left<=right):
            mid=(left+right)//2
            
            if(mid*mid==num):
                return True
            if(num>mid*mid):
                left=mid+1
            if(num<mid*mid):
                right=mid-1
        return False