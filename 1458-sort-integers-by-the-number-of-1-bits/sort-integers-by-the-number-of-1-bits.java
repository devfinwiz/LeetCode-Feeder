class Solution {
    public int countBits(int num){
        int cnt=0;
        while(num>0){
            num&=num-1;
            cnt++;
        }
        return cnt;
    }
    public int[] sortByBits(int[] arr) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<32;i++){
            ans.add(new ArrayList<>());
        }
        for(int num:arr){
            ans.get(countBits(num)).add(num);
        }
        for(ArrayList<Integer> list:ans){
            Collections.sort(list);
        }
        int ind=0;        
        for(int i=0;i<32;i++){
            for(int num:ans.get(i)){
                arr[ind++]=num;
            }
        }
        return arr;
    }
}