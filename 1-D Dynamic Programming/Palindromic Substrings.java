class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len == 1) return 1;

        int count = 0;

        for(int i = 0; i < len; i++){
            int l = i;
            int r = i;

            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        
        return count;
    }
}
