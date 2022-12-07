class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        String res = "";
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                int len = right - left + 1;
                if(len > max){
                    max = len;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                int len = right - left + 1;
                if(len > max){
                    max = len;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
