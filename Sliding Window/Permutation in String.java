class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(isPerm(s1, s2.substring(i, i + s1.length()))){
                return true;
            }
        }
        return false;
    }
    public boolean isPerm(String s1, String s2){
        int[] c1 = new int[26];
        for(char c : s1.toCharArray())
            c1[c - 'a']++;
        for(char c : s2.toCharArray())
            c1[c - 'a']--;
        for(int n : c1)
            if(n != 0) return false;
        return true;
    }
}
/*
would be more efficient to create 2 hashmaps <char int> fill with each letter and 0 and track with total matches
return true if ever 26
reduce time complexity to n from x*26(n)
something like:
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for(int i = 0; i < 26; i++){
            m1.put(i, 0);
            m2.put(i, 0);
        }
        for(char c : s1.toCharArray()){
            int i = m1.get(c - 'a');
            m1.put(c - 'a', i + 1);
        }

        String s3 = s2.substring(0, s1.length());
        for(char c : s3.toCharArray()){
            int i = m2.get(c - 'a');
            m2.put(c - 'a', i + 1);
        }
            
        int matches = 0;
        for(int i = 0; i < 26; i++)
            if(m1.get(i) == m2.get(i)) matches++;
        if(matches == 26) return true;

        for(int i = 1; i <= s2.length() - s1.length(); i++){
            int a = s2.charAt(i - 1) - 'a';
            int b = s2.charAt(i + s1.length()) - 'a';
            
            int y = m2.get(a);
            m2.put(a, y - 1);
            if(m1.get(a) == m2.get(a)) matches--;
            else matches++;

            int z = m2.get(b);
            m2.put(b, z + 1);
            if(m2.get(b) == m2.get(b)) matches++;
            else matches--;

            if(matches == 26) return true;
        }
        return false;

        
*/
