class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int n = str1.length;
        int m = str2.length;
        if(n == m){
            for(int i=0;i<n;i++){
                int num1 = Integer.parseInt(str1[i]);
                int num2 = Integer.parseInt(str2[i]);
                if(num1 > num2) return 1;
                if(num1 < num2) return -1;
            }
        }
        if(n > m){
            for(int i = 0;i<m;i++){
                int num1 = Integer.parseInt(str1[i]);
                int num2 = Integer.parseInt(str2[i]);
                if(num1 > num2) return 1;
                if(num1 < num2) return -1;
            }
            for(int i=m;i<n;i++){
                if(Integer.parseInt(str1[i]) > 0) return 1;
            }
        }
        if(n < m){
            for(int i=0;i<n;i++){
                int num1 = Integer.parseInt(str1[i]);
                int num2 = Integer.parseInt(str2[i]);
                if(num1 > num2) return 1;
                if(num1 < num2) return -1;
            }
            for(int i=n;i<m;i++){
                if(Integer.parseInt(str2[i]) > 0) return -1;
            }
        }
        return 0;
    }
}