class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> characterCount = new HashMap<>();
        int res = 0;

        int l=0, maxf=0;
        for (int r=0; r<s.length();r++){
            //building the character hashmap
            characterCount.put(s.charAt(r),characterCount.getOrDefault(s.charAt(r),0)+1);

            //fetching the highest freq count
            maxf = Math.max(maxf,characterCount.get(s.charAt(r)));

            // window size - maximum count of a single character > k
            while ((r-l+1)-maxf>k){
               characterCount.put(s.charAt(l),characterCount.get(s.charAt(l))-1);
               l++; 
            }

            res = Math.max(res,r-l+1);
        }

        return res;
        
    }
}
