/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false*/

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> set= new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(char ch : s.toCharArray()){
            set.put(ch,set.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){
            if(!set.containsKey(ch)){
                return false;
            }
            set.put(ch,set.get(ch)-1);
            if(set.get(ch)==0){
                set.remove(ch);
            }
        }
        return set.isEmpty();
    }
}
