class Solution {
    public int rotatedDigits(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            String s=String.valueOf(i);
            boolean valid = true;
            boolean changed = false;
            for (char ch : s.toCharArray()) {
                if (ch == '3' || ch == '4' || ch == '7') {
                    valid = false;
                    break;
                }
                if (ch == '2' || ch == '5' || ch == '6' || ch == '9') {
                    changed = true;
                }
            }

            if (valid && changed) {
                sum++;
            }
        }
        return sum;
    }
}