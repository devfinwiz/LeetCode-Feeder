class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // char[]arr1=s1.toCharArray();
        // char[]arr2=s2.toCharArray();
        // int i=0,j=2;
        // while(j<s2.length()){
        //     if(arr1[i]==arr2[j]){
        //         continue;
        //     }
        //     else{
        //         char temp=arr1[i];
        //         arr1[i]=arr2[i];
        //         arr2[i]=temp;
        //     }
        //     j++;
        // }
        // return Arrays.equals(arr1,arr2);
        boolean one=(s1.charAt(0)==s2.charAt(0)&&s1.charAt(2)==s2.charAt(2))||(s1.charAt(0)==s2.charAt(2)&&s1.charAt(2)==s2.charAt(0));
        boolean two=(s1.charAt(1)==s2.charAt(1)&&s1.charAt(3)==s2.charAt(3))||(s1.charAt(1)==s2.charAt(3)&&s1.charAt(3)==s2.charAt(1));
        return one&&two;
    }
}