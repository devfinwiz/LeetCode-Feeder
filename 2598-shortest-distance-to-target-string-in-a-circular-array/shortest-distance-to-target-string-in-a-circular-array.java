class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int len=words.length;
        int ans=len;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                int disst=Math.abs(i-startIndex);
                ans=Math.min(ans,Math.min(disst,len-disst));
            }
        }
        return ans<len?ans:-1;
    }
}

// class Solution {

//     public int closestTarget(String[] words, String target, int startIndex) {
//         int ans = words.length;
//         int n = words.length;

//         for (int i = 0; i < n; ++i) {
//             if (words[i].equals(target)) {
//                 int dist = Math.abs(i - startIndex);
//                 ans = Math.min(ans, Math.min(dist, n - dist));
//             }
//         }
//         return ans < n ? ans : -1;
//     }
// }