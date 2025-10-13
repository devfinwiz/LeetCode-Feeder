class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String before = "";
        for(String s: words){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String sortedString = new String(array);
            if(!sortedString.equals(before)){
                ans.add(s);
                before = sortedString;
            }
        }
        return ans;
    }
}