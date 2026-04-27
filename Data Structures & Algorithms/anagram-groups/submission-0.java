class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //So we have a list of strings
        //Firstly We'll need to partition that list of Strings into multiple arrays
        //of strings with the same string length
        Map<String, List<String>> reference = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26];
            for (char c: s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            reference.putIfAbsent(key, new ArrayList<>());
            reference.get(key).add(s);    
        }
    return new ArrayList<>(reference.values()) ;
        
    }
}
