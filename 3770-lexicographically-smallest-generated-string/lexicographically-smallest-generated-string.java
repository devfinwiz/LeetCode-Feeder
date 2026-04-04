class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] res = new char[n + m - 1];
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'T'){
                for(int j = 0; j < m; j++){
                    if(res[i + j] != '\u0000' && res[i + j] != str2.charAt(j)){
                        return "";
                    }
                    res[i + j] = str2.charAt(j);
                }
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i] == '\u0000'){
                for(char c = 'a'; c <= 'z'; c++){
                    res[i] = c;
                    boolean valid = true;
                    for(int start = Math.max(0, i - m + 1); start <= Math.min(i, n - 1); start++){
                        if(str1.charAt(start) == 'F'){
                            boolean same = true;
                            for(int j = 0; j < m; j++){
                                if(res[start + j] == '\u0000' || res[start + j] != str2.charAt(j)){
                                    same = false;
                                    break;
                                }
                            }
                            if(same){
                                valid = false;
                                break;
                            }
                        }
                    }

                    if(valid) break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            boolean same = true;
            for(int j = 0; j < m; j++){
                if(res[i + j] != str2.charAt(j)){
                    same = false;
                    break;
                }
            }

            if(str1.charAt(i) == 'T' && !same) return "";
            if(str1.charAt(i) == 'F' && same) return "";
        }
        return new String(res);
    }
}